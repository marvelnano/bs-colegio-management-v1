package com.school.bs_student_management_v1.service;

import com.school.bs_student_management_v1.model.dto.RespuestaCreadoExito;
import com.school.bs_student_management_v1.model.dto.StudentDTO;

public interface StudentService {
    
    public RespuestaCreadoExito getAllStudents();
    public RespuestaCreadoExito getByStudent(Long idStudent);
    public RespuestaCreadoExito addStudent(StudentDTO studentRequest);
    public RespuestaCreadoExito updateStudent(Long idStudent, StudentDTO studentRequest);
    public RespuestaCreadoExito deleteStudent(Long idStudent);

}
