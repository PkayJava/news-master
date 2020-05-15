package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

public class AppBar extends Widget<AppBarAttribute> {

    public AppBar(Entry<AppBarAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<AppBarAttribute, Object> title(Widget title) {
        return new Entry<>(AppBarAttribute.title, title);
    }

    @Override
    public void store(DSLContext context, Page page) {
        store(context, page, AppBarAttribute.values());
        super.store(context, page);
    }

}
