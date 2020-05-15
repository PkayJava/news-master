package com.angkorteam.news.flutter.common;

import com.angkorteam.news.dao.tables.ObjectAttributeTable;
import com.angkorteam.news.dao.tables.ObjectTable;
import com.angkorteam.news.dao.tables.records.ObjectAttributeRecord;
import com.angkorteam.news.dao.tables.records.ObjectRecord;
import com.angkorteam.news.flutter.Page;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;

import java.util.*;

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
        ObjectRecord widgetRecord = context.newRecord(ObjectTable.INSTANCE);
        widgetRecord.setUuid(this.uuid);
        widgetRecord.setPageUuid(page.getUuid());
        widgetRecord.setType(getClass().getSimpleName());
        widgetRecord.store();
    }

    public final void store(DSLContext context, Page page, K[] attrs) {
        for (K attr : attrs) {
            if (this._attrs.containsKey(attr)) {
                if (attr.getType() == AttrType.Simple) {
                    Object object = this._attrs.get(attr);
                    ObjectAttributeRecord _attr = context.newRecord(ObjectAttributeTable.INSTANCE);
                    _attr.setUuid(UUID.randomUUID().toString());
                    _attr.setPageUuid(page.getUuid());
                    _attr.setObjectUuid(this.uuid);
                    _attr.setAttrName(attr.name());
                    _attr.setAttrType(attr.getType().name());
                    _attr.setAttrValue(object instanceof Enum ? ((Enum) object).name() : object.toString());
                    _attr.store();
                } else if (attr.getType() == AttrType.Array) {
                    Widget[] children = (Widget[]) this._attrs.get(attr);
                    List<String> ids = new ArrayList<>(children.length);
                    for (Widget child : children) {
                        child.store(context, page);
                        ids.add(child.getUuid());
                    }
                    ObjectAttributeRecord _attr = context.newRecord(ObjectAttributeTable.INSTANCE);
                    _attr.setUuid(UUID.randomUUID().toString());
                    _attr.setPageUuid(page.getUuid());
                    _attr.setObjectUuid(this.uuid);
                    _attr.setAttrName(attr.name());
                    _attr.setAttrType(attr.getType().name());
                    _attr.setAttrValue(StringUtils.join(ids, ","));
                    _attr.store();
                } else if (attr.getType() == AttrType.Object) {
                    Widget widget = (Widget) this._attrs.get(attr);
                    widget.store(context, page);
                    ObjectAttributeRecord _attr = context.newRecord(ObjectAttributeTable.INSTANCE);
                    _attr.setUuid(UUID.randomUUID().toString());
                    _attr.setPageUuid(page.getUuid());
                    _attr.setObjectUuid(this.uuid);
                    _attr.setAttrName(attr.name());
                    _attr.setAttrType(attr.getType().name());
                    _attr.setAttrValue(widget.getUuid());
                    _attr.store();
                }
            }
        }
    }


}
