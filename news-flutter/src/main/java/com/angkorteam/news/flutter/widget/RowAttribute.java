package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.common.AttrType;
import com.angkorteam.news.flutter.common.IAttribute;

public enum RowAttribute implements IAttribute {
    children(AttrType.Array);

    private AttrType type;

    RowAttribute(AttrType type) {
        this.type = type;
    }

    @Override
    public AttrType getType() {
        return this.type;
    }
}