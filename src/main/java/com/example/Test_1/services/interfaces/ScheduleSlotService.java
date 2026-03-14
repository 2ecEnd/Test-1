package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.scheduleSlot.ScheduleSlotCreateRequest;
import com.example.Test_1.models.dto.scheduleSlot.ScheduleSlotDto;

public interface ScheduleSlotService {
    String createEntity(ScheduleSlotCreateRequest request);

    ScheduleSlotDto getEntityById(String id);
}