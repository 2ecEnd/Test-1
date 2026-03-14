package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.ScheduleSlot.ScheduleSlotCreateRequest;
import com.example.Test_1.models.dto.ScheduleSlot.ScheduleSlotDto;

public interface ScheduleSlotService {
    String createEntity(ScheduleSlotCreateRequest request);

    ScheduleSlotDto getEntityById(String id);
}