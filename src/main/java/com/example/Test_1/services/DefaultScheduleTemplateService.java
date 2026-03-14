package com.example.Test_1.services;

import com.example.Test_1.models.dto.scheduleTemplate.ScheduleTemplateCreateRequest;
import com.example.Test_1.models.dto.scheduleTemplate.ScheduleTemplateDto;
import com.example.Test_1.models.entities.ScheduleTemplate;
import com.example.Test_1.repositories.ScheduleTemplateRepository;
import com.example.Test_1.services.interfaces.ScheduleTemplateService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultScheduleTemplateService implements ScheduleTemplateService {
    @Autowired
    private ScheduleTemplateRepository scheduleTemplateRepository;

    @Override
    public String createEntity(ScheduleTemplateCreateRequest request) {
        var entity = ScheduleTemplate.builder()
                .templateType(request.templateType)
                .build();

        scheduleTemplateRepository.save(entity);

        return entity.id;
    }

    @Override
    public ScheduleTemplateDto getEntityById(String id) {
        var entity = scheduleTemplateRepository.findById(id);

        return entity.map(e -> new ScheduleTemplateDto(
                e.id,
                e.creationDate,
                e.templateType
        )).orElse(null);
    }
}