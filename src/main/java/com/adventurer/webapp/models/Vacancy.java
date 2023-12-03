package com.adventurer.webapp.models;

import groovyjarjarpicocli.CommandLine;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private WorkExperience  workExperience;
    @Column(nullable = false)
    private Region region;
    @Column(nullable = false)
    private String specialty;
    @Column(nullable = false)
    private String industry;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Education education;
    @Column(nullable = false)
    private List<String> otherParams;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkShedule workShedule;
    @Column(nullable = false)
    private Hirer hirer;
}
