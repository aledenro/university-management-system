TRUNCATE TABLE Matricula;
TRUNCATE TABLE Horarios;
TRUNCATE TABLE Grupos;
TRUNCATE TABLE Asignatura;
TRUNCATE TABLE Aula;
TRUNCATE TABLE Profesores;
TRUNCATE TABLE Departamento;
TRUNCATE TABLE Estudiante;


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
    id_horario INT,
    PRIMARY KEY (id_matricula)
);

CREATE TABLE Horarios (
    id_horario INT NOT NULL,
    dia VARCHAR(20),
    horaInicio date,
    horaFinaliza date,
    id_grupo INT,
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
ADD CONSTRAINT fk_horario
FOREIGN KEY (id_horario)
REFERENCES Horarios (id_horario);

/*FOREIGN KEY Tabla Horarios*/

ALTER TABLE Horarios
ADD CONSTRAINT fk2_grupo
FOREIGN KEY (id_grupo)
REFERENCES Grupos (id_grupo);

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

--------------------------------------------- inserts ----------------------------------------------

truncate table estudiante;
INSERT ALL
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (1, 'Aarón', 'Álvarez', 'aaron.alvarez@gmail.com', 600000001)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (2, 'Beatriz', 'Bravo', 'beatriz.bravo@gmail.com', 600000002)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (3, 'Carlos', 'Castillo', 'carlos.castillo@gmail.com', 600000003)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (4, 'Daniela', 'Delgado', 'daniela.delgado@gmail.com', 600000004)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (5, 'Eduardo', 'Escobar', 'eduardo.escobar@gmail.com', 600000005)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (6, 'Fernanda', 'Figueroa', 'fernanda.figueroa@gmail.com', 600000006)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (7, 'Gabriel', 'García', 'gabriel.garcia@gmail.com', 600000007)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (8, 'Helena', 'Hernández', 'helena.hernandez@gmail.com', 600000008)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (9, 'Iván', 'Iglesias', 'ivan.iglesias@gmail.com', 600000009)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (10, 'Joaquín', 'Jiménez', 'joaquin.jimenez@gmail.com', 600000010)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (11, 'Karina', 'Klein', 'karina.klein@gmail.com', 600000011)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (12, 'Luis', 'López', 'luis.lopez@gmail.com', 600000012)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (13, 'Marta', 'Martínez', 'marta.martinez@gmail.com', 600000013)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (14, 'Nicolás', 'Núñez', 'nicolas.nunez@gmail.com', 600000014)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (15, 'Olga', 'Orellana', 'olga.orellana@gmail.com', 600000015)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (16, 'Pedro', 'Pérez', 'pedro.perez@gmail.com', 600000016)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (17, 'Quiana', 'Quintero', 'quiana.quintero@gmail.com', 600000017)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (18, 'Rafael', 'Ramírez', 'rafael.ramirez@gmail.com', 600000018)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (19, 'Sandra', 'Serrano', 'sandra.serrano@gmail.com', 600000019)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (20, 'Tomás', 'Torres', 'tomas.torres@gmail.com', 600000020)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (21, 'Úrsula', 'Uribe', 'ursula.uribe@gmail.com', 600000021)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (22, 'Víctor', 'Valencia', 'victor.valencia@gmail.com', 600000022)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (23, 'Wendy', 'Wong', 'wendy.wong@gmail.com', 600000023)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (24, 'Ximena', 'Ximénez', 'ximena.ximenez@gmail.com', 600000024)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (25, 'Yolanda', 'Yanes', 'yolanda.yanes@gmail.com', 600000025)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (26, 'Zacarías', 'Zambrano', 'zacarias.zambrano@gmail.com', 600000026)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (27, 'Alicia', 'Arias', 'alicia.arias@gmail.com', 600000027)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (28, 'Bruno', 'Bermúdez', 'bruno.bermudez@gmail.com', 600000028)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (29, 'Carla', 'Castro', 'carla.castro@gmail.com', 600000029)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (30, 'David', 'Díaz', 'david.diaz@gmail.com', 600000030)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (31, 'Elena', 'Espinoza', 'elena.espinoza@gmail.com', 600000031)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (32, 'Fernando', 'Flores', 'fernando.flores@gmail.com', 600000032)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (33, 'Gabriela', 'Gómez', 'gabriela.gomez@gmail.com', 600000033)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (34, 'Héctor', 'Hernández', 'hector.hernandez@gmail.com', 600000034)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (35, 'Ivana', 'Ibarra', 'ivana.ibarra@gmail.com', 600000035)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (36, 'Javier', 'Jiménez', 'javier.jimenez@gmail.com', 600000036)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (37, 'Karol', 'Kozak', 'karol.kozak@gmail.com', 600000037)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (38, 'Luisana', 'Lara', 'luisana.lara@gmail.com', 600000038)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (39, 'Mario', 'Mendoza', 'mario.mendoza@gmail.com', 600000039)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (40, 'Natalia', 'Noriega', 'natalia.noriega@gmail.com', 600000040)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (41, 'Oscar', 'Ortega', 'oscar.ortega@gmail.com', 600000041)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (42, 'Patricia', 'Pineda', 'patricia.pineda@gmail.com', 600000042)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (43, 'Quintín', 'Quijano', 'quintin.quijano@gmail.com', 600000043)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (44, 'Rosa', 'Ríos', 'rosa.rios@gmail.com', 600000044)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (45, 'Samuel', 'Salazar', 'samuel.salazar@gmail.com', 600000045)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (46, 'Teresa', 'Trujillo', 'teresa.trujillo@gmail.com', 600000046)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (47, 'Ubaldo', 'Uribe', 'ubaldo.uribe@gmail.com', 600000047)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (48, 'Valeria', 'Vega', 'valeria.vega@gmail.com', 600000048)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (49, 'Walter', 'Waltz', 'walter.waltz@gmail.com', 600000049)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (50, 'Xander', 'Xiang', 'xander.xiang@gmail.com', 600000050)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (51, 'Yolanda', 'Yanez', 'yolanda.yanez@gmail.com', 600000051)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (52, 'Zulma', 'Zúñiga', 'zulma.zuniga@gmail.com', 600000052)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (53, 'Alfredo', 'Aguirre', 'alfredo.aguirre@gmail.com', 600000053)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (54, 'Beatriz', 'Barrantes', 'beatriz.barrantes@gmail.com', 600000054)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (55, 'Carmen', 'Campos', 'carmen.campos@gmail.com', 600000055)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (56, 'Daniel', 'Delgado', 'daniel.delgado@gmail.com', 600000056)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (57, 'Esther', 'Espinosa', 'esther.espinosa@gmail.com', 600000057)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (58, 'Felipe', 'Flores', 'felipe.flores@gmail.com', 600000058)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (59, 'Gabriela', 'González', 'gabriela.gonzalez@gmail.com', 600000059)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (60, 'Héctor', 'Haro', 'hector.haro@gmail.com', 600000060)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (61, 'Isabel', 'Ibarra', 'isabel.ibarra@gmail.com', 600000061)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (62, 'Javier', 'Jiménez', 'javier.jimenez@gmail.com', 600000062)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (63, 'Karen', 'Klein', 'karen.klein@gmail.com', 600000063)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (64, 'Luis', 'López', 'luis.lopez@gmail.com', 600000064)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (65, 'Mónica', 'Martínez', 'monica.martinez@gmail.com', 600000065)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (66, 'Nicolás', 'Núñez', 'nicolas.nunez@gmail.com', 600000066)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (67, 'Oscar', 'Ortega', 'oscar.ortega@gmail.com', 600000067)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (68, 'Patricia', 'Pérez', 'patricia.perez@gmail.com', 600000068)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (69, 'Quintín', 'Quintero', 'quintin.quintero@gmail.com', 600000069)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (70, 'Rosa', 'Ramírez', 'rosa.ramirez@gmail.com', 600000070)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (71, 'Sergio', 'Sánchez', 'sergio.sanchez@gmail.com', 600000071)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (72, 'Teresa', 'Torres', 'teresa.torres@gmail.com', 600000072)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (73, 'Ubaldo', 'Uribe', 'ubaldo.uribe@gmail.com', 600000073)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (74, 'Valeria', 'Vega', 'valeria.vega@gmail.com', 600000074)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (75, 'Walter', 'Waltz', 'walter.waltz@gmail.com', 600000075)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (76, 'Ximena', 'Ximénez', 'ximena.ximenez@gmail.com', 600000076)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (77, 'Yolanda', 'Yanez', 'yolanda.yanez@gmail.com', 600000077)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (78, 'Zulma', 'Zúñiga', 'zulma.zuniga@gmail.com', 600000078)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (79, 'Alicia', 'Arias', 'alicia.arias@gmail.com', 600000079)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (80, 'Bruno', 'Bermúdez', 'bruno.bermudez@gmail.com', 600000080)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (81, 'Carla', 'Castro', 'carla.castro@gmail.com', 600000081)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (82, 'David', 'Díaz', 'david.diaz@gmail.com', 600000082)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (83, 'Esther', 'Espinosa', 'esther.espinosa@gmail.com', 600000083)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (84, 'Felipe', 'Flores', 'felipe.flores@gmail.com', 600000084)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (85, 'Gabriela', 'González', 'gabriela.gonzalez@gmail.com', 600000085)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (86, 'Héctor', 'Haro', 'hector.haro@gmail.com', 600000086)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (87, 'Isabel', 'Ibarra', 'isabel.ibarra@gmail.com', 600000087)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (88, 'Javier', 'Jiménez', 'javier.jimenez@gmail.com', 600000088)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (89, 'Karen', 'Klein', 'karen.klein@gmail.com', 600000089)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (90, 'Luis', 'López', 'luis.lopez@gmail.com', 600000090)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (91, 'Mónica', 'Martínez', 'monica.martinez@gmail.com', 600000091)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (92, 'Nicolás', 'Núñez', 'nicolas.nunez@gmail.com', 600000092)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (93, 'Oscar', 'Ortega', 'oscar.ortega@gmail.com', 600000093)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (94, 'Patricia', 'Pérez', 'patricia.perez@gmail.com', 600000094)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (95, 'Quintín', 'Quintero', 'quintin.quintero@gmail.com', 600000095)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (96, 'Rosa', 'Ramírez', 'rosa.ramirez@gmail.com', 600000096)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (97, 'Sergio', 'Sánchez', 'sergio.sanchez@gmail.com', 600000097)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (98, 'Teresa', 'Torres', 'teresa.torres@gmail.com', 600000098)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (99, 'Ubaldo', 'Uribe', 'ubaldo.uribe@gmail.com', 600000099)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (100, 'Valeria', 'Vega', 'valeria.vega@gmail.com', 600000100)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (101, 'Walter', 'Waltz', 'walter.waltz@gmail.com', 600000101)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (102, 'Ximena', 'Ximénez', 'ximena.ximenez@gmail.com', 600000102)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (103, 'Yolanda', 'Yanez', 'yolanda.yanez@gmail.com', 600000103)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (104, 'Zulma', 'Zúñiga', 'zulma.zuniga@gmail.com', 600000104)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (105, 'Alicia', 'Arias', 'alicia.arias@gmail.com', 600000105)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (106, 'Bruno', 'Bermúdez', 'bruno.bermudez@gmail.com', 600000106)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (107, 'Carla', 'Castro', 'carla.castro@gmail.com', 600000107)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (108, 'David', 'Díaz', 'david.diaz@gmail.com', 600000108)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (109, 'Esther', 'Espinosa', 'esther.espinosa@gmail.com', 600000109)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (110, 'Felipe', 'Flores', 'felipe.flores@gmail.com', 600000110)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (111, 'Gabriela', 'González', 'gabriela.gonzalez@gmail.com', 600000111)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (112, 'Héctor', 'Haro', 'hector.haro@gmail.com', 600000112)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (113, 'Isabel', 'Ibarra', 'isabel.ibarra@gmail.com', 600000113)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (114, 'Javier', 'Jiménez', 'javier.jimenez@gmail.com', 600000114)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (115, 'Karen', 'Klein', 'karen.klein@gmail.com', 600000115)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (116, 'Luis', 'López', 'luis.lopez@gmail.com', 600000116)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (117, 'Mónica', 'Martínez', 'monica.martinez@gmail.com', 600000117)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (118, 'Nicolás', 'Núñez', 'nicolas.nunez@gmail.com', 600000118)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (119, 'Oscar', 'Ortega', 'oscar.ortega@gmail.com', 600000119)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (120, 'Patricia', 'Pérez', 'patricia.perez@gmail.com', 600000120)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (121, 'Quintín', 'Quintero', 'quintin.quintero@gmail.com', 600000121)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (122, 'Rosa', 'Ramírez', 'rosa.ramirez@gmail.com', 600000122)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (123, 'Sergio', 'Sánchez', 'sergio.sanchez@gmail.com', 600000123)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (124, 'Teresa', 'Torres', 'teresa.torres@gmail.com', 600000124)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (125, 'Ubaldo', 'Uribe', 'ubaldo.uribe@gmail.com', 600000125)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (126, 'Valeria', 'Vega', 'valeria.vega@gmail.com', 600000126)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (127, 'Walter', 'Waltz', 'walter.waltz@gmail.com', 600000127)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (128, 'Ximena', 'Ximénez', 'ximena.ximenez@gmail.com', 600000128)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (129, 'Yolanda', 'Yanez', 'yolanda.yanez@gmail.com', 600000129)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (130, 'Zulma', 'Zúñiga', 'zulma.zuniga@gmail.com', 600000130)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (131, 'Alicia', 'Arias', 'alicia.arias@gmail.com', 600000131)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (132, 'Bruno', 'Bermúdez', 'bruno.bermudez@gmail.com', 600000132)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (133, 'Carla', 'Castro', 'carla.castro@gmail.com', 600000133)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (134, 'David', 'Díaz', 'david.diaz@gmail.com', 600000134)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (135, 'Esther', 'Espinosa', 'esther.espinosa@gmail.com', 600000135)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (136, 'Felipe', 'Flores', 'felipe.flores@gmail.com', 600000136)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (137, 'Gabriela', 'González', 'gabriela.gonzalez@gmail.com', 600000137)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (138, 'Héctor', 'Haro', 'hector.haro@gmail.com', 600000138)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (139, 'Isabel', 'Ibarra', 'isabel.ibarra@gmail.com', 600000139)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (140, 'Javier', 'Jiménez', 'javier.jimenez@gmail.com', 600000140)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (141, 'Karen', 'Klein', 'karen.klein@gmail.com', 600000141)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (142, 'Luis', 'López', 'luis.lopez@gmail.com', 600000142)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (143, 'Mónica', 'Martínez', 'monica.martinez@gmail.com', 600000143)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (144, 'Nicolás', 'Núñez', 'nicolas.nunez@gmail.com', 600000144)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (145, 'Oscar', 'Ortega', 'oscar.ortega@gmail.com', 600000145)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (146, 'Patricia', 'Pérez', 'patricia.perez@gmail.com', 600000146)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (147, 'Quintín', 'Quintero', 'quintin.quintero@gmail.com', 600000147)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (148, 'Rosa', 'Ramírez', 'rosa.ramirez@gmail.com', 600000148)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (149, 'Sergio', 'Sánchez', 'sergio.sanchez@gmail.com', 600000149)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (150, 'Teresa', 'Torres', 'teresa.torres@gmail.com', 600000150)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (151, 'Ubaldo', 'Uribe', 'ubaldo.uribe@gmail.com', 600000151)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (152, 'Valeria', 'Vega', 'valeria.vega@gmail.com', 600000152)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (153, 'Walter', 'Waltz', 'walter.waltz@gmail.com', 600000153)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (154, 'Ximena', 'Ximénez', 'ximena.ximenez@gmail.com', 600000154)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (155, 'Yolanda', 'Yanez', 'yolanda.yanez@gmail.com', 600000155)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (156, 'Zulma', 'Zúñiga', 'zulma.zuniga@gmail.com', 600000156)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (157, 'Alicia', 'Arias', 'alicia.arias@gmail.com', 600000157)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (158, 'Bruno', 'Bermúdez', 'bruno.bermudez@gmail.com', 600000158)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (159, 'Carla', 'Castro', 'carla.castro@gmail.com', 600000159)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (160, 'David', 'Díaz', 'david.diaz@gmail.com', 600000160)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (161, 'Eduardo', 'Escobar', 'eduardo.escobar@gmail.com', 600000161)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (162, 'Fernanda', 'Figueroa', 'fernanda.figueroa@gmail.com', 600000162)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (163, 'Gabriel', 'García', 'gabriel.garcia@gmail.com', 600000163)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (164, 'Héctor', 'Haro', 'hector.haro@gmail.com', 600000164)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (165, 'Iván', 'Íñiguez', 'ivan.iniguez@gmail.com', 600000165)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (166, 'Jorge', 'Jiménez', 'jorge.jimenez@gmail.com', 600000166)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (167, 'Karina', 'Klein', 'karina.klein@gmail.com', 600000167)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (168, 'Luis', 'López', 'luis.lopez@gmail.com', 600000168)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (169, 'Mónica', 'Martínez', 'monica.martinez@gmail.com', 600000169)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (170, 'Nicolás', 'Núñez', 'nicolas.nunez@gmail.com', 600000170)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (171, 'Oscar', 'Ortega', 'oscar.ortega@gmail.com', 600000171)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (172, 'Patricia', 'Pérez', 'patricia.perez@gmail.com', 600000172)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (173, 'Quintín', 'Quintero', 'quintin.quintero@gmail.com', 600000173)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (174, 'Rosa', 'Ramírez', 'rosa.ramirez@gmail.com', 600000174)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (175, 'Sergio', 'Sánchez', 'sergio.sanchez@gmail.com', 600000175)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (176, 'Teresa', 'Torres', 'teresa.torres@gmail.com', 600000176)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (177, 'Ubaldo', 'Uribe', 'ubaldo.uribe@gmail.com', 600000177)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (178, 'Valeria', 'Vega', 'valeria.vega@gmail.com', 600000178)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (179, 'Walter', 'Waltz', 'walter.waltz@gmail.com', 600000179)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (180, 'Ximena', 'Ximénez', 'ximena.ximenez@gmail.com', 600000180)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (181, 'Yolanda', 'Yanez', 'yolanda.yanez@gmail.com', 600000181)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (182, 'Zulma', 'Zúñiga', 'zulma.zuniga@gmail.com', 600000182)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (183, 'Alicia', 'Arias', 'alicia.arias@gmail.com', 600000183)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (184, 'Bruno', 'Bermúdez', 'bruno.bermudez@gmail.com', 600000184)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (185, 'Carla', 'Castro', 'carla.castro@gmail.com', 600000185)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (186, 'David', 'Díaz', 'david.diaz@gmail.com', 600000186)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (187, 'Esther', 'Espinosa', 'esther.espinosa@gmail.com', 600000187)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (188, 'Felipe', 'Flores', 'felipe.flores@gmail.com', 600000188)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (189, 'Gabriela', 'González', 'gabriela.gonzalez@gmail.com', 600000189)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (190, 'Héctor', 'Haro', 'hector.haro@gmail.com', 600000190)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (191, 'Isabel', 'Ibarra', 'isabel.ibarra@gmail.com', 600000191)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (192, 'Javier', 'Jiménez', 'javier.jimenez@gmail.com', 600000192)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (193, 'Karen', 'Klein', 'karen.klein@gmail.com', 600000193)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (194, 'Luis', 'López', 'luis.lopez@gmail.com', 600000194)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (195, 'Mónica', 'Martínez', 'monica.martinez@gmail.com', 600000195)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (196, 'Nicolás', 'Núñez', 'nicolas.nunez@gmail.com', 600000196)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (197, 'Oscar', 'Ortega', 'oscar.ortega@gmail.com', 600000197)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (198, 'Patricia', 'Pérez', 'patricia.perez@gmail.com', 600000198)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (199, 'Quintín', 'Quintero', 'quintin.quintero@gmail.com', 600000199)
  INTO Estudiante (id_estudiante, nombre, apellido, email, num_celular) VALUES (200, 'Rosa', 'Ramírez', 'rosa.ramirez@gmail.com', 600000200)
SELECT * FROM dual;










/*INSERT PROFESORES*/


SELECT * FROM PROFESORES;

INSERT ALL
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (1, 'Ana', 'Gómez', 'ana.gomez@gmail.com', 600000201)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (2, 'Benjamín', 'Mora', 'benjamin.mora@gmail.com', 600000202)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (3, 'Carlos', 'Reyes', 'carlos.reyes@gmail.com', 600000203)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (4, 'Diana', 'Ríos', 'diana.rios@gmail.com', 600000204)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (5, 'Esteban', 'López', 'esteban.lopez@gmail.com', 600000205)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (6, 'Fernanda', 'Méndez', 'fernanda.mendez@gmail.com', 600000206)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (7, 'Gabriel', 'Vega', 'gabriel.vega@gmail.com', 600000207)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (8, 'Helena', 'Ortiz', 'helena.ortiz@gmail.com', 600000208)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (9, 'Ignacio', 'Pérez', 'ignacio.perez@gmail.com', 600000209)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (10, 'Julieta', 'García', 'julieta.garcia@gmail.com', 600000210)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (11, 'Kevin', 'Castro', 'kevin.castro@gmail.com', 600000211)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (12, 'Laura', 'Jiménez', 'laura.jimenez@gmail.com', 600000212)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (13, 'Manuel', 'Rodríguez', 'manuel.rodriguez@gmail.com', 600000213)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (14, 'Natalia', 'Morales', 'natalia.morales@gmail.com', 600000214)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (15, 'Óscar', 'Hernández', 'oscar.hernandez@gmail.com', 600000215)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (16, 'Paola', 'Valdez', 'paola.valdez@gmail.com', 600000216)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (17, 'Quintín', 'Mora', 'quintin.mora@gmail.com', 600000217)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (18, 'Rafael', 'Mendoza', 'rafael.mendoza@gmail.com', 600000218)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (19, 'Sofía', 'Ponce', 'sofia.ponce@gmail.com', 600000219)
  INTO Profesores (id_profesor, nombre, apellido, email, num_celular) VALUES (20, 'Tomás', 'Ruiz', 'tomas.ruiz@gmail.com', 600000220)
SELECT * FROM dual;


/*INSERT DEPARTAMENTOS */
INSERT ALL
  INTO Departamento (id_departamento, nombre, locacion) VALUES (1, 'Administración', 'Edificio A')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (2, 'Contabilidad', 'Edificio B')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (3, 'Informática', 'Edificio C')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (4, 'Matemáticas', 'Edificio D')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (5, 'Física', 'Edificio E')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (6, 'Química', 'Edificio F')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (7, 'Biología', 'Edificio G')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (8, 'Historia', 'Edificio H')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (9, 'Literatura', 'Edificio I')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (10, 'Arte', 'Edificio J')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (11, 'Psicología', 'Edificio K')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (12, 'Sociología', 'Edificio L')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (13, 'Economía', 'Edificio M')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (14, 'Derecho', 'Edificio N')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (15, 'Ingeniería Civil', 'Edificio O')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (16, 'Ingeniería Electrónica', 'Edificio P')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (17, 'Ingeniería Mecánica', 'Edificio Q')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (18, 'Ingeniería Industrial', 'Edificio R')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (19, 'Diseño Gráfico', 'Edificio S')
  INTO Departamento (id_departamento, nombre, locacion) VALUES (20, 'Gestión Empresarial', 'Edificio T')
SELECT * FROM dual;


/*INSERT DE ASIGNATURA*/

INSERT ALL
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (1, 'Gestión Empresarial', 3, 1, 1)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (2, 'Contabilidad Financiera', 4, 2, 2)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (3, 'Algoritmos y Estructuras de Datos', 5, 3, 3)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (4, 'Álgebra Lineal', 4, 4, 4)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (5, 'Física General', 4, 5, 5)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (6, 'Química Orgánica', 4, 6, 6)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (7, 'Biología Celular', 3, 7, 7)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (8, 'Historia Universal', 3, 8, 8)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (9, 'Literatura Comparada', 3, 9, 9)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (10, 'Teoría del Arte', 3, 10, 10)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (11, 'Psicología del Desarrollo', 4, 11, 11)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (12, 'Sociología del Trabajo', 4, 12, 12)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (13, 'Economía Internacional', 4, 13, 13)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (14, 'Derecho Constitucional', 5, 14, 14)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (15, 'Estructuras de Ingeniería', 5, 15, 15)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (16, 'Electrónica Analógica', 4, 16, 16)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (17, 'Termodinámica', 4, 17, 17)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (18, 'Logística y Operaciones', 4, 18, 18)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (19, 'Diseño Gráfico Digital', 3, 19, 19)
  INTO Asignatura (id_asignatura, nombre, creditos, id_departamento, id_profesor) VALUES (20, 'Gestión de Proyectos', 3, 20, 20)
SELECT * FROM dual;


/*INSERT GRUPO*/

INSERT ALL
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (1, 30, 1, 1)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (2, 25, 2, 2)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (3, 20, 3, 3)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (4, 28, 4, 4)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (5, 22, 5, 5)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (6, 27, 6, 6)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (7, 32, 7, 7)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (8, 30, 8, 8)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (9, 24, 9, 9)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (10, 26, 10, 10)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (11, 29, 11, 11)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (12, 23, 12, 12)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (13, 31, 13, 13)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (14, 21, 14, 14)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (15, 30, 15, 15)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (16, 28, 16, 16)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (17, 25, 17, 17)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (18, 26, 18, 18)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (19, 22, 19, 19)
  INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor) VALUES (20, 27, 20, 20)
SELECT * FROM dual;

/*INSERT AULA*/

INSERT ALL
  INTO Aula (id_aula, capacidad) VALUES (1, 30)
  INTO Aula (id_aula, capacidad) VALUES (2, 40)
  INTO Aula (id_aula, capacidad) VALUES (3, 50)
  INTO Aula (id_aula, capacidad) VALUES (4, 60)
  INTO Aula (id_aula, capacidad) VALUES (5, 70)
  INTO Aula (id_aula, capacidad) VALUES (6, 80)
  INTO Aula (id_aula, capacidad) VALUES (7, 90)
  INTO Aula (id_aula, capacidad) VALUES (8, 100)
  INTO Aula (id_aula, capacidad) VALUES (9, 110)
  INTO Aula (id_aula, capacidad) VALUES (10, 120)
  INTO Aula (id_aula, capacidad) VALUES (11, 130)
  INTO Aula (id_aula, capacidad) VALUES (12, 140)
  INTO Aula (id_aula, capacidad) VALUES (13, 150)
  INTO Aula (id_aula, capacidad) VALUES (14, 160)
  INTO Aula (id_aula, capacidad) VALUES (15, 170)
  INTO Aula (id_aula, capacidad) VALUES (16, 180)
  INTO Aula (id_aula, capacidad) VALUES (17, 190)
  INTO Aula (id_aula, capacidad) VALUES (18, 200)
  INTO Aula (id_aula, capacidad) VALUES (19, 210)
  INTO Aula (id_aula, capacidad) VALUES (20, 220)
SELECT * FROM dual;


/*INSERT HORARIO*/

INSERT ALL
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (1, 'Lunes', TO_DATE('08:00:00', 'HH24:MI:SS'), TO_DATE('10:00:00', 'HH24:MI:SS'), 1, 1)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (2, 'Lunes', TO_DATE('10:00:00', 'HH24:MI:SS'), TO_DATE('12:00:00', 'HH24:MI:SS'), 2, 2)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (3, 'Martes', TO_DATE('08:00:00', 'HH24:MI:SS'), TO_DATE('10:00:00', 'HH24:MI:SS'), 3, 3)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (4, 'Martes', TO_DATE('10:00:00', 'HH24:MI:SS'), TO_DATE('12:00:00', 'HH24:MI:SS'), 4, 4)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (5, 'Miércoles', TO_DATE('08:00:00', 'HH24:MI:SS'), TO_DATE('10:00:00', 'HH24:MI:SS'), 5, 5)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (6, 'Miércoles', TO_DATE('10:00:00', 'HH24:MI:SS'), TO_DATE('12:00:00', 'HH24:MI:SS'), 6, 6)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (7, 'Jueves', TO_DATE('08:00:00', 'HH24:MI:SS'), TO_DATE('10:00:00', 'HH24:MI:SS'), 7, 7)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (8, 'Jueves', TO_DATE('10:00:00', 'HH24:MI:SS'), TO_DATE('12:00:00', 'HH24:MI:SS'), 8, 8)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (9, 'Viernes', TO_DATE('08:00:00', 'HH24:MI:SS'), TO_DATE('10:00:00', 'HH24:MI:SS'), 9, 9)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (10, 'Viernes', TO_DATE('10:00:00', 'HH24:MI:SS'), TO_DATE('12:00:00', 'HH24:MI:SS'), 10, 10)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (11, 'Lunes', TO_DATE('13:00:00', 'HH24:MI:SS'), TO_DATE('15:00:00', 'HH24:MI:SS'), 11, 11)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (12, 'Lunes', TO_DATE('15:00:00', 'HH24:MI:SS'), TO_DATE('17:00:00', 'HH24:MI:SS'), 12, 12)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (13, 'Martes', TO_DATE('13:00:00', 'HH24:MI:SS'), TO_DATE('15:00:00', 'HH24:MI:SS'), 13, 13)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (14, 'Martes', TO_DATE('15:00:00', 'HH24:MI:SS'), TO_DATE('17:00:00', 'HH24:MI:SS'), 14, 14)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (15, 'Miércoles', TO_DATE('13:00:00', 'HH24:MI:SS'), TO_DATE('15:00:00', 'HH24:MI:SS'), 15, 15)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (16, 'Miércoles', TO_DATE('15:00:00', 'HH24:MI:SS'), TO_DATE('17:00:00', 'HH24:MI:SS'), 16, 16)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (17, 'Jueves', TO_DATE('13:00:00', 'HH24:MI:SS'), TO_DATE('15:00:00', 'HH24:MI:SS'), 17, 17)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (18, 'Jueves', TO_DATE('15:00:00', 'HH24:MI:SS'), TO_DATE('17:00:00', 'HH24:MI:SS'), 18, 18)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (19, 'Viernes', TO_DATE('13:00:00', 'HH24:MI:SS'), TO_DATE('15:00:00', 'HH24:MI:SS'), 19, 19)
  INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula) VALUES (20, 'Viernes', TO_DATE('15:00:00', 'HH24:MI:SS'), TO_DATE('17:00:00', 'HH24:MI:SS'), 20, 20)
