package com.example.Test_1.models.entities;

import com.example.Test_1.models.enums.SlotType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "schedule_slot_id", nullable = false)
    public ScheduleSlot scheduleSlot;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    public Schedule schedule;

    @Enumerated(EnumType.STRING)
    @Column(name = "slot_type", length = 20, nullable = false)
    public SlotType slotType = SlotType.UNDEFINED;

    @Column(name = "administrator_id", length = 32, nullable = false)
    public Employee administratorId;

    @Column(name = "executor_id", length = 32, nullable = true)
    public Employee executorId;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString().replace("-", "");
    }
}