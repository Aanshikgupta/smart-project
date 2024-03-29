package com.smartcomputers.smartproject.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<Map<String,String>> healthCheck() {
        return ResponseEntity.ok(Map.of("status", "200-OK"));
    }
}
