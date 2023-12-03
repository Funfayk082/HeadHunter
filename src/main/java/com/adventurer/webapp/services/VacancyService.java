package com.adventurer.webapp.services;

import com.adventurer.webapp.models.Vacancy;
import com.adventurer.webapp.repos.VacancyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    private final VacancyRepository vacancyRepository;


    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public Vacancy findVacancyByHirerTitle(String title) {
        return vacancyRepository.findVacancyByHirerTitle(title).get();
    }

    public List<Vacancy> findAllVacancies() {
        return vacancyRepository.findAllVacancies();
    }
}
