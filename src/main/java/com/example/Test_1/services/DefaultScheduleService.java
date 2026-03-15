package com.example.Test_1.services;

import com.example.Test_1.models.dto.schedule.ScheduleCreateRequest;
import com.example.Test_1.models.dto.schedule.ScheduleDto;
import com.example.Test_1.models.entities.Schedule;
import com.example.Test_1.repositories.ScheduleRepository;
import com.example.Test_1.services.interfaces.ScheduleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        var entities = new ArrayList<Optional<Schedule>>();
        entities.add(scheduleRepository.findById(id));

        return entities.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(e -> new ScheduleDto(
                e.id,
                e.scheduleName,
                e.getTagsAsList(),
                e.creationDate
        )).toList();
    }

    @Override
    public List<ScheduleDto> getEntityByName(String name) {
        var entities = new HashSet<Optional<Schedule>>();

        // Получение сущностей
        // Решение через регулярки явное не лучшее
        // из-за возможного наличия спецсимволов в имени
        // но лучше способа я не придумал(
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < name.length(); j++) {
                var sb = new StringBuilder(name);

                sb.setCharAt(i, '.');
                sb.setCharAt(j, '.');

                entities.addAll(scheduleRepository.findByScheduleNameRegex(sb.toString()));
            }
        }

        return entities.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(e -> new ScheduleDto(
                        e.id,
                        e.scheduleName,
                        e.getTagsAsList(),
                        e.creationDate
                )).toList();
    }
}
