package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.common.AttrType;
import com.angkorteam.news.flutter.common.IAttribute;

public enum AppBarAttribute implements IAttribute {
    title(AttrType.Object);

    private AttrType type;

    AppBarAttribute(AttrType type) {
        this.type = type;
    }

    @Override
    public AttrType getType() {
        return this.type;
    }

}