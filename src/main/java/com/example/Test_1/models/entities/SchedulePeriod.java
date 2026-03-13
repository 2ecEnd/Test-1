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
    @Column(name = "slot_id", length = 32, nullable = false)
    public String slotId;

    @ManyToOne
    @Column(name = "schedule_id", length = 32, nullable = false)
    public String scheduleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "slot_type", length = 20, nullable = false)
    public SlotType slotType = SlotType.UNDEFINED;

    @Column(name = "administrator_id", length = 32, nullable = false)
    public String administratorId;

    @Column(name = "executor_id", length = 32, nullable = true)
    public String executorId;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString().replace("-", "");
    }
}