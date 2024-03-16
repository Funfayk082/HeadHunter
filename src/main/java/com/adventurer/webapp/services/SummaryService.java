package com.adventurer.webapp.services;

import com.adventurer.webapp.dto.summaries.CreateSummaryRequestDto;
import com.adventurer.webapp.dto.summaries.GetSummaryDto;
import com.adventurer.webapp.models.Summary;
import com.adventurer.webapp.repositories.SummaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {
    private final SummaryRepository summaryRepository;
    private final ModelMapper mapper;

    public SummaryService(SummaryRepository summaryRepository, ModelMapper mapper) {
        this.summaryRepository = summaryRepository;
        this.mapper = mapper;
    }

    public GetSummaryDto getSummaryByUserEmail(Long id) {
        return mapper.map(summaryRepository.findSummaryByUserUserId(id).get(), GetSummaryDto.class);
    }

    public Long save(CreateSummaryRequestDto summary) {
        return summaryRepository.save(mapper.map(summary, Summary.class)).getId();
    }
}
