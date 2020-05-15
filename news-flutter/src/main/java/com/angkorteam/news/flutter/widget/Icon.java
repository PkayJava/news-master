package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.WidgetAttributeTable;
import com.angkorteam.news.dao.tables.records.WidgetAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Icons;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

import java.util.UUID;

public class Icon extends Widget<IconAttribute> {

    private Icons icon;

    public Icon(Icons icon, Entry<IconAttribute, Object>... attrs) {
        super(attrs);
        this.icon = icon;
    }

    @Override
    public void store(DSLContext context, Page page) {
        WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
        attr.setUuid(UUID.randomUUID().toString());
        attr.setPageUuid(page.getUuid());
        attr.setWidgetUuid(this.uuid);
        attr.setAttrName("icon");
        attr.setAttrValue(this.icon.name());
        attr.store();

        super.store(context, page);
    }
}
