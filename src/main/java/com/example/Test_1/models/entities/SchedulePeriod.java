package com.example.Test_1.models.entities;

import com.example.Test_1.models.enums.PriorityTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.UUID;

@Entity
@Table(name = "schedule_periods")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SchedulePeriod {
    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String id;

    @ManyToOne
    @Column(name = "schedule_template_id", length = 32, nullable = false)
    public String scheduleTemplateId;

    @Column(name = "begin_time", nullable = false)
    public OffsetTime beginTime;

    @Column(name = "end_time", nullable = false)
    public OffsetTime EndTime;

    @Column(name = "priority", length = 20, nullable = false)
    public PriorityTypes priority = PriorityTypes.NORMAL;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString().replace("-", "");
    }
}