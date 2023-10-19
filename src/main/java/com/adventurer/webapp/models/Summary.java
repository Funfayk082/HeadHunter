package com.adventurer.webapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "summary")
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
    @OneToMany(mappedBy = "summary", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private List<Contact> contacts;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;
    @Column(nullable = false)
    private String photo;
}
