package com.angkorteam.news.flutter.common;

import com.angkorteam.news.dao.tables.WidgetTable;
import com.angkorteam.news.dao.tables.records.WidgetRecord;
import com.angkorteam.news.flutter.Page;
import org.jooq.DSLContext;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Widget<K extends IAttribute> {

    protected final String uuid;

    protected Map<K, Object> _attrs;

    protected Widget(Entry<K, Object>... attrs) {
        this.uuid = UUID.randomUUID().toString();
        this._attrs = new HashMap<>();
        if (attrs != null && attrs.length > 0) {
            for (Entry<K, Object> attr : attrs) {
                this._attrs.put(attr.getKey(), attr.getValue());
            }
        }
    }

    public final String getUuid() {
        return this.uuid;
    }

    public void store(DSLContext context, Page page) {
        WidgetRecord widgetRecord = context.newRecord(WidgetTable.INSTANCE);
        widgetRecord.setUuid(this.uuid);
        widgetRecord.setPageUuid(page.getUuid());
        widgetRecord.setType(getClass().getSimpleName());
        widgetRecord.store();
    }

}
