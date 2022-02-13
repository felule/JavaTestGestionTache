package com.gestionnairetache.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class TacheDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String label;
    private boolean complete;
}
