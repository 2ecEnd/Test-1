package com.example.Test_1.repositories;

import com.example.Test_1.models.dto.etc.FilterRequest;
import com.example.Test_1.models.entities.Schedule;
import com.example.Test_1.models.entities.SchedulePeriod;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SchedulePeriodRepository
        extends JpaRepository<SchedulePeriod, String>,
        JpaSpecificationExecutor<SchedulePeriod> {
    public List<SchedulePeriod> findAllByScheduleId(String id);

    @Query(value = "" +
            "SELECT * FROM schedule_periods " +
            "WHERE executor_id = ?1 " +
            "OR executor_id IS NULL AND administrator_id = ?1", nativeQuery = true)
    public List<SchedulePeriod> findAllByExecutorId(String id);
}