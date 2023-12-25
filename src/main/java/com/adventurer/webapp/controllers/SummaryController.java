package com.adventurer.webapp.controllers;

import com.adventurer.webapp.dto.summaries.CreateSummaryRequestDto;
import com.adventurer.webapp.models.Summary;
import com.adventurer.webapp.services.SummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SummaryController {
    private final SummaryService summaryService;

    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping("/summaries")
    public ResponseEntity<?> getSummaryByUserEmail(@RequestParam String email) {
        return ResponseEntity.ok(summaryService.getSummaryByUserEmail(email));
    }

    @PostMapping("/summaries")
    public ResponseEntity<?> addSummary(@RequestBody CreateSummaryRequestDto summary) {
        return ResponseEntity.ok(summaryService.save(summary));
    }
}