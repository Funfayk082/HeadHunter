package com.adventurer.webapp.controllers;

import com.adventurer.webapp.services.VacancyService;
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
    public ResponseEntity<?> getVacancies() {
        return ResponseEntity.ok(vacancyService.findVacancyByHirerTitle(""));
    }

    @GetMapping("/vacancies")
    public ResponseEntity<?> getVacancyByHirerTitle(@RequestParam String title) {
        return ResponseEntity.ok(vacancyService.findVacancyByHirerTitle(title));
    }
}
