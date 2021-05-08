package com.example.time.demo.model;


import java.io.Serializable;
import java.util.UUID;

public class ZoneEntry implements Serializable {
    private static final long serialVersionUID = 2483331920707713144L;
    private String name;
    private TimeZoneOffset zoneOffset;
    private UUID id;

    public TimeZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(TimeZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}