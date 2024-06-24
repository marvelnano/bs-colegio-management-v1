package com.school.bs_student_management_v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nombres")
    private String nombres;

    @JsonProperty("apellidos")
    private String apellidos;

    @JsonProperty("edad")
    private Long edad;
    
}
