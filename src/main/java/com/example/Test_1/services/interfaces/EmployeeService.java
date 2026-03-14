package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.employee.EmployeeCreateRequest;
import com.example.Test_1.models.dto.employee.EmployeeDto;

public interface EmployeeService {
    String createEntity(EmployeeCreateRequest request);

    EmployeeDto getEntityById(String id);
}