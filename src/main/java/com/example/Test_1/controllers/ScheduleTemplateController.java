package com.example.Test_1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scheduleTemplate")
@AllArgsConstructor
public class ScheduleTemplateController {
    @PostMapping
    public ResponseEntity createEntity() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getEntityById(@RequestParam String id) {
        return ResponseEntity.ok().build();
    }
}