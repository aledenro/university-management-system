CREATE TABLE Estudiante (
    id_estudiante INT NOT NULL,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    email VARCHAR(50),
    num_celular int,
    PRIMARY KEY (id_estudiante)
);

ALTER TABLE Estudiante
ADD(cedula varchar(15));

CREATE TABLE Matricula (
    id_matricula INT NOT NULL,
    fechaMatricula date,
    id_estudiante INT,
    id_asignatura INT,
    id_horario INT,
    PRIMARY KEY (id_matricula)
);

CREATE TABLE Horarios (
    id_horario INT NOT NULL,
    dia VARCHAR(20),
    horaInicio date,
    horaFinaliza date,
    id_asignatura INT,
    id_aula INT,
    PRIMARY KEY (id_horario)
);

/*Ejemplo para insertar la hora
INSERT INTO Horarios (id_horario, dia, horaInicio, horaFinaliza)
VALUES (1, 'Lunes', TO_DATE('12:30:00', 'HH24:MI:SS'), TO_DATE('14:30:00', 'HH24:MI:SS'));
select * from horarios

SELECT 
    id_horario,
    dia,
    TO_CHAR(horaInicio, 'HH24:MI:SS') AS horaInicio,
    TO_CHAR(horaFinaliza, 'HH24:MI:SS') AS horaFinaliza
FROM Horarios;
*/

CREATE TABLE Aula (
    id_aula INT NOT NULL,
    capacidad int,
    PRIMARY KEY (id_aula)
);


CREATE TABLE Asignatura (
    id_asignatura INT NOT NULL,
    nombre varchar(50),
    creditos int,
    id_departamento INT,
    id_profesor INT,
    PRIMARY KEY (id_asignatura)
);

CREATE TABLE Grupos (
    id_grupo INT NOT NULL,
    num_estudiantes int,
    id_asignatura INT,
    id_profesor INT,
    PRIMARY KEY (id_grupo)
);

CREATE TABLE Departamento (
    id_departamento INT NOT NULL,
    nombre varchar(50),
    locacion varchar(50),
    PRIMARY KEY (id_departamento)
);

CREATE TABLE Profesores (
    id_profesor INT NOT NULL,
    nombre varchar(50),
    apellido varchar(50),
    email VARCHAR(50),
    num_celular int,
    PRIMARY KEY (id_profesor)
);

ALTER TABLE Profesores
ADD(cedula varchar(15));

CREATE TABLE Usuarios(
    id_usuario INT NOT NULL,
    nombre varchar(50),
    apellido varchar(50),
    email VARCHAR(50),
    contrasena VARCHAR(50),
    activo CHAR(1),
    PRIMARY KEY (id_usuario)
);

/*FOREIGN KEY Tabla matricula*/
ALTER TABLE Matricula
ADD CONSTRAINT fk_estudiante
FOREIGN KEY (id_estudiante)
REFERENCES Estudiante (id_estudiante);

ALTER TABLE Matricula
ADD CONSTRAINT fk_asignatura
FOREIGN KEY (id_asignatura)
REFERENCES Asignatura (id_asignatura);

ALTER TABLE Matricula
ADD CONSTRAINT fk_horario
FOREIGN KEY (id_horario)
REFERENCES Horarios (id_horario);

/*FOREIGN KEY Tabla Horarios*/

ALTER TABLE Horarios
ADD CONSTRAINT fk2_asignatura
FOREIGN KEY (id_asignatura)
REFERENCES Asignatura (id_asignatura);

ALTER TABLE Horarios
ADD CONSTRAINT fk_aula
FOREIGN KEY (id_aula)
REFERENCES Aula (id_aula);


/*FOREIGN KEY Tabla Asignatura*/

ALTER TABLE Asignatura
ADD CONSTRAINT fk_departamento
FOREIGN KEY (id_departamento)
REFERENCES Departamento (id_departamento);

ALTER TABLE Asignatura
ADD CONSTRAINT fk_profesor
FOREIGN KEY (id_profesor)
REFERENCES Profesores (id_profesor);




/*FOREIGN KEY Tabla Grupos*/

ALTER TABLE Grupos
ADD CONSTRAINT fk3_asignatura
FOREIGN KEY (id_asignatura)
REFERENCES Asignatura (id_asignatura);

ALTER TABLE Grupos
ADD CONSTRAINT fk2_profesor
FOREIGN KEY (id_profesor)
REFERENCES Profesores (id_profesor);






