package com.example.time.demo.repository;

import com.example.time.demo.model.TimeZoneOffset;
import com.example.time.demo.model.ZoneEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TimeRepository {
    private final Map<UUID, TimeZoneOffset> offsets = new HashMap<>();
    private final Map<UUID, ZoneEntry> zoneEntries = new HashMap<>();
    @Value("${application.timezone.name}")
    private String appTimezone;

    public void add(TimeZoneOffset zoneOffset) {
        offsets.put(zoneOffset.getId(), zoneOffset);
        zoneEntries.values().forEach(e->{
            if(e.getZoneOffset().getId().equals(zoneOffset.getId())){
               e.setZoneOffset(zoneOffset);
            }
        });
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

    public String getAppTimezone() {
        return appTimezone;
    }

    public String getCurrentDateTime() {
        return zoneEntries.values().stream().filter(e -> e.getName().equals(appTimezone))
                .findFirst().map(ZoneEntry::getZoneOffset)
                .map(e->offsets.get(e.getId()))
                .map(e -> ZonedDateTime.now(ZoneOffset.ofTotalSeconds(e.getOffsetValue())).toLocalDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")))
                .orElse("get App Timezone configuration not found");
    }
}
