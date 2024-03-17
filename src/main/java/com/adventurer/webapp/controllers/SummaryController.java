package com.adventurer.webapp.controllers;

import com.adventurer.webapp.dto.summaries.CreateSummaryRequestDto;
import com.adventurer.webapp.models.Summary;
import com.adventurer.webapp.services.SummaryService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Получить резюме по E-Mail пользователя",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Не существует резюме у этого пользователя",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            )
    })
    public ResponseEntity<?> getSummaryByUserEmail(@RequestParam Long id) {
        return ResponseEntity.ok(summaryService.getSummaryByUserEmail(id));
    }

    @PostMapping("/summaries")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Резюме успешно добавлено",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Плохой резюме",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            )
    })
    public ResponseEntity<?> addSummary(@RequestBody CreateSummaryRequestDto summary) {
        return ResponseEntity.ok(summaryService.save(summary));
    }
}