package com.example.Test_1.models.dto.employee;

import com.example.Test_1.models.enums.PositionType;
import com.example.Test_1.models.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @JsonProperty("Id")
    public String id;

    @JsonProperty("EmployeeName")
    public String employeeName;

    @JsonProperty("Status")
    public StatusType status;

    @JsonProperty("Position")
    public PositionType position;
}