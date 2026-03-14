package com.example.Test_1.models.dto.ScheduleSlot;

import com.example.Test_1.models.enums.PriorityType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleSlotDto {
    @JsonProperty("Id")
    public String Id;

    @JsonProperty("ScheduleTemplateId")
    public String scheduleTemplateId;

    @JsonProperty("BeginTime")
    public OffsetTime beginTime;

    @JsonProperty("EndTime")
    public OffsetTime EndTime;

    @JsonProperty("Priority")
    public PriorityType priority;
}