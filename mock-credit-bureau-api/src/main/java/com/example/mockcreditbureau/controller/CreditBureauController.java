package com.example.mockcreditbureau.controller;

import com.example.mockcreditbureau.data.CreditBureauDataStore;
import com.example.mockcreditbureau.model.CreditBureauReport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/v1")
public class CreditBureauController {

    private final CreditBureauDataStore dataStore;

    public CreditBureauController(CreditBureauDataStore dataStore) {
        this.dataStore = dataStore;
    }

    // Mimics a real third-party bureau API: requires an API key header,
    // has artificial latency, and returns 404 for unknown users —
    // gives your Data Collection Service real error-handling to build against.
    @GetMapping("/credit-report/{userId}")
    public ResponseEntity<?> getCreditReport(
            @PathVariable int userId) throws InterruptedException {


        if (!dataStore.exists(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "No credit report found for userId " + userId));
        }


        CreditBureauReport report = dataStore.findByUserId(userId);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "UP", "service", "mock-credit-bureau-api"));
    }



}
