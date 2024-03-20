package com.adventurer.webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vacancy_tag")
@AllArgsConstructor
@NoArgsConstructor
public class VacancyTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacancyTagId;
    @Column(nullable = false)
    private String tagName;
    @ManyToOne
    @JoinColumn(nullable = false, name = "vacancy_id")
    private Vacancy vacancy;
}
