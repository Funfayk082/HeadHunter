package com.adventurer.webapp.repositories;

import com.adventurer.webapp.models.VacancyTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<VacancyTag, Long> {
    List<VacancyTag> findAllByTagNameContaining(String name);
}
