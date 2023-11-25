package com.adventurer.webapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "user_id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String name;
    private String patronymic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime dateOfBirth;
    private String email;
    @Column(nullable = false)
    private Character gender;
    @Column(nullable = false)
    private String region;

    public Long getId() {
        return this.id;
    }
}
