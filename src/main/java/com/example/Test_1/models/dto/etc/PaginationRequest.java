package com.example.Test_1.models.dto.etc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PaginationRequest {
    @JsonProperty(value = "Page", defaultValue = "0")
    public Integer page = 0;

    @JsonProperty(value = "Size", defaultValue = "5")
    public Integer size = 5;
}