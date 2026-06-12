package com.placement.scheduler.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double packageOffered;

    @Column(nullable = false)
    private Double minCgpa;

    @Column(nullable = false)
    private Integer maxBacklogs;

    @Column(nullable = false)
    private String eligibleBranches;

    private String website;
}