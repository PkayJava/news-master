package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

public class FloatingActionButton extends Widget<FloatingActionButtonAttribute> {

    public FloatingActionButton(Entry<FloatingActionButtonAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<FloatingActionButtonAttribute, Object> child(Widget child) {
        return new Entry<>(FloatingActionButtonAttribute.child, child);
    }

    public static Entry<FloatingActionButtonAttribute, Object> tooltip(String tooltip) {
        return new Entry<>(FloatingActionButtonAttribute.tooltip, tooltip);
    }

    public static Entry<FloatingActionButtonAttribute, Object> onPressed(String onPressed) {
        return new Entry<>(FloatingActionButtonAttribute.onPressed, onPressed);
    }

    @Override
    public void store(DSLContext context, Page page) {
        store(context, page, FloatingActionButtonAttribute.values());
        super.store(context, page);
    }

}
