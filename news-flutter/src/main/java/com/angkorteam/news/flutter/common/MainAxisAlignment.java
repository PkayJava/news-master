package com.angkorteam.news.flutter.common;

public enum MainAxisAlignment {
    start("start"),
    end("end"),
    center("center"),
    spaceBetween("spaceBetween"),
    spaceAround("spaceAround"),
    spaceEvenly("spaceEvenly");

    private String literal;

    MainAxisAlignment(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

}
