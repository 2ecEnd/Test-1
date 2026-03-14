package com.example.Test_1.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "schedule_templates")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleTemplate {
    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String id;

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    public OffsetDateTime creationDate;

    @Column(name = "template_type", length = 2, nullable = false)
    public String templateType;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString().replace("-", "");
    }
}