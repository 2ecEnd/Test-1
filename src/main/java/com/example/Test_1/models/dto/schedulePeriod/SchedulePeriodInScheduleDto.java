package com.example.Test_1.models.dto.schedulePeriod;

import com.example.Test_1.models.enums.SlotType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulePeriodInScheduleDto {
    @JsonProperty("Id")
    public String Id;

    @JsonProperty("ScheduleSlotId")
    public String scheduleSlotId;

    @JsonProperty("ScheduleId")
    public String scheduleId;

    @JsonProperty("SlotType")
    public SlotType slotType;

    @JsonProperty("AdministratorId")
    public String administratorId;

    @JsonProperty("ExecutorId")
    public String executorId;

    @JsonProperty("BeginTime")
    public OffsetTime beginTime;

    @JsonProperty("EndTime")
    public OffsetTime endTime;
}