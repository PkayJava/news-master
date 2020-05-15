package com.angkorteam.news.web.controller;

import com.angkorteam.news.dao.tables.daos.PageDAO;
import com.angkorteam.news.dao.tables.daos.WidgetAttributeDAO;
import com.angkorteam.news.dao.tables.daos.WidgetDAO;
import com.angkorteam.news.dao.tables.pojos.PageObject;
import com.angkorteam.news.dao.tables.pojos.WidgetAttributeObject;
import com.angkorteam.news.dao.tables.pojos.WidgetObject;
import com.angkorteam.news.flutter.widget.*;
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

    private final WidgetDAO widgetDAO;

    private final WidgetAttributeDAO widgetAttributeDAO;

    private final AppProperties properties;

    public PageController(PageDAO pageDAO, WidgetDAO widgetDAO, WidgetAttributeDAO widgetAttributeDAO, AppProperties properties) {
        this.pageDAO = pageDAO;
        this.widgetDAO = widgetDAO;
        this.widgetAttributeDAO = widgetAttributeDAO;
        this.properties = properties;
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
        if (this.properties.isDebug()) {
            widget.put("__uuid", uuid);
        }
        if (!widgetAttributeObjects.get(widgetObject.getUuid()).isEmpty()) {
            Map<String, Object> attributes = new HashMap<>();
            for (WidgetAttributeObject item : widgetAttributeObjects.get(widgetObject.getUuid())) {
                attributes.put(item.getAttrName(), item.getAttrValue());
            }
            widget.put("attrs", attributes);
            if (Column.class.getSimpleName().equals(widgetObject.getType())) {
                if (attributes.get(ColumnAttribute.children.name()) != null && !"".equals(attributes.get(ColumnAttribute.children.name()))) {
                    String[] temps = StringUtils.split((String) attributes.get(ColumnAttribute.children.name()), ',');
                    List<Map<String, Object>> children = new ArrayList<>(temps.length);
                    for (String temp : temps) {
                        Map<String, Object> child = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (child != null) {
                            children.add(child);
                        }
                    }
                    if (!children.isEmpty()) {
                        attributes.put(ColumnAttribute.children.name(), children);
                    }
                }
            } else if (Row.class.getSimpleName().equals(widgetObject.getType())) {
                if (attributes.get(RowAttribute.children.name()) != null && !"".equals(attributes.get(RowAttribute.children.name()))) {
                    String[] temps = StringUtils.split((String) attributes.get(RowAttribute.children.name()), ',');
                    List<Map<String, Object>> children = new ArrayList<>(temps.length);
                    for (String temp : temps) {
                        Map<String, Object> child = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (child != null) {
                            children.add(child);
                        }
                    }
                    if (!children.isEmpty()) {
                        attributes.put(RowAttribute.children.name(), children);
                    }
                }
            } else if (Scaffold.class.getSimpleName().equals(widgetObject.getType())) {
                if (attributes.get(ScaffoldAttribute.appBar.name()) != null && !"".equals(attributes.get(ScaffoldAttribute.appBar.name()))) {
                    String temp = (String) attributes.get(ScaffoldAttribute.appBar.name());
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> appBar = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (appBar != null) {
                            attributes.put(ScaffoldAttribute.appBar.name(), appBar);
                        }
                    }
                }
                if (attributes.get("drawer") != null && !"".equals(attributes.get("drawer"))) {
                    String temp = (String) attributes.get("drawer");
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> drawer = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (drawer != null) {
                            attributes.put("drawer", drawer);
                        }
                    }
                }
                if (attributes.get(ScaffoldAttribute.body.name()) != null && !"".equals(attributes.get(ScaffoldAttribute.body.name()))) {
                    String temp = (String) attributes.get(ScaffoldAttribute.body.name());
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> body = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (body != null) {
                            attributes.put(ScaffoldAttribute.body.name(), body);
                        }
                    }
                }
                if (attributes.get(ScaffoldAttribute.floatingActionButton.name()) != null && !"".equals(attributes.get(ScaffoldAttribute.floatingActionButton.name()))) {
                    String temp = (String) attributes.get(ScaffoldAttribute.floatingActionButton.name());
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> body = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (body != null) {
                            attributes.put(ScaffoldAttribute.floatingActionButton.name(), body);
                        }
                    }
                }
            } else if (AppBar.class.getSimpleName().equals(widgetObject.getType())) {
                if (attributes.get("leading") != null && !"".equals(attributes.get("leading"))) {
                    String temp = (String) attributes.get("leading");
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> leading = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (leading != null) {
                            attributes.put("leading", leading);
                        }
                    }
                }
                if (attributes.get(AppBarAttribute.title.name()) != null && !"".equals(attributes.get(AppBarAttribute.title.name()))) {
                    String temp = (String) attributes.get(AppBarAttribute.title.name());
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> title = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (title != null) {
                            attributes.put(AppBarAttribute.title.name(), title);
                        }
                    }
                }
            } else if ("Container".equals(widgetObject.getType())) {
                if (attributes.get("child") != null && !"".equals(attributes.get("child"))) {
                    String temp = (String) attributes.get("child");
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> child = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (child != null) {
                            attributes.put("child", child);
                        }
                    }
                }
            } else if (Center.class.getSimpleName().equals(widgetObject.getType())) {
                if (attributes.get(CenterAttribute.child.name()) != null && !"".equals(attributes.get(CenterAttribute.child.name()))) {
                    String temp = (String) attributes.get(CenterAttribute.child.name());
                    if (temp != null && !"".equals(temp)) {
                        Map<String, Object> child = renderWidget(widgetAttributeObjects, widgetObjects, temp);
                        if (child != null) {
                            attributes.put(CenterAttribute.child.name(), child);
                        }
                    }
                }
            }
        }
        return widget;
    }

}
