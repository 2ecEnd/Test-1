package com.example.Test_1.models.entities;

import com.example.Test_1.models.enums.PositionType;
import com.example.Test_1.models.enums.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "employees")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "id", length = 32, nullable = false)
    public String id;

    @Column(name = "employee_name", length = 255, nullable = false)
    public String employeeName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    public StatusType status;

    @Enumerated(EnumType.STRING)
    @Column(name = "position", length = 20, nullable = false)
    public PositionType position = PositionType.UNDEFINED;

    @PrePersist
    protected void onCreate() {
        id = UUID.randomUUID().toString().replace("-", "");
    }
}