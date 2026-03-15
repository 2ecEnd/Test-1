package com.example.Test_1.models.dto.etc;

import com.example.Test_1.models.enums.Field;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortRequest {
    @JsonProperty("Field")
    public Field field;

    @JsonProperty("Direction")
    public Sort.Direction direction;
}