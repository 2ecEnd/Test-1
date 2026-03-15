package com.example.Test_1.controllers;

import com.example.Test_1.models.dto.etc.*;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodCreateRequest;
import com.example.Test_1.models.dto.schedulePeriod.SchedulePeriodDto;
import com.example.Test_1.models.entities.SchedulePeriod;
import com.example.Test_1.services.interfaces.SchedulePeriodService;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
            @ModelAttribute FilterRequest filter,
            @ModelAttribute SortRequest sort,
            @ModelAttribute PaginationRequest pagination
    ) {
        var paging = PageRequest.of(
                pagination.page,
                pagination.size
                );

        if (sort.field != null) {
            paging = paging.withSort(
                    Sort.by(
                            sort.direction,
                            sort.field.toString())
            );
        }

        Specification<SchedulePeriod> specs = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.id != null) {
                predicates.add(cb.equal(root.get("id"), filter.id));
            }
            if (filter.slotId != null) {
                predicates.add(cb.equal(root.get("slot").get("id"), filter.slotId));
            }
            if (filter.scheduleId != null) {
                predicates.add(cb.equal(root.get("schedule").get("id"), filter.scheduleId));
            }
            if (filter.slotType != null) {
                predicates.add(cb.equal(root.get("slotType"), filter.slotType));
            }
            if (filter.administratorId != null) {
                predicates.add(cb.equal(root.get("administrator").get("id"), filter.administratorId));
            }
            if (filter.executorId != null) {
                predicates.add(cb.equal(root.get("executor").get("id"), filter.executorId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };

        return ResponseEntity.ok(schedulePeriodService.getEntities(specs, paging));
    }
}