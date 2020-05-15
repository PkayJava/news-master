package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.WidgetAttributeTable;
import com.angkorteam.news.dao.tables.records.WidgetAttributeRecord;
import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

import java.util.UUID;

public class AppBar extends Widget<AppBarAttribute> {

    public AppBar(Entry<AppBarAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<AppBarAttribute, Object> title(Widget title) {
        return new Entry<>(AppBarAttribute.title, title);
    }

    @Override
    public void store(DSLContext context, Page page) {
        if (this._attrs.containsKey(AppBarAttribute.title)) {
            Widget title = (Widget) this._attrs.get(AppBarAttribute.title);
            title.store(context, page);
            WidgetAttributeRecord attr = context.newRecord(WidgetAttributeTable.INSTANCE);
            attr.setUuid(UUID.randomUUID().toString());
            attr.setPageUuid(page.getUuid());
            attr.setWidgetUuid(this.uuid);
            attr.setAttrName(AppBarAttribute.title.name());
            attr.setAttrValue(title.getUuid());
            attr.store();
        }
        super.store(context, page);
    }

}
