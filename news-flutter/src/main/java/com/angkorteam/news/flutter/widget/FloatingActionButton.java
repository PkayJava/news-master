package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.WidgetAttributeTable;
import com.angkorteam.news.dao.tables.records.WidgetAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

import java.util.UUID;

public class FloatingActionButton extends Widget<FloatingActionButtonAttribute> {

    public FloatingActionButton(Entry<FloatingActionButtonAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<FloatingActionButtonAttribute, Object> child(Widget child) {
        return new Entry<>(FloatingActionButtonAttribute.child, child);
    }

    public static Entry<FloatingActionButtonAttribute, Object> tooltip(String tooltip) {
        return new Entry<>(FloatingActionButtonAttribute.tooltip, tooltip);
    }

    public static Entry<FloatingActionButtonAttribute, Object> onPressed(String onPressed) {
        return new Entry<>(FloatingActionButtonAttribute.onPressed, onPressed);
    }

    @Override
    public void store(DSLContext context, Page page) {
        if (this._attrs.containsKey(FloatingActionButtonAttribute.tooltip)) {
            String tooltip = (String) this._attrs.get(FloatingActionButtonAttribute.tooltip);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(FloatingActionButtonAttribute.tooltip.name());
            attr.setAttrValue(tooltip);
            attr.store();
        }
        if (this._attrs.containsKey(FloatingActionButtonAttribute.onPressed)) {
            String onPressed = (String) this._attrs.get(FloatingActionButtonAttribute.onPressed);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(FloatingActionButtonAttribute.onPressed.name());
            attr.setAttrValue(onPressed);
            attr.store();
        }
        if (this._attrs.containsKey(FloatingActionButtonAttribute.child)) {
            Widget child = (Widget) this._attrs.get(FloatingActionButtonAttribute.child);
            child.store(context, page);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(FloatingActionButtonAttribute.child.name());
            attr.setAttrValue(child.getUuid());
            attr.store();
        }
        super.store(context, page);
    }

}
