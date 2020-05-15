package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.WidgetAttributeTable;
import com.angkorteam.news.dao.tables.records.WidgetAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.MainAxisAlignment;
import com.angkorteam.news.flutter.common.Widget;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Column extends Widget<ColumnAttribute> {

    public Column(Entry<ColumnAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<ColumnAttribute, Object> mainAxisAlignment(MainAxisAlignment mainAxisAlignment) {
        return new Entry<>(ColumnAttribute.mainAxisAlignment, mainAxisAlignment);
    }

    public static Entry<ColumnAttribute, Object> children(Widget... children) {
        return new Entry<>(ColumnAttribute.children, children);
    }

    @Override
    public void store(DSLContext context, Page page) {
        if (this._attrs.containsKey(ColumnAttribute.mainAxisAlignment)) {
            MainAxisAlignment mainAxisAlignment = (MainAxisAlignment) this._attrs.get(ColumnAttribute.mainAxisAlignment);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(ColumnAttribute.mainAxisAlignment.name());
            attr.setAttrValue(mainAxisAlignment.name());
            attr.store();
        }
        if (this._attrs.containsKey(ColumnAttribute.children)) {
            Widget[] children = (Widget[]) this._attrs.get(ColumnAttribute.children);
            List<String> ids = new ArrayList<>(children.length);
            for (Widget child : children) {
                child.store(context, page);
                ids.add(child.getUuid());
            }
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(ColumnAttribute.children.name());
            attr.setAttrValue(StringUtils.join(ids, ","));
            attr.store();
        }
        super.store(context, page);
    }
}
