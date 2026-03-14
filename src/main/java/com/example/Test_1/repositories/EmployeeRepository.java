package com.example.Test_1.repositories;

import com.example.Test_1.models.entities.Employee;
import com.example.Test_1.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}