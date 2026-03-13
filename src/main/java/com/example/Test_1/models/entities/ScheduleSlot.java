package com.example.Test_1.models.entities;

import com.example.Test_1.models.enums.PriorityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetTime;
import java.util.UUID;

@Entity
@Table(name = "schedule_slots")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleSlot {
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

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", length = 20, nullable = false)
    public PriorityType priority = PriorityType.NORMAL;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString().replace("-", "");
    }
}