package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.etc.FilterRequest;
import com.example.Test_1.models.dto.etc.PaginationRequest;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodCreateRequest;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodDto;
import com.example.Test_1.models.dto.etc.SortRequest;
import com.example.Test_1.models.entities.SchedulePeriod;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface SchedulePeriodService {
    String createEntity(SchedulePeriodCreateRequest request, String currentUser);

    SchedulePeriodDto getEntityById(String id);

    List<SchedulePeriodDto> getEntities(
            Specification<SchedulePeriod> specs,
            PageRequest paging
    );
}