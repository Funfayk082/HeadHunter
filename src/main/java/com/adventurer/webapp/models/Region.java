package com.adventurer.webapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name="region")
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private List<Vacancy> vacancies;
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private List<Summary> summaries;
}
