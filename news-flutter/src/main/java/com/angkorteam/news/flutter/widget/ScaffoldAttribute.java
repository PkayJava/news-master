package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.common.AttrType;
import com.angkorteam.news.flutter.common.IAttribute;

public enum ScaffoldAttribute implements IAttribute {
    appBar(AttrType.Object),
    body(AttrType.Object),
    floatingActionButton(AttrType.Object);

    private AttrType type;

    ScaffoldAttribute(AttrType type) {
        this.type = type;
    }

    @Override
    public AttrType getType() {
        return this.type;
    }
}