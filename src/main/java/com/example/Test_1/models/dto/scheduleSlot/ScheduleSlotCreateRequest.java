package com.example.Test_1.models.dto.scheduleSlot;

import com.example.Test_1.models.enums.PriorityType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleSlotCreateRequest {
    @JsonProperty("ScheduleTemplateId")
    public String scheduleTemplateId;

    @JsonProperty("BeginTime")
    public OffsetTime beginTime;

    @JsonProperty("EndTime")
    public OffsetTime endTime;

    @JsonProperty("Priority")
    @Nullable
    public PriorityType priority;
}