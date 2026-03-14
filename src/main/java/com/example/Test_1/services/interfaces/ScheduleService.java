package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.schedule.ScheduleCreateRequest;
import com.example.Test_1.models.dto.schedule.ScheduleDto;

public interface ScheduleService {
    String createEntity(ScheduleCreateRequest request);

    ScheduleDto getEntityById(String id);

    ScheduleDto getEntityByName(String name);
}