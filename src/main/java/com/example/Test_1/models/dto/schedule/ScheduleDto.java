package com.example.Test_1.models.dto.schedule;

import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodInScheduleDto;
import com.example.Test_1.models.dto.scheduleSlot.ScheduleSlotDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    @JsonProperty("Id")
    public String id;

    @JsonProperty("ScheduleName")
    public String scheduleName;

    @JsonProperty("ScheduleTags")
    public List<String> scheduleTags;

    @JsonProperty("CreationDate")
    public OffsetDateTime creationDate;

    @JsonProperty("periods")
    public List<SchedulePeriodInScheduleDto> periods;
}