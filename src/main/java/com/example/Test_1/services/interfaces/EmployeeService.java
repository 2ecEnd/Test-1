package com.example.Test_1.services.interfaces;

import com.example.Test_1.models.dto.Employee.EmployeeCreateRequest;
import com.example.Test_1.models.dto.Employee.EmployeeDto;

public interface EmployeeService {
    String createEntity(EmployeeCreateRequest request);

    EmployeeDto getEntityById(String id);
}