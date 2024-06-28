package com.school.bs_student_management_v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.school.bs_student_management_v1.model.dto.RespuestaCreadoExito;
import com.school.bs_student_management_v1.model.dto.UserRequest;
import com.school.bs_student_management_v1.model.dto.UserResponse;
import com.school.bs_student_management_v1.model.entity.UserEntity;
import com.school.bs_student_management_v1.repository.UserRepository;
import com.school.bs_student_management_v1.service.UserService;
import com.school.bs_student_management_v1.util.MapearUserUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    //private static String msgError = "Error";

    @Autowired
    UserRepository userRepository;

    @Override
    public RespuestaCreadoExito getAllUsers(){
        RespuestaCreadoExito response = null;

        var users = userRepository.findAll();
        List<UserResponse> data =  MapearUserUtil.toListUserResponse(users);

        response = RespuestaCreadoExito.builder()
				.codigo(HttpStatus.OK.value())
				.estado("OK")
				.datos(data)
                .build();
		
		return response;

    }

    @Override
    public RespuestaCreadoExito addUser(UserRequest body){
        RespuestaCreadoExito response = null;
        UserEntity user = null;

        user = MapearUserUtil.toUserEntity(body);

        log.info("User added: {}"+user);

        response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Ok")
            .datos(userRepository.save(user))
            .build();

        return response;
    }

    @Override
    public RespuestaCreadoExito updateUser(Long idUser, UserRequest body){
        RespuestaCreadoExito response = null;
        UserEntity user = null;        

        var datosUser = userRepository.findById(idUser).orElse(null);

        if(datosUser != null){
            user = MapearUserUtil.toUserEntity(body);
            user.setId(datosUser.getId());

            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Ok")
            .datos(userRepository.save(user))
            .build();
        }else{
            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("No se pudo encontrar el usuario con el código: "+idUser)
            .datos(null)
            .build();
        }

        log.info("User updated: {}"+user);        

        return response;
    }

    @Override
    public RespuestaCreadoExito deleteUser(Long idUser){
        RespuestaCreadoExito response = null;
        UserEntity student = userRepository.findById(idUser).orElse(null);

        if(student != null){
            userRepository.delete(student);

            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("Alumno eliminado")
            .datos(student)
            .build();
        }else{
            response = RespuestaCreadoExito.builder()
            .codigo(HttpStatus.OK.value())
            .estado("No se pudo encontrar el alumno con el código: "+idUser)
            .datos(null)
            .build();
        }

        log.info("Student deleted: {}"+student);        

        return response;
    }

}
