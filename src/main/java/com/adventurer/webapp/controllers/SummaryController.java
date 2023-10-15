package com.adventurer.webapp.controllers;

import com.adventurer.webapp.models.User;
import com.adventurer.webapp.services.SummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SummaryController {
    private final SummaryService summaryService;

    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getSummaryByUser(@RequestBody User user) {
        return ResponseEntity.ok(summaryService.getSummaryByUser(user.getId()));
    }
}