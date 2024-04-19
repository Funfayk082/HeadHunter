package com.adventurer.webapp.models;

import com.adventurer.webapp.enums.Education;
import com.adventurer.webapp.enums.EmploymentType;
import com.adventurer.webapp.enums.WorkExperience;
import com.adventurer.webapp.enums.WorkShedule;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "vacancy")
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private WorkExperience workExperience;
    @ManyToOne
    @JoinColumn(nullable = false, name = "region_id")
    private Region region;
    @Column(nullable = false)
    private String specialty;
    @Column(nullable = false)
    private String industry;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Education education;
    @Column(nullable = false)
    private String otherParams;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkShedule workShedule;
    @ManyToOne
    @JoinColumn(nullable = false, name = "hirer_id")
    private Hirer hirer;
    @OneToMany(mappedBy = "vacancy", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private List<VacancyTag> tag;
}
