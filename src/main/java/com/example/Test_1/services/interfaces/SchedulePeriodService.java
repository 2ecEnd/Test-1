package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.FilterRequest;
import com.example.Test_1.models.dto.PaginationRequest;
import com.example.Test_1.models.dto.SchedulePeriod.SchedulePeriodCreateRequest;
import com.example.Test_1.models.dto.SchedulePeriod.SchedulePeriodDto;
import com.example.Test_1.models.dto.SortRequest;

import java.util.List;

public interface SchedulePeriodService {
    String createEntity(SchedulePeriodCreateRequest request, String currentUser);

    SchedulePeriodDto getEntityById(String id);

    List<SchedulePeriodDto> getEntities(
            FilterRequest filter,
            SortRequest sort,
            PaginationRequest pagination
    );
}