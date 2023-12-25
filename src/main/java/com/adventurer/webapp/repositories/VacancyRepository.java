package com.adventurer.webapp.repositories;

import com.adventurer.webapp.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    public Optional<Vacancy> findVacancyByHirerTitle(String title);
}
