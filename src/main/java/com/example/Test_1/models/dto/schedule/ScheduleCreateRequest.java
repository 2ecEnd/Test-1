package com.example.Test_1.models.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleCreateRequest {
    @JsonProperty("ScheduleName")
    public String scheduleName;

    @JsonProperty("ScheduleTags")
    public List<String> scheduleTags;
}
