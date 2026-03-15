package com.example.Test_1.services;

import com.example.Test_1.models.dto.etc.FilterRequest;
import com.example.Test_1.models.dto.etc.PaginationRequest;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodCreateRequest;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodDto;
import com.example.Test_1.models.dto.etc.SortRequest;
import com.example.Test_1.models.entities.Employee;
import com.example.Test_1.models.entities.SchedulePeriod;
import com.example.Test_1.repositories.EmployeeRepository;
import com.example.Test_1.repositories.SchedulePeriodRepository;
import com.example.Test_1.repositories.ScheduleRepository;
import com.example.Test_1.repositories.ScheduleSlotRepository;
import com.example.Test_1.services.interfaces.SchedulePeriodService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultSchedulePeriodService implements SchedulePeriodService {
    @Autowired
    private SchedulePeriodRepository schedulePeriodRepository;

    @Autowired
    private ScheduleSlotRepository scheduleSlotRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEntity(SchedulePeriodCreateRequest request, String currentUser) {
        var slot            = scheduleSlotRepository.findById(request.scheduleSlotId);
        var schedule        = scheduleRepository.findById(request.scheduleId);
        var administrator   = employeeRepository.findById(currentUser);

        if (slot.isEmpty() || schedule.isEmpty() || administrator.isEmpty()) {
            return null;
        }

        Optional<Employee> executor = Optional.empty();
        if (request.executorId != null) {
            executor = employeeRepository.findById(request.executorId);

            if (executor.isEmpty()) {
                return null;
            }
        }


        var entity = SchedulePeriod.builder()
                .scheduleSlot(slot.get())
                .schedule(schedule.get())
                .slotType(request.slotType)
                .administrator(administrator.get())
                .build();

        if (request.executorId != null) {
            if (executor.get() != administrator.get()) {
                entity.executor = executor.get();
            }
        }

        schedulePeriodRepository.save(entity);

        return entity.id;
    }

    @Override
    public SchedulePeriodDto getEntityById(String id) {
        var entity = schedulePeriodRepository.findById(id);

        return entity.map(e -> new SchedulePeriodDto(
                e.id,
                e.scheduleSlot.id,
                e.schedule.id,
                e.slotType,
                e.administrator.id,
                e.executor == null ? null : e.executor.id
        )).orElse(null);
    }

    @Override
    public List<SchedulePeriodDto> getEntities(
            Specification<SchedulePeriod> specs,
            PageRequest paging
    ) {
        var result = schedulePeriodRepository.findAll(specs, paging);

        return result.stream().map(e -> new SchedulePeriodDto(
                e.id,
                e.scheduleSlot.id,
                e.schedule.id,
                e.slotType,
                e.administrator.id,
                e.executor == null ? null : e.executor.id
        )).toList();
    }
}