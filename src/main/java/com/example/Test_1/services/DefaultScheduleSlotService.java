package com.example.Test_1.services;

import com.example.Test_1.models.dto.scheduleSlot.ScheduleSlotCreateRequest;
import com.example.Test_1.models.dto.scheduleSlot.ScheduleSlotDto;
import com.example.Test_1.models.entities.ScheduleSlot;
import com.example.Test_1.repositories.ScheduleSlotRepository;
import com.example.Test_1.repositories.ScheduleTemplateRepository;
import com.example.Test_1.services.interfaces.ScheduleSlotService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultScheduleSlotService implements ScheduleSlotService {
    @Autowired
    private ScheduleSlotRepository scheduleSlotRepository;

    @Autowired
    private ScheduleTemplateRepository scheduleTemplateRepository;

    @Override
    public String createEntity(ScheduleSlotCreateRequest request) {
        var template = scheduleTemplateRepository.findById(request.scheduleTemplateId);

        if (template.isEmpty()) {
            return null;
        }

        var entity = ScheduleSlot.builder()
                .scheduleTemplate(template.get())
                .beginTime(request.beginTime)
                .endTime(request.endTime)
                .build();

        if (request.priority != null) {
            entity.priority = request.priority;
        }

        scheduleSlotRepository.save(entity);

        return entity.id;
    }

    @Override
    public ScheduleSlotDto getEntityById(String id) {
        var entity = scheduleSlotRepository.findById(id);

        return entity.map(e -> new ScheduleSlotDto(
                e.id,
                e.scheduleTemplate.id,
                e.beginTime,
                e.endTime,
                e.priority
        )).orElse(null);
    }
}
