package com.example.Test_1.repositories;

import com.example.Test_1.models.entities.Schedule;
import com.example.Test_1.models.entities.SchedulePeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchedulePeriodRepository extends JpaRepository<SchedulePeriod, String> {
}