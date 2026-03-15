package com.example.Test_1.repositories;

import com.example.Test_1.models.dto.etc.FilterRequest;
import com.example.Test_1.models.entities.Schedule;
import com.example.Test_1.models.entities.SchedulePeriod;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface SchedulePeriodRepository
        extends JpaRepository<SchedulePeriod, String>,
        JpaSpecificationExecutor<SchedulePeriod> {
}