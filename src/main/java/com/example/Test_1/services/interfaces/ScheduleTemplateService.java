package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.scheduleTemplate.ScheduleTemplateCreateRequest;
import com.example.Test_1.models.dto.scheduleTemplate.ScheduleTemplateDto;

public interface ScheduleTemplateService {
    String createEntity(ScheduleTemplateCreateRequest request);

    ScheduleTemplateDto getEntityById(String id);
}