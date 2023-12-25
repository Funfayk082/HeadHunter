package com.adventurer.webapp.dto.vacancies;

import com.adventurer.webapp.enums.Education;
import com.adventurer.webapp.enums.EmploymentType;
import com.adventurer.webapp.enums.WorkExperience;
import com.adventurer.webapp.enums.WorkShedule;
import com.adventurer.webapp.models.Hirer;
import com.adventurer.webapp.models.Region;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class GetVacancyDto {
    private Long id;
    private String title;
    private String description;
    private WorkExperience workExperience;
    private Region region;
    private String specialty;
    private String industry;
    private Education education;
    private List<String> otherParams;
    private EmploymentType employmentType;
    private WorkShedule workShedule;
    private Hirer hirer;
}
