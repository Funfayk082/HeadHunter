package com.adventurer.webapp.controllers;

import com.adventurer.webapp.services.VacancyService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VacancyController {
    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/vacancies")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Получить вакансии по названию компании (или все вакансии)",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Вакансий нет",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            )
    })
    public ResponseEntity<?> getVacancies(@RequestParam(required = false) String title) {
        if (title == null) {
            return ResponseEntity.ok(vacancyService.findAllVacancies());
        }
        return ResponseEntity.ok(vacancyService.findVacancyByHirerTitle(title));
    }
}
