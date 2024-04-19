package com.adventurer.webapp.services;

import com.adventurer.webapp.dto.vacancies.GetVacancyDto;
import com.adventurer.webapp.exceptions.VacancyNotFoundException;
import com.adventurer.webapp.repositories.VacancyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyService {
    private final VacancyRepository vacancyRepository;
    private final ModelMapper mapper;


    public VacancyService(VacancyRepository vacancyRepository, ModelMapper mapper) {
        this.vacancyRepository = vacancyRepository;
        this.mapper = mapper;
    }

    public GetVacancyDto findVacancyByHirerTitle(String title) {
        return mapper.map(
                vacancyRepository.findVacancyByHirerTitle(title)
                        .orElseThrow(() -> new VacancyNotFoundException(title)),
                GetVacancyDto.class
        );
    }


    public List<GetVacancyDto> findAllVacancies() {
        return vacancyRepository.findAll()
                .stream()
                .map(
                        vacancy -> mapper.map(
                                vacancy,
                                GetVacancyDto.class
                        )
                ).collect(Collectors.toList());
    }
}
