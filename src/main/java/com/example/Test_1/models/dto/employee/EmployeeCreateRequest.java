package com.example.Test_1.models.dto.employee;

import com.example.Test_1.models.enums.PositionType;
import com.example.Test_1.models.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;

public class EmployeeCreateRequest {
    @JsonProperty("EmployeeName")
    public String employeeName;

    @JsonProperty("Status")
    public StatusType status;

    @JsonProperty("Position")
    @Nullable
    public PositionType position;
}
