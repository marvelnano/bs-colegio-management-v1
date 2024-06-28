package com.school.bs_student_management_v1.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    private Long id;
    private String nombres;
    private String apellidos;
    private Long edad;
    
}
