package com.project.lovable_clone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String StripePriceId;

    private Integer maxProjects;

    private Integer maxTokenPerDay;

    private Integer maxPreviews;

    private Boolean unlimitedAi;

    private Boolean active;
}
