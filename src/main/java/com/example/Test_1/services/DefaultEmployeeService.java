package com.example.Test_1.services;

import com.example.Test_1.models.dto.employee.EmployeeCreateRequest;
import com.example.Test_1.models.dto.employee.EmployeeDto;
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

    @Override
    public String createEntity(EmployeeCreateRequest request) {
        var entity = Employee.builder()
                .employeeName(request.employeeName)
                .status(request.status)
                .build();

        if (request.position != null) {
            entity.position = request.position;
        }

        employeeRepository.save(entity);

        return entity.id;
    }

    @Override
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