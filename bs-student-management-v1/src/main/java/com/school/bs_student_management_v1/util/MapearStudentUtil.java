package com.school.bs_student_management_v1.util;

import java.util.List;

import com.school.bs_student_management_v1.model.dto.StudentDTO;
import com.school.bs_student_management_v1.model.dto.StudentResponse;
import com.school.bs_student_management_v1.model.entity.StudentEntity;

public class MapearStudentUtil {

    MapearStudentUtil(){

    }

    public static List<StudentResponse> toListStudentResponse(List<StudentEntity> users){
        
        return users.stream().map(l -> StudentResponse.builder()
            .id(l.getId())
            .nombres(l.getNombres())
            .apellidos(l.getApellidos())
            .edad(l.getEdad()).build())
        .toList();

    }

    public static StudentEntity toStudentEntity(StudentDTO body) {

		return StudentEntity.builder()
        .nombres(body.getNombres() != null ? body.getNombres() : null)
        .apellidos(body.getApellidos() != null ? body.getApellidos() : null)
        .edad(body.getEdad() != null ? body.getEdad() : null)
        .build();
        
	}

}
