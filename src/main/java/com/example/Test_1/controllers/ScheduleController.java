package com.example.Test_1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {
    @PostMapping
    public ResponseEntity createEntity() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getEntityById(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String name
    ) {
        return ResponseEntity.ok().build();
    }
}