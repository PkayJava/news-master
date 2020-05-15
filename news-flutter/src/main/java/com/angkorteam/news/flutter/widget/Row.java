package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

public class Row extends Widget<RowAttribute> {

    public Row(Entry<RowAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<RowAttribute, Object> children(Widget... children) {
        return new Entry<>(RowAttribute.children, children);
    }

    @Override
    public void store(DSLContext context, Page page) {
        store(context, page, RowAttribute.values());
        super.store(context, page);
    }
}
