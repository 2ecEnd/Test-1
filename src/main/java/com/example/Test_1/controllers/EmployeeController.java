package com.example.Test_1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    @PostMapping
    public ResponseEntity createEntity() {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getEntityById(@RequestParam String id) {
        return ResponseEntity.ok().build();
    }
}