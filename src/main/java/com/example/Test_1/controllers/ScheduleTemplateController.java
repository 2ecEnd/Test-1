package com.example.Test_1.controllers;

import com.example.Test_1.models.dto.etc.CreateResponse;
import com.example.Test_1.models.dto.ScheduleTemplate.ScheduleTemplateCreateRequest;
import com.example.Test_1.models.dto.ScheduleTemplate.ScheduleTemplateDto;
import com.example.Test_1.models.dto.etc.GetByIdRequest;
import com.example.Test_1.services.interfaces.ScheduleTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduleTemplate")
@AllArgsConstructor
public class ScheduleTemplateController {
    @Autowired
    private ScheduleTemplateService scheduleTemplateService;

    @PostMapping
    public ResponseEntity<CreateResponse> createEntity(@RequestBody ScheduleTemplateCreateRequest request)  {
        return ResponseEntity.ok(new CreateResponse(scheduleTemplateService.createEntity(request)));
    }

    @GetMapping
    public ResponseEntity<ScheduleTemplateDto> getEntityById(@RequestBody GetByIdRequest request) {
        ScheduleTemplateDto entity = scheduleTemplateService.getEntityById(request.id);

        return entity == null ?
                ResponseEntity.badRequest().build() :
                ResponseEntity.ok(entity);
    }
}