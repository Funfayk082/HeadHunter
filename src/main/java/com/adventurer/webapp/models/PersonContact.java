package com.adventurer.webapp.models;

import com.adventurer.webapp.enums.ContactType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person_contact")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @ManyToOne
    @JoinColumn(nullable = false, name = "summary_id")
    private Summary summary;

    @ManyToOne
    @JoinColumn(nullable = false, name = "hirer_id")
    private Hirer hirer;
}
