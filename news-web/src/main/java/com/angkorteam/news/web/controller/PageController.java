package com.angkorteam.news.web.controller;

import com.angkorteam.news.dao.tables.daos.PageDAO;
import com.angkorteam.news.dao.tables.daos.WidgetAttributeDAO;
import com.angkorteam.news.dao.tables.daos.WidgetDAO;
import com.angkorteam.news.dao.tables.pojos.PageObject;
import com.angkorteam.news.dao.tables.pojos.WidgetAttributeObject;
import com.angkorteam.news.dao.tables.pojos.WidgetObject;
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

    private final WidgetDAO widgetDAO;

    private final WidgetAttributeDAO widgetAttributeDAO;

    public PageController(PageDAO pageDAO, WidgetDAO widgetDAO, WidgetAttributeDAO widgetAttributeDAO) {
        this.pageDAO = pageDAO;
        this.widgetDAO = widgetDAO;
        this.widgetAttributeDAO = widgetAttributeDAO;
    }

    @RequestMapping(path = "/{uuid}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> detail(@PathVariable("uuid") String uuid) {
        PageObject pageObject = this.pageDAO.fetchOneByUuid(uuid);
        if (pageObject == null) {
            throw new NotFoundException();
        }
        List<WidgetObject> widgetObjectsTemp = this.widgetDAO.fetchByPageUuid(pageObject.getUuid());
        Map<String, WidgetObject> widgetObjects = Maps.uniqueIndex(widgetObjectsTemp, WidgetObject::getUuid);
        Map<String, List<WidgetAttributeObject>> widgetAttributeObjects = new HashMap<>();
        for (WidgetObject item : widgetObjectsTemp) {
            widgetAttributeObjects.put(item.getUuid(), new ArrayList<>());
        }
        List<WidgetAttributeObject> widgetAttributeObjectsTemp = this.widgetAttributeDAO.fetchByPageUuid(pageObject.getUuid());
        for (WidgetAttributeObject item : widgetAttributeObjectsTemp) {
            widgetAttributeObjects.get(item.getWidgetUuid()).add(item);
        }

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("title", pageObject.getTitle());

        Map<String, Object> widget = renderWidget(widgetAttributeObjects, widgetObjects, pageObject.getWidgetUuid());
        if (widget != null) {
            responseBody.put("widget", widget);
        }
        return responseBody;
    }

    private Map<String, Object> renderWidget(Map<String, List<WidgetAttributeObject>> widgetAttributeObjects, Map<String, WidgetObject> widgetObjects, String uuid) {
        WidgetObject widgetObject = widgetObjects.get(uuid);
        if (widgetObject == null) {
            return null;
        }
        Map<String, Object> widget = new HashMap<>();
        widget.put("type", widgetObject.getType());
        if (!widgetAttributeObjects.get(widgetObject.getUuid()).isEmpty()) {
            Map<String, Object> attributes = new HashMap<>();
            for (WidgetAttributeObject item : widgetAttributeObjects.get(widgetObject.getUuid())) {
                attributes.put(item.getAttrName(), item.getAttrValue());
            }
            widget.put("attrs", attributes);
            if (attributes.get("children") != null && !"".equals(attributes.get("children"))) {
                String[] temps = StringUtils.split((String) attributes.get("children"), ',');
                List<Map<String, Object>> children = new ArrayList<>(temps.length);
                for (String temp : temps) {
                    Map<String, Object> child = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                    if (child != null) {
                        children.add(child);
                    }
                }
                if (!children.isEmpty()) {
                    attributes.put("children", children);
                }
            }
            if (attributes.get("child") != null && !"".equals(attributes.get("child"))) {
                String temp = (String) attributes.get("child");
                if (temp != null && !"".equals(temp)) {
                    Map<String, Object> child = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                    if (child != null) {
                        attributes.put("child", child);
                    }
                }
            }
        }
        return widget;
    }

}
