package com.example.Test_1.controllers;

import com.example.Test_1.models.dto.etc.*;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodCreateRequest;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodDto;
import com.example.Test_1.services.interfaces.SchedulePeriodService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedulePeriod")
@AllArgsConstructor
public class SchedulePeriodController {
    @Autowired
    private SchedulePeriodService schedulePeriodService;

    @PostMapping
    public ResponseEntity<CreateResponse> createEntity(
            @RequestBody SchedulePeriodCreateRequest request,
            @RequestHeader("x-current-user") String currentUser
    ) {
        return ResponseEntity.ok(new CreateResponse(schedulePeriodService.createEntity(request, currentUser)));
    }

    @GetMapping("/id")
    public ResponseEntity<SchedulePeriodDto> getEntityById(@RequestBody GetByIdRequest request) {
        SchedulePeriodDto entity = schedulePeriodService.getEntityById(request.id);
        return entity == null ?
                ResponseEntity.badRequest().build() :
                ResponseEntity.ok(entity);
    }

    @GetMapping
    public ResponseEntity<List<SchedulePeriodDto>> getEntities(
            @RequestParam FilterRequest filter,
            @RequestParam SortRequest sort,
            @RequestParam PaginationRequest pagination
    ) {
        return ResponseEntity.ok(schedulePeriodService.getEntities(filter, sort, pagination));
    }
}