package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.ObjectAttributeTable;
import com.angkorteam.news.dao.tables.records.ObjectAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.AttrType;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

import java.util.UUID;

public class Text extends Widget<TextAttribute> {

    private String data;

    public Text(String data, Entry<TextAttribute, Object>... attrs) {
        super(attrs);
        this.data = data;
    }

    @Override
    public void store(DSLContext context, Page page) {
        ObjectAttributeRecord attr = context.newRecord(ObjectAttributeTable.INSTANCE);
        attr.setUuid(UUID.randomUUID().toString());
        attr.setPageUuid(page.getUuid());
        attr.setObjectUuid(this.uuid);
        attr.setAttrName("data");
        attr.setAttrType(AttrType.Simple.name());
        attr.setAttrValue(this.data);
        attr.store();
        super.store(context, page);
    }

}
