package com.example.time.demo.model;

public enum OffsetType {

    POSITIVE("positive"),
    NEGATIVE("negative");

    private final String id;

    OffsetType(String value) {
        this.id = value;
    }

    public static OffsetType fromId(String id) {
        for (OffsetType at : OffsetType.values()) {
            if (at.id.equals(id)) {
                return at;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }
}