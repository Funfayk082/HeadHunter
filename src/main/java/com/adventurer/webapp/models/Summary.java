package com.adventurer.webapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Data
@Table(name = "resume")
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String baseInfo;
    @Column(nullable = false)
    private Map<String, String> contacts;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String photo;
}
