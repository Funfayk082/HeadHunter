package com.adventurer.webapp.repos;

import com.adventurer.webapp.models.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
    public Optional<Summary> findSummaryByUserEmail(String userEmail);
}
