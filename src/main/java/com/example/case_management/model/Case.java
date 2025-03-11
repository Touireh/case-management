package com.example.case_management.model;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "cases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    private String title;
    private String description;

    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;

    @PrePersist
    protected void onCreate() {
        creationDate = lastUpdateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdateDate = LocalDateTime.now();
    }
}
