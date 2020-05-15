package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.ObjectAttributeTable;
import com.angkorteam.news.dao.tables.records.ObjectAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.AttrType;
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
        ObjectAttributeRecord attr = context.newRecord(ObjectAttributeTable.INSTANCE);
        attr.setUuid(UUID.randomUUID().toString());
        attr.setPageUuid(page.getUuid());
        attr.setObjectUuid(this.uuid);
        attr.setAttrName("icon");
        attr.setAttrType(AttrType.Simple.name());
        attr.setAttrValue(this.icon.name());
        attr.store();
        super.store(context, page);
    }
}
