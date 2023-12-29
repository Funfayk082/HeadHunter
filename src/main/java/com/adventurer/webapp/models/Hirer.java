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
@Table(name = "hirer")
@NoArgsConstructor
@AllArgsConstructor
public class Hirer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hirerId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    private String address;
    @OneToMany(mappedBy = "hirer", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private List<PersonContact> contacts;
    @OneToMany(mappedBy = "hirer", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private List<Vacancy> vacancies;
}
