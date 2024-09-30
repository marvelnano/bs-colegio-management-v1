DROP TABLE IF EXISTS students;

CREATE TABLE courses (
    id_course INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre VARCHAR(50),
    horas_teoria INT,
    horas_practica INT,
    profesor VARCHAR(150)
);