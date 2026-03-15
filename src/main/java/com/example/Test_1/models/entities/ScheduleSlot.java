package com.example.Test_1.models.entities;

import com.example.Test_1.models.enums.PriorityType;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetTime;
import java.util.UUID;

@Entity
@Table(name = "schedule_slots")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleSlot {
    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String id;

    @ManyToOne
    @JoinColumn(name = "schedule_template_id", nullable = false)
    public ScheduleTemplate scheduleTemplate;

    @Column(name = "begin_time", nullable = false, columnDefinition = "TIMETZ")
    public OffsetTime beginTime;

    @Column(name = "end_time", nullable = false, columnDefinition = "TIMETZ")
    public OffsetTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", length = 20, nullable = false)
    @Builder.Default
    public PriorityType priority = PriorityType.NORMAL;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString().replace("-", "");
    }
}