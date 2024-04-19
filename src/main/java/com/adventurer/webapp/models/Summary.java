package com.adventurer.webapp.models;

import com.adventurer.webapp.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String baseInfo;
    @OneToMany(mappedBy = "summary", cascade = CascadeType.ALL)
    @JsonBackReference
    @ToString.Exclude
    private List<PersonContact> contacts;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;
    @Column(nullable = false)
    private String photo;
    @ManyToOne
    @JoinColumn(nullable = false, name = "region_id")
    private Region region;
}
