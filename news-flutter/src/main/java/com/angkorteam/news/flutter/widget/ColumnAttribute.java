package com.angkorteam.news.flutter.widget;

import com.angkorteam.news.flutter.common.AttrType;
import com.angkorteam.news.flutter.common.IAttribute;

public enum ColumnAttribute implements IAttribute {
    mainAxisAlignment(AttrType.Simple),
    children(AttrType.Array);

    private AttrType type;

    ColumnAttribute(AttrType type) {
        this.type = type;
    }

    @Override
    public AttrType getType() {
        return this.type;
    }
}