package com.example.Test_1.models.dto.Schedule;

import com.example.Test_1.models.enums.PositionType;
import com.example.Test_1.models.enums.StatusType;
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
}