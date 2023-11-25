package com.adventurer.webapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contact")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @ManyToOne
    @JoinColumn(nullable = false, name = "summary_id")
    private Summary summary;
}
