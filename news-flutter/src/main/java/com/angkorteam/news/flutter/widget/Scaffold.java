package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.WidgetAttributeTable;
import com.angkorteam.news.dao.tables.records.WidgetAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

import java.util.UUID;

public class Scaffold extends Widget<ScaffoldAttribute> {

    public Scaffold(Entry<ScaffoldAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<ScaffoldAttribute, Object> appBar(Widget appBar) {
        return new Entry<>(ScaffoldAttribute.appBar, appBar);
    }

    public static Entry<ScaffoldAttribute, Object> body(Widget body) {
        return new Entry<>(ScaffoldAttribute.body, body);
    }

    public static Entry<ScaffoldAttribute, Object> floatingActionButton(Widget floatingActionButton) {
        return new Entry<>(ScaffoldAttribute.floatingActionButton, floatingActionButton);
    }

    @Override
    public void store(DSLContext context, Page page) {
        if (this._attrs.containsKey(ScaffoldAttribute.appBar)) {
            Widget appBar = (Widget) this._attrs.get(ScaffoldAttribute.appBar);
            appBar.store(context, page);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(ScaffoldAttribute.appBar.name());
            attr.setAttrValue(appBar.getUuid());
            attr.store();
        }
        if (this._attrs.containsKey(ScaffoldAttribute.body)) {
            Widget body = (Widget) this._attrs.get(ScaffoldAttribute.body);
            body.store(context, page);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(ScaffoldAttribute.body.name());
            attr.setAttrValue(body.getUuid());
            attr.store();
        }
        if (this._attrs.containsKey(ScaffoldAttribute.floatingActionButton)) {
            Widget floatingActionButton = (Widget) this._attrs.get(ScaffoldAttribute.floatingActionButton);
            floatingActionButton.store(context, page);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(ScaffoldAttribute.floatingActionButton.name());
            attr.setAttrValue(floatingActionButton.getUuid());
            attr.store();
        }
        super.store(context, page);
    }

}
