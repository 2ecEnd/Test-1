package com.example.Test_1.models.dto.SchedulePeriod;

import com.example.Test_1.models.entities.Schedule;
import com.example.Test_1.models.entities.ScheduleSlot;
import com.example.Test_1.models.enums.SlotType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulePeriodCreateRequest {
    @JsonProperty("ScheduleSlotId")
    public String scheduleSlotId;

    @JsonProperty("ScheduleId")
    public String scheduleId;

    @JsonProperty("SlotType")
    @Nullable
    public SlotType slotType;

    @JsonProperty("AdministratorId")
    public String administratorId;

    @JsonProperty("ExecutorId")
    public String executorId;
}
