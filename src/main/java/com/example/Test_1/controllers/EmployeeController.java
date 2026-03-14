package com.example.Test_1.controllers;

import com.example.Test_1.models.dto.etc.CreateResponse;
import com.example.Test_1.models.dto.Employee.EmployeeCreateRequest;
import com.example.Test_1.models.dto.Employee.EmployeeDto;
import com.example.Test_1.models.dto.etc.GetByIdRequest;
import com.example.Test_1.services.interfaces.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<CreateResponse> createEntity(@RequestBody EmployeeCreateRequest request) {
        return ResponseEntity.ok(new CreateResponse(employeeService.createEntity(request)));
    }

    @GetMapping
    public ResponseEntity<EmployeeDto> getEntityById(@RequestBody GetByIdRequest request) {
        var entity = employeeService.getEntityById(request.id);

        return entity == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(entity);
    }
}