package com.school.bs_student_management_v1.service;

import com.school.bs_student_management_v1.model.dto.RespuestaCreadoExito;
import com.school.bs_student_management_v1.model.dto.UserRequest;

public interface UserService {
    
    public RespuestaCreadoExito getAllUsers();
    public RespuestaCreadoExito addUser(UserRequest userRequest);
    public RespuestaCreadoExito updateUser(Long idUser, UserRequest userRequest);
    public RespuestaCreadoExito deleteUser(Long idUser);

}
