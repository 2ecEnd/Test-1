package com.example.Test_1.controllers;

import com.example.Test_1.models.dto.CreateResponse;
import com.example.Test_1.models.dto.FilterRequest;
import com.example.Test_1.models.dto.PaginationRequest;
import com.example.Test_1.models.dto.SchedulePeriod.SchedulePeriodCreateRequest;
import com.example.Test_1.models.dto.SchedulePeriod.SchedulePeriodDto;
import com.example.Test_1.models.dto.SortRequest;
import com.example.Test_1.services.interfaces.SchedulePeriodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Filter;

@RestController
@RequestMapping("/schedulePeriod")
@AllArgsConstructor
public class SchedulePeriodController {
    private SchedulePeriodService schedulePeriodService;

    @PostMapping
    public ResponseEntity<CreateResponse> createEntity(@RequestBody SchedulePeriodCreateRequest request) {
        return ResponseEntity.ok(new CreateResponse(schedulePeriodService.createEntity(request)));
    }

    @GetMapping
    public ResponseEntity<SchedulePeriodDto> getEntityById(@RequestParam String id) {
        SchedulePeriodDto entity = schedulePeriodService.getEntityById(id);
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