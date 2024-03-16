package com.adventurer.webapp.controllers;

import com.adventurer.webapp.dto.summaries.CreateSummaryRequestDto;
import com.adventurer.webapp.models.Summary;
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

    @GetMapping("/summaries")
    public ResponseEntity<?> getSummaryByUserEmail(@RequestParam Long id) {
        return ResponseEntity.ok(summaryService.getSummaryByUserEmail(id));
    }

    @PostMapping("/summaries")
    public ResponseEntity<?> addSummary(@RequestBody CreateSummaryRequestDto summary) {
        return ResponseEntity.ok(summaryService.save(summary));
    }
}