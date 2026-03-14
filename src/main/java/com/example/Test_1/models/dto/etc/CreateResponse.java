package com.example.Test_1.models.dto.etc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateResponse {
    @JsonProperty("Id")
    public String id;
}