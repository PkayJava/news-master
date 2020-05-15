package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.dao.tables.ObjectAttributeTable;
import com.angkorteam.news.dao.tables.records.ObjectAttributeRecord;
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
        store(context, page, ColumnAttribute.values());
        super.store(context, page);
    }
}
