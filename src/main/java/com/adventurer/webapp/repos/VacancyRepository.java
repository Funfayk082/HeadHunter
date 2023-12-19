package com.adventurer.webapp.repos;

import com.adventurer.webapp.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    public Optional<Vacancy> findVacancyByHirerTitle(String title);
}
