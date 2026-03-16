package com.example.Test_1.services;

import com.example.Test_1.models.dto.schedule.ScheduleCreateRequest;
import com.example.Test_1.models.dto.schedule.ScheduleDto;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodDto;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodInScheduleDto;
import com.example.Test_1.models.entities.Schedule;
import com.example.Test_1.models.entities.SchedulePeriod;
import com.example.Test_1.repositories.SchedulePeriodRepository;
import com.example.Test_1.repositories.ScheduleRepository;
import com.example.Test_1.repositories.ScheduleSlotRepository;
import com.example.Test_1.services.interfaces.ScheduleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultScheduleService implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private SchedulePeriodRepository schedulePeriodRepository;

    @Autowired
    private ScheduleSlotRepository scheduleSlotRepository;

    @Override
    public String createEntity(ScheduleCreateRequest request) {
        var entity = Schedule.builder()
                .scheduleName(request.scheduleName)
                .scheduleTags(String.join(",", request.scheduleTags))
                .build();

        scheduleRepository.save(entity);

        return entity.id;
    }

    @Override
    public List<ScheduleDto> getEntityById(String id) {
        var schedules = new ArrayList<Schedule>();
        scheduleRepository.findById(id).ifPresent(schedules::add);

        var periods = schedulePeriodRepository.findAllByScheduleId(id).stream().toList();
        var periodsDto = new ArrayList<SchedulePeriodInScheduleDto>();
        for (var period : periods) {
            var slot = scheduleSlotRepository.findById(period.scheduleSlot.id).get();

            periodsDto.add(new SchedulePeriodInScheduleDto(
                period.id,
                period.scheduleSlot.id,
                period.schedule.id,
                period.slotType,
                period.administrator.id,
                period.executor == null ? period.administrator.id : period.executor.id,
                slot.beginTime,
                slot.endTime
            ));
        }

        return schedules.stream()
                .map(e -> new ScheduleDto(
                e.id,
                e.scheduleName,
                e.getTagsAsList(),
                e.creationDate,
                periodsDto
        )).toList();
    }

    @Override
    public List<ScheduleDto> getEntityByName(String name) {
        var schedules = new HashSet<Schedule>();

        // Получение сущностей
        // Решение через регулярки явное не лучшее
        // из-за возможного наличия спецсимволов в имени
        // но лучше способа я не придумал(
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < name.length(); j++) {
                var sb = new StringBuilder(name);

                sb.setCharAt(i, '.');
                sb.setCharAt(j, '.');

                var tmp = scheduleRepository.findByScheduleNameRegex(sb.toString());
                if (!tmp.isEmpty()) {
                    schedules.addAll(tmp.stream()
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .toList()
                    );
                }
            }
        }

        var schedulesDto = new ArrayList<ScheduleDto>();
        for (var schedule : schedules) {
            var periods = schedulePeriodRepository.findAllByScheduleId(schedule.id).stream().toList();
            var periodsDto = new ArrayList<SchedulePeriodInScheduleDto>();
            for (var period : periods) {
                var slot = scheduleSlotRepository.findById(period.scheduleSlot.id).get();

                periodsDto.add(new SchedulePeriodInScheduleDto(
                        period.id,
                        period.scheduleSlot.id,
                        period.schedule.id,
                        period.slotType,
                        period.administrator.id,
                        period.executor == null ? period.administrator.id : period.executor.id,
                        slot.beginTime,
                        slot.endTime
                ));
            }

            schedulesDto.add(new ScheduleDto(
                    schedule.id,
                    schedule.scheduleName,
                    schedule.getTagsAsList(),
                    schedule.creationDate,
                    periodsDto
            ));
        }

        return schedulesDto;
    }
}
