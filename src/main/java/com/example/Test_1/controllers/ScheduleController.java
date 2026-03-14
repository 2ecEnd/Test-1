package com.example.Test_1.controllers;

import com.example.Test_1.models.dto.etc.CreateResponse;
import com.example.Test_1.models.dto.Schedule.ScheduleCreateRequest;
import com.example.Test_1.models.dto.Schedule.ScheduleDto;
import com.example.Test_1.services.interfaces.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<CreateResponse> createEntity(@RequestBody ScheduleCreateRequest request) {
        return ResponseEntity.ok(new CreateResponse(scheduleService.createEntity(request)));
    }

    @GetMapping
    public ResponseEntity<ScheduleDto> getEntityById(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String name
    ) {
        if (id == null && name == null) {
            return ResponseEntity.badRequest().build();
        }

        ScheduleDto entity;
        if (id != null && name != null) {
            entity = scheduleService.getEntityById(id);

            if (!Objects.equals(entity.scheduleName, name)) {
                return ResponseEntity.badRequest().build();
            }
        }

        if (id != null) {
            entity = scheduleService.getEntityById(id);
        }
        else {
            entity = scheduleService.getEntityByName(name);
        }

        return entity == null ?
                ResponseEntity.badRequest().build() :
                ResponseEntity.ok(entity);
    }
}