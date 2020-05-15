package com.angkorteam.news.flutter;

import com.angkorteam.news.dao.tables.PageTable;
import com.angkorteam.news.dao.tables.records.PageRecord;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

import java.util.UUID;

public class Page {

    private final String uuid;

    private String title;

    private Widget widget;

    public Page(String uuid) {
        this.uuid = uuid;
    }

    public Page() {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public String getUuid() {
        return uuid;
    }

    public Widget getWidget() {
        return widget;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public void store(DSLContext context) {
        PageRecord pageRecord = context.newRecord(PageTable.INSTANCE);
        pageRecord.setUuid(this.uuid);
        pageRecord.setObjectUuid(this.widget.getUuid());
        pageRecord.setTitle(this.title);
        pageRecord.store();
        this.widget.store(context, this);
    }

}
