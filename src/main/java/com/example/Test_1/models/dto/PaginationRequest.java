package com.example.Test_1.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationRequest {
    @JsonProperty("Page")
    public Integer page;

    @JsonProperty("Size")
    public Integer size;
}