package com.placement.scheduler.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "drives")
public class Drive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(nullable = false)
    private LocalDate driveDate;

    @Column(nullable = false)
    private String venue;

    @Column(nullable = false)
    private String status; // UPCOMING, ONGOING, COMPLETED

    private String description;
}