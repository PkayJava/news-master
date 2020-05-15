package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

public class Scaffold extends Widget<ScaffoldAttribute> {

    public Scaffold(Entry<ScaffoldAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<ScaffoldAttribute, Object> appBar(Widget appBar) {
        return new Entry<>(ScaffoldAttribute.appBar, appBar);
    }

    public static Entry<ScaffoldAttribute, Object> body(Widget body) {
        return new Entry<>(ScaffoldAttribute.body, body);
    }

    public static Entry<ScaffoldAttribute, Object> floatingActionButton(Widget floatingActionButton) {
        return new Entry<>(ScaffoldAttribute.floatingActionButton, floatingActionButton);
    }

    @Override
    public void store(DSLContext context, Page page) {
        store(context, page, ScaffoldAttribute.values());
        super.store(context, page);
    }

}