SELECT * FROM dual;

/*INSERT MATRICULA*/

INSERT ALL
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (1, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 1, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (2, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 2, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (3, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 3, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (4, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 4, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (5, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 5, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (6, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 6, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (7, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 7, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (8, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 8, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (9, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 9, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (10, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 10, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (11, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 11, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (12, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 12, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (13, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 13, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (14, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 14, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (15, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 15, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (16, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 16, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (17, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 17, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (18, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 18, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (19, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 19, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (20, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 20, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (21, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 21, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (22, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 22, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (23, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 23, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (24, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 24, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (25, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 25, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (26, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 26, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (27, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 27, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (28, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 28, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (29, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 29, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (30, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 30, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (31, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 31, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (32, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 32, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (33, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 33, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (34, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 34, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (35, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 35, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (36, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 36, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (37, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 37, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (38, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 38, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (39, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 39, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (40, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 40, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (41, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 41, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (42, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 42, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (43, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 43, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (44, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 44, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (45, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 45, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (46, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 46, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (47, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 47, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (48, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 48, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (49, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 49, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (50, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 50, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (51, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 51, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (52, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 52, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (53, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 53, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (54, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 54, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (55, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 55, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (56, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 56, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (57, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 57, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (58, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 58, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (59, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 59, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (60, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 60, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (61, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 61, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (62, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 62, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (63, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 63, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (64, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 64, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (65, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 65, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (66, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 66, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (67, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 67, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (68, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 68, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (69, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 69, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (70, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 70, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (71, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 71, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (72, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 72, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (73, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 73, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (74, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 74, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (75, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 75, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (76, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 76, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (77, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 77, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (78, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 78, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (79, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 79, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (80, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 80, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (81, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 81, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (82, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 82, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (83, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 83, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (84, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 84, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (85, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 85, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (86, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 86, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (87, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 87, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (88, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 88, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (89, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 89, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (90, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 90, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (91, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 91, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (92, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 92, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (93, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 93, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (94, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 94, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (95, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 95, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (96, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 96, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (97, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 97, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (98, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 98, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (99, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 99, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (100, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 100, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (101, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 101, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (102, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 102, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (103, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 103, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (104, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 104, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (105, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 105, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (106, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 106, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (107, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 107, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (108, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 108, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (109, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 109, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (110, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 110, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (111, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 111, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (112, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 112, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (113, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 113, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (114, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 114, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (115, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 115, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (116, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 116, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (117, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 117, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (118, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 118, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (119, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 119, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (120, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 120, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (121, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 121, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (122, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 122, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (123, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 123, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (124, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 124, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (125, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 125, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (126, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 126, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (127, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 127, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (128, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 128, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (129, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 129, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (130, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 130, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (131, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 131, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (132, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 132, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (133, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 133, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (134, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 134, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (135, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 135, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (136, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 136, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (137, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 137, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (138, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 138, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (139, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 139, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (140, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 140, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (141, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 141, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (142, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 142, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (143, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 143, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (144, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 144, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (145, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 145, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (146, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 146, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (147, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 147, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (148, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 148, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (149, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 149, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (150, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 150, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (151, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 151, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (152, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 152, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (153, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 153, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (154, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 154, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (155, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 155, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (156, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 156, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (157, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 157, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (158, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 158, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (159, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 159, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (160, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 160, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (161, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 161, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (162, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 162, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (163, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 163, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (164, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 164, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (165, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 165, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (166, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 166, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (167, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 167, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (168, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 168, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (169, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 169, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (170, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 170, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (171, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 171, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (172, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 172, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (173, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 173, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (174, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 174, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (175, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 175, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (176, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 176, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (177, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 177, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (178, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 178, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (179, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 179, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (180, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 180, 20)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (181, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 181, 1)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (182, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 182, 2)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (183, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 183, 3)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (184, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 184, 4)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (185, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 185, 5)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (186, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 186, 6)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (187, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 187, 7)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (188, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 188, 8)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (189, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 189, 9)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (190, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 190, 10)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (191, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 191, 11)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (192, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 192, 12)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (193, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 193, 13)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (194, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 194, 14)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (195, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 195, 15)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (196, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 196, 16)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (197, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 197, 17)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (198, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 198, 18)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (199, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 199, 19)
  INTO Matricula (id_matricula, fechaMatricula, id_estudiante, id_horario) VALUES (200, TO_DATE('2024-08-16', 'YYYY-MM-DD'), 200, 20)
SELECT * FROM dual;


INSERT INTO Usuarios (id_usuario, nombre, apellido, email, contrasena, activo)
VALUES (1, 'admin', 'admin', 'admin@gmail.com', 'password123', 'Y');

INSERT INTO Usuarios (id_usuario, nombre, apellido, email, contrasena, activo)
VALUES (2, 'Alejandro', 'Denver', 'aledenro@gmail.com', '1234', 'Y');
commit;

select * from usuarios



