package com.example.Test_1.controllers;

import com.example.Test_1.models.dto.etc.CreateResponse;
import com.example.Test_1.models.dto.ScheduleSlot.ScheduleSlotCreateRequest;
import com.example.Test_1.models.dto.ScheduleSlot.ScheduleSlotDto;
import com.example.Test_1.models.dto.etc.GetByIdRequest;
import com.example.Test_1.services.interfaces.ScheduleSlotService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduleSlot")
@AllArgsConstructor
public class ScheduleSlotController {
    @Autowired
    private ScheduleSlotService scheduleSlotService;

    @PostMapping
    public ResponseEntity<CreateResponse> createEntity(@RequestBody ScheduleSlotCreateRequest request) {
        return ResponseEntity.ok(new CreateResponse(scheduleSlotService.createEntity(request)));
    }

    @GetMapping
    public ResponseEntity<ScheduleSlotDto> getEntityById(@RequestBody GetByIdRequest request) {
        ScheduleSlotDto entity = scheduleSlotService.getEntityById(request.id);

        return entity == null ?
                ResponseEntity.badRequest().build() :
                ResponseEntity.ok(entity);
    }
}