package com.example.Test_1.models.dto.schedulePeriod;

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

    @JsonProperty("ExecutorId")
    @Nullable
    public String executorId;
}
