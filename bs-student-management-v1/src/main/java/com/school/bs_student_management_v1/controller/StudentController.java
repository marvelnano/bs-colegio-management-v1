package com.school.bs_student_management_v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.bs_student_management_v1.model.dto.RespuestaCreadoExito;
import com.school.bs_student_management_v1.model.dto.StudentRequest;
import com.school.bs_student_management_v1.service.StudentService;

import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/v1/students")
    RespuestaCreadoExito getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/v1/students/{id}")
    RespuestaCreadoExito getByStudent(@PathVariable("id") Long idStudent) {        
        return studentService.getByStudent(idStudent);
    }
    

    @PostMapping("/v1/students")
    RespuestaCreadoExito addStudent(@RequestBody StudentRequest studentRequest) {        
        return studentService.addStudent(studentRequest);
    }

    @PutMapping("/v1/students/{id}")
    RespuestaCreadoExito updateStudent(@PathVariable("id") Long idStudent,
        @RequestBody StudentRequest studentRequest) {        
        return studentService.updateStudent(idStudent, studentRequest);
    }

    @DeleteMapping("/v1/students/{id}")
    RespuestaCreadoExito deleteStudent(@PathVariable("id") Long idStudent) {        
        return studentService.deleteStudent(idStudent);
    }
        
}
