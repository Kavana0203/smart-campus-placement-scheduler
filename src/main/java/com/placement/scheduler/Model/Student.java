package com.placement.scheduler.Model;

import jakarta.persistence.*;
import lombok.Data;

    @Data
    @Entity
    @Table(name = "students")
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private String branch;

        @Column(nullable = false)
        private Double cgpa;

        @Column(nullable = false)
        private Integer backlogs;

        @Column(nullable = false)
        private String phone;

        private String resumePath;

        @Column(nullable = false)
        private boolean placed = false;
    }

