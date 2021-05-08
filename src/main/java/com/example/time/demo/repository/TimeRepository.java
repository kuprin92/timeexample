package com.example.time.demo.repository;

import com.example.time.demo.model.TimeZoneOffset;
import com.example.time.demo.model.ZoneEntry;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TimeRepository {
    private final Map<UUID, TimeZoneOffset> offsets = new HashMap<>();
    private final Map<UUID, ZoneEntry> zoneEntries = new HashMap<>();

    public void add(TimeZoneOffset zoneOffset) {
        offsets.put(zoneOffset.getId(), zoneOffset);
    }

    public void add(ZoneEntry zoneEntry) {
        zoneEntries.put(zoneEntry.getId(), zoneEntry);
    }

    public Collection<TimeZoneOffset> getTimeZoneOffsets() {
        return offsets.values();
    }

    public Collection<ZoneEntry> getZoneEntries() {
        return zoneEntries.values();
    }
}
