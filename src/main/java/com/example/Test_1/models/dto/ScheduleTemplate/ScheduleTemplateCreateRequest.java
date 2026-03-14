package com.example.Test_1.models.dto.ScheduleTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleTemplateCreateRequest {
    @JsonProperty("CreationDate")
    public OffsetDateTime creationDate;

    @JsonProperty("TemplateType")
    public String templateType;
}