package com.example.Test_1.services;

import com.example.Test_1.models.dto.Schedule.ScheduleCreateRequest;
import com.example.Test_1.models.dto.Schedule.ScheduleDto;
import com.example.Test_1.models.entities.Schedule;
import com.example.Test_1.repositories.ScheduleRepository;
import com.example.Test_1.services.interfaces.ScheduleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ScheduleDto getEntityById(String id) {
        var entity = scheduleRepository.findById(id);

        return entity.map(e -> new ScheduleDto(
                e.id,
                e.scheduleName,
                e.getTagsAsList(),
                e.creationDate
        )).orElse(null);
    }

    @Override
    public ScheduleDto getEntityByName(String name) {
        return null;
    }
}
