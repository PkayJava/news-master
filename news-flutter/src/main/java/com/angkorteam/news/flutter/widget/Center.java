package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.Page;
import com.angkorteam.news.flutter.common.Entry;
import com.angkorteam.news.flutter.common.Widget;
import org.jooq.DSLContext;

public class Center extends Widget<CenterAttribute> {

    public Center(Entry<CenterAttribute, Object>... attrs) {
        super(attrs);
    }

    public static Entry<CenterAttribute, Object> child(Widget child) {
        return new Entry<>(CenterAttribute.child, child);
    }

    @Override
    public void store(DSLContext context, Page page) {
        store(context, page, CenterAttribute.values());
        super.store(context, page);
    }

}
