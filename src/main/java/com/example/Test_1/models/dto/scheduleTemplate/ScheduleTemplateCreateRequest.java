package com.example.Test_1.models.dto.scheduleTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleTemplateCreateRequest {
    @JsonProperty("TemplateType")
    public String templateType;
}