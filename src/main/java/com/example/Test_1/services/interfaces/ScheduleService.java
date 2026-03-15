package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.schedule.ScheduleCreateRequest;
import com.example.Test_1.models.dto.schedule.ScheduleDto;

import java.util.List;

public interface ScheduleService {
    String createEntity(ScheduleCreateRequest request);

    List<ScheduleDto> getEntityById(String id);

    List<ScheduleDto> getEntityByName(String name);
}