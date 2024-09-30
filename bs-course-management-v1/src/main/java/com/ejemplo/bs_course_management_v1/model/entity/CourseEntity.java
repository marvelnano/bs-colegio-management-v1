package com.ejemplo.bs_course_management_v1.model.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CourseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course", nullable = false)
    private Long idCurso;

    private String nombre;

    @Column(name = "horas_teoria", nullable = false)
    private Long horasTeoria;

    @Column(name = "horas_practica", nullable = false)
    private Long horasPractica;

    private String profesor;

    private static final long serialVersionUID = 6690689988058914671L;
    
}
