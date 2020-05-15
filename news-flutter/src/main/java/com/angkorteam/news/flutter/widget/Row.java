package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.WidgetAttributeTable;
import com.angkorteam.news.dao.tables.records.WidgetAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Row extends Widget<RowAttribute> {

    public Row(Entry<RowAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<RowAttribute, Object> children(Widget... children) {
        return new Entry<>(RowAttribute.children, children);
    }

    @Override
    public void store(DSLContext context, Page page) {
        if (this._attrs.containsKey(RowAttribute.children)) {
            Widget[] children = (Widget[]) this._attrs.get(RowAttribute.children);
            List<String> ids = new ArrayList<>(children.length);
            for (Widget child : children) {
                child.store(context, page);
                ids.add(child.getUuid());
            }
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(RowAttribute.children.name());
            attr.setAttrValue(StringUtils.join(ids, ","));
            attr.store();
        }
        super.store(context, page);
    }
}
