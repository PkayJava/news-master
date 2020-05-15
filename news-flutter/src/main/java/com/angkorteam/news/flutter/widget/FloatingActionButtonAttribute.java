package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.common.AttrType;
import com.angkorteam.news.flutter.common.IAttribute;

public enum FloatingActionButtonAttribute implements IAttribute {
    onPressed(AttrType.Simple),
    tooltip(AttrType.Simple),
    child(AttrType.Object);

    private AttrType type;

    FloatingActionButtonAttribute(AttrType type) {
        this.type = type;
    }

    @Override
    public AttrType getType() {
        return this.type;
    }
}