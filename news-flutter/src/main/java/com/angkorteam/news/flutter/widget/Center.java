package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.WidgetAttributeTable;
import com.angkorteam.news.dao.tables.records.WidgetAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

import java.util.UUID;

public class Center extends Widget<CenterAttribute> {

    public Center(Entry<CenterAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<CenterAttribute, Object> child(Widget child) {
        return new Entry<>(CenterAttribute.child, child);
    }

    @Override
    public void store(DSLContext context, Page page) {
        if (this._attrs.containsKey(CenterAttribute.child)) {
            Widget child = (Widget) this._attrs.get(CenterAttribute.child);
            child.store(context, page);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(CenterAttribute.child.name());
            attr.setAttrValue(child.getUuid());
            attr.store();
        }
        super.store(context, page);
    }

}
