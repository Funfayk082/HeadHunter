package com.adventurer.webapp.services;

import com.adventurer.webapp.models.VacancyTag;
import com.adventurer.webapp.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<VacancyTag> getTagsByName(String name) {
        return tagRepository.findAllByTagNameContaining(name);
    }
}
