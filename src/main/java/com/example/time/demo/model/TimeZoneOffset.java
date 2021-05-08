package com.example.time.demo.model;


import java.io.Serializable;
import java.time.ZoneOffset;
import java.util.UUID;

public class TimeZoneOffset implements Serializable {
    private static final long serialVersionUID = 1996034157437013300L;
    private Integer hour;
    private Integer minute;
    private Integer second;
    private String offsetType;
    private String name;
    private String description;
    private UUID id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffset() {
        Integer offset = getOffsetValue();
        if (offset == null) return null;
        return ZoneOffset.ofTotalSeconds(offset).getId();
    }

    public Integer getOffsetValue() {
        if (hour == null || minute == null || second == null || offsetType == null) return null;
        int offsetTypeValue = OffsetType.fromId(offsetType) == OffsetType.NEGATIVE ? -1 : 1;
        int offset = (hour * 60 * 60 + minute * 60 + second) * offsetTypeValue;
        return offset;
    }

    public OffsetType getOffsetType() {
        return offsetType == null ? null : OffsetType.fromId(offsetType);
    }

    public void setOffsetType(OffsetType offsetType) {
        this.offsetType = offsetType == null ? null : offsetType.getId();
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}