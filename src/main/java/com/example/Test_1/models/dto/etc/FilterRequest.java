package com.example.Test_1.models.dto.etc;

import com.example.Test_1.models.enums.SlotType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterRequest {
    @JsonProperty("Id")
    @Nullable
    public String id;

    @JsonProperty("SlotId")
    @Nullable
    public String slotId;

    @JsonProperty("ScheduleId")
    @Nullable
    public String scheduleId;

    @JsonProperty("SlotType")
    @Nullable
    public SlotType slotType;

    @JsonProperty("AdministratorId")
    @Nullable
    public String administratorId;

    @JsonProperty("ExecutorId")
    @Nullable
    public String executorId;
}