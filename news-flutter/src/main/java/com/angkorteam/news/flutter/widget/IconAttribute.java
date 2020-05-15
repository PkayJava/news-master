package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.common.AttrType;
import com.angkorteam.news.flutter.common.IAttribute;

public enum IconAttribute implements IAttribute {
    ;
    private AttrType type;

    IconAttribute(AttrType type) {
        this.type = type;
    }

    @Override
    public AttrType getType() {
        return this.type;
    }
}