package com.adventurer.webapp.services;

import com.adventurer.webapp.models.Summary;
import com.adventurer.webapp.models.User;
import com.adventurer.webapp.repos.SummaryRepository;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {
    private final SummaryRepository summaryRepository;

    public SummaryService(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    public Summary getSummaryByUserEmail(String userEmail) {
        return summaryRepository.findSummaryByUserEmail(userEmail).get();
    }

    public Summary save(Summary summary) {
        return summaryRepository.save(summary);
    }
}
