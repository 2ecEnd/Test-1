package com.example.Test_1.controllers;

import com.example.Test_1.models.dto.etc.CreateResponse;
import com.example.Test_1.models.dto.schedule.ScheduleCreateRequest;
import com.example.Test_1.models.dto.schedule.ScheduleDto;
import com.example.Test_1.services.interfaces.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
    public ResponseEntity<List<ScheduleDto>> getOneEntity(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String name
    ) {
        if (id == null && name == null) {
            return ResponseEntity.badRequest().build();
        }

        ArrayList<ScheduleDto> response;
        if (name != null) {
            response = new ArrayList<ScheduleDto>(scheduleService.getEntityByName(name));

            if (id != null) {
                response.removeIf(el -> !Objects.equals(el.id, id));
            }
        }
        else {
            response = new ArrayList<ScheduleDto>(scheduleService.getEntityById(id));
        }

        return ResponseEntity.ok(response);
    }
}