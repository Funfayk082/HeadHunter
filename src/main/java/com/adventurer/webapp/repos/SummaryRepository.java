package com.adventurer.webapp.repos;

import com.adventurer.webapp.models.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
}
