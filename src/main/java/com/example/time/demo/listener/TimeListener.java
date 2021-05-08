package com.example.time.demo.listener;

import com.example.time.demo.model.TimeZoneOffset;
import com.example.time.demo.model.ZoneEntry;
import com.example.time.demo.repository.TimeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class TimeListener {
    public static final String ZONE_ENTRY_UPDATE = "zone_entry_update";
    public static final String TIMEZONE_OFFSET_UPDATE = "timezone_offset_update";
    @Autowired
    private TimeRepository restController;

    @Bean
    public NewTopic zone_entry_update() {
        return TopicBuilder.name(ZONE_ENTRY_UPDATE).build();
    }

    @Bean
    public NewTopic timezone_offset_update() {
        return TopicBuilder.name(TIMEZONE_OFFSET_UPDATE).build();
    }

    @KafkaListener(topicPattern = ZONE_ENTRY_UPDATE)
    public void zone_entry_update(String data) throws JsonProcessingException {
        final ZoneEntry zoneEntry = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(data, ZoneEntry.class);
        restController.add(zoneEntry);
    }

    @KafkaListener(topicPattern = TIMEZONE_OFFSET_UPDATE)
    public void timezone_offset_update(String data) throws JsonProcessingException {
        final TimeZoneOffset zoneOffset = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(data, TimeZoneOffset.class);
        restController.add(zoneOffset);
    }
}
