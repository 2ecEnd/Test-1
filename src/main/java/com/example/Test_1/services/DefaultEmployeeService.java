package com.example.Test_1.services;

import com.example.Test_1.models.dto.Employee.EmployeeCreateRequest;
import com.example.Test_1.models.dto.Employee.EmployeeDto;
import com.example.Test_1.models.entities.Employee;
import com.example.Test_1.repositories.EmployeeRepository;
import com.example.Test_1.services.interfaces.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultEmployeeService implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEntity(EmployeeCreateRequest request) {
        var entity = Employee.builder()
                .employeeName(request.employeeName)
                .status(request.status)
                .position(request.position)
                .build();

        employeeRepository.save(entity);

        return entity.id;
    }

    public EmployeeDto getEntityById(String id) {
        var entity = employeeRepository.findById(id);

        return entity.map(e -> new EmployeeDto(
                e.id,
                e.employeeName,
                e.status,
                e.position
        )).orElse(null);
    }
}