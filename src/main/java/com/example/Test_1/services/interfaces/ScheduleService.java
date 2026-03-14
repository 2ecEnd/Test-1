package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.Schedule.ScheduleCreateRequest;
import com.example.Test_1.models.dto.Schedule.ScheduleDto;

public interface ScheduleService {
    String createEntity(ScheduleCreateRequest request);

    ScheduleDto getEntityById(String id);
}