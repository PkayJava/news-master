package com.angkorteam.news.web.controller;

import com.angkorteam.news.dao.tables.daos.ObjectAttributeDAO;
import com.angkorteam.news.dao.tables.daos.ObjectDAO;
import com.angkorteam.news.dao.tables.daos.PageDAO;
import com.angkorteam.news.dao.tables.pojos.ObjectAttributeObject;
import com.angkorteam.news.dao.tables.pojos.ObjectObject;
import com.angkorteam.news.dao.tables.pojos.PageObject;
import com.angkorteam.news.flutter.common.AttrType;
import com.angkorteam.news.web.boot.AppProperties;
import com.angkorteam.news.web.exception.NotFoundException;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/page")
public class PageController {

    private final PageDAO pageDAO;

    private final ObjectDAO objectDAO;

    private final ObjectAttributeDAO objectAttributeDAO;

    private final AppProperties properties;

    public PageController(PageDAO pageDAO, ObjectDAO objectDAO, ObjectAttributeDAO objectAttributeDAO, AppProperties properties) {
        this.pageDAO = pageDAO;
        this.objectDAO = objectDAO;
        this.objectAttributeDAO = objectAttributeDAO;
        this.properties = properties;
    }

    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> detail(@PathVariable("uuid") String uuid) {
        PageObject pageObject = this.pageDAO.fetchOneByUuid(uuid);
        if (pageObject == null) {
            throw new NotFoundException();
        }
        List<ObjectObject> objectObjectsTemp = this.objectDAO.fetchByPageUuid(pageObject.getUuid());
        Map<String, ObjectObject> objectObjects = Maps.uniqueIndex(objectObjectsTemp, ObjectObject::getUuid);
        Map<String, List<ObjectAttributeObject>> objectAttributeObjects = new HashMap<>();
        for (ObjectObject item : objectObjectsTemp) {
            objectAttributeObjects.put(item.getUuid(), new ArrayList<>());
        }
        List<ObjectAttributeObject> objectAttributeObjectsTemp = this.objectAttributeDAO.fetchByPageUuid(pageObject.getUuid());
        for (ObjectAttributeObject item : objectAttributeObjectsTemp) {
            objectAttributeObjects.get(item.getObjectUuid()).add(item);
        }

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("title", pageObject.getTitle());

        Map<String, Object> object = renderObject(objectAttributeObjects, objectObjects, pageObject.getObjectUuid());
        if (object != null) {
            responseBody.put("object", object);
        }
        return responseBody;
    }

    private Map<String, Object> renderObject(Map<String, List<ObjectAttributeObject>> objectAttributeObjects, Map<String, ObjectObject> objectObjects, String uuid) {
        ObjectObject objectObject = objectObjects.get(uuid);
        if (objectObject == null) {
            return null;
        }
        Map<String, Object> object = new HashMap<>();
        object.put("type", objectObject.getType());
        if (this.properties.isDebug()) {
            object.put("__uuid", uuid);
        }
        if (!objectAttributeObjects.get(objectObject.getUuid()).isEmpty()) {
            Map<String, Object> attributes = new HashMap<>();
            for (ObjectAttributeObject item : objectAttributeObjects.get(objectObject.getUuid())) {
                if (item.getAttrType().equals(AttrType.Simple.name())) {
                    attributes.put(item.getAttrName(), item.getAttrValue());
                } else if (item.getAttrType().equals(AttrType.Object.name())) {
                    String temp = item.getAttrValue();
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> widget = renderObject(objectAttributeObjects, objectObjects, temp);
                        if (widget != null) {
                            attributes.put(item.getAttrName(), widget);
                        }
                    }
                } else if (item.getAttrType().equals(AttrType.Array.name())) {
                    String[] temps = StringUtils.split(item.getAttrValue(), ',');
                    List<Map<String, Object>> children = new ArrayList<>(temps.length);
                    for (String temp : temps) {
                        Map<String, Object> child = renderObject(objectAttributeObjects, objectObjects, temp);
                        if (child != null) {
                            children.add(child);
                        }
                    }
                    if (!children.isEmpty()) {
                        attributes.put(item.getAttrName(), children);
                    }
                }
            }
            object.put("attrs", attributes);
        }
        return object;
    }

}
