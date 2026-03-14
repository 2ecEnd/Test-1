package com.example.Test_1.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "schedules")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {
    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String id;

    @Column(name = "scheduleName", length = 255, nullable = true)
    public String scheduleName;

    @Column(name = "schedule_tags", length = 255, nullable = true)
    public String scheduleTags;

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    public OffsetDateTime creationDate;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString().replace("-", "");
    }

    public List<String> getTagsAsList() {
        if (scheduleTags == null) {
            return List.of();
        }

        return Arrays.asList(scheduleTags.split(","));
    }
}