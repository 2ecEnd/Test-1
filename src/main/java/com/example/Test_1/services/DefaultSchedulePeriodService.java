package com.example.Test_1.services;

import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodCreateRequest;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodDto;
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
import java.util.Objects;
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
        // "Валидация"
        var slot            = scheduleSlotRepository.findById(request.scheduleSlotId).orElse(null);
        var schedule        = scheduleRepository.findById(request.scheduleId).orElse(null);
        var administrator   = employeeRepository.findById(currentUser).orElse(null);
        if (slot == null || schedule == null || administrator  == null) {
            return null;
        }

        var executor = request.executorId == null ?
                administrator :
                employeeRepository.findById(request.executorId).orElse(null);
        if (executor == null) {
            return null;
        }

        var periods = schedulePeriodRepository.findAllByExecutorId(executor.id);
        for (var period : periods) {
            var currSlot = period.scheduleSlot;
            if (currSlot.beginTime.isBefore(slot.endTime) &&
                    currSlot.endTime.isAfter(slot.beginTime)) {
                return null;
            }
        }

        // Создание
        var entity = SchedulePeriod.builder()
                .scheduleSlot(slot)
                .schedule(schedule)
                .slotType(request.slotType)
                .administrator(administrator)
                .build();

        if (request.executorId != null) {
            if (executor != administrator) {
                entity.executor = executor;
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