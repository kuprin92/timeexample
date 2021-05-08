package com.example.time.demo.controller;

import com.example.time.demo.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time/")
public class TimeController {
    private final TimeRepository timeRepository;

    public TimeController(@Autowired TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @GetMapping("/offsets")
    public ResponseEntity<?> getOffsets() {
        return ResponseEntity.ok(timeRepository.getTimeZoneOffsets());
    }

    @GetMapping("/timeZones")
    public ResponseEntity<?> getTimeZones() {
        return ResponseEntity.ok(timeRepository.getZoneEntries());
    }
}
