package com.example.Test_1.repositories;

import com.example.Test_1.models.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    @Query(value = "SELECT * FROM schedules WHERE schedule_name ~ ?1", nativeQuery = true)
    List<Optional<Schedule>> findByScheduleNameRegex(String regex);
}