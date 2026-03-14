package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.ScheduleTemplate.ScheduleTemplateCreateRequest;
import com.example.Test_1.models.dto.ScheduleTemplate.ScheduleTemplateDto;

public interface ScheduleTemplateService {
    String createEntity(ScheduleTemplateCreateRequest request);

    ScheduleTemplateDto getEntityById(String id);
}