// sp login 
CREATE OR REPLACE PROCEDURE login(correo IN VARCHAR2, cl OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT * FROM Usuarios WHERE email = correo;
END;

// sp get estudiante por num cedula 
CREATE OR REPLACE PROCEDURE getEstudiante(vcedula IN VARCHAR2, cl OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT * FROM Estudiante WHERE Estudiante.cedula = vcedula;
END;

//sp crear estudiante
CREATE OR REPLACE PROCEDURE createEstudiante(
    vnombre IN VARCHAR2,
    vapellido IN VARCHAR2,
    vcorreo IN VARCHAR2,
    vnumero_tel IN INT,
    vcedula IN VARCHAR2
    )
AS
    vid INT;
BEGIN
    SELECT MAX(id_estudiante) + 1 INTO vid
    FROM Estudiante;
    
    INSERT INTO Estudiante(id_estudiante, nombre, apellido, email, num_celular, cedula)
    VALUES (vid, vnombre, vapellido, vcorreo, vnumero_tel, vcedula);
END;


//sp edit estudiante
CREATE OR REPLACE PROCEDURE editEstudiante(
    vnombre IN VARCHAR2,
    vapellido IN VARCHAR2,
    vcorreo IN VARCHAR2,
    vnumero_tel IN INT,
    vcedula IN VARCHAR2
    )
AS
BEGIN
    UPDATE Estudiante
    SET nombre = vnombre, apellido = vapellido, email = vcorreo, num_celular = vnumero_tel
    WHERE cedula = vcedula;
END;

--sp get estudiantes
create or replace PROCEDURE getEstudiantes(cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT cedula, nombre, apellido, email, num_celular FROM Estudiante;
END;

--sp get all profesores
create or replace PROCEDURE getProfesores(cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT cedula, nombre, apellido, email, num_celular FROM Profesores;
END;

--sp get profesor by cedula
CREATE OR REPLACE PROCEDURE getProfesor(vcedula IN VARCHAR2, cl OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT * FROM Profesores WHERE Profesores.cedula = vcedula;
END;

--create new profesor
CREATE OR REPLACE PROCEDURE createProfesor(
    vnombre IN VARCHAR2,
    vapellido IN VARCHAR2,
    vcorreo IN VARCHAR2,
    vnumero_tel IN INT,
    vcedula IN VARCHAR2
    )
AS
    vid INT;
BEGIN
    SELECT MAX(id_profesor) + 1 INTO vid
    FROM Profesores;
    
    INSERT INTO Profesores(id_profesor, nombre, apellido, email, num_celular, cedula)
    VALUES (vid, vnombre, vapellido, vcorreo, vnumero_tel, vcedula);
END;


--edit profesor 
CREATE OR REPLACE PROCEDURE editProfesor(
    vnombre IN VARCHAR2,
    vapellido IN VARCHAR2,
    vcorreo IN VARCHAR2,
    vnumero_tel IN INT,
    vcedula IN VARCHAR2
    )
AS
BEGIN
    UPDATE Profesores
    SET nombre = vnombre, apellido = vapellido, email = vcorreo, num_celular = vnumero_tel
    WHERE cedula = vcedula;
END;

--sp get all departamentos
create or replace PROCEDURE getDepartamentos(cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT nombre, locacion FROM Departamento;
END;

--sp get profesor by nombre
CREATE OR REPLACE PROCEDURE getDepartamento(vnombre IN VARCHAR2, cl OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT * FROM Departamento WHERE Departamento.nombre = vnombre;
END;

--create new departamento
CREATE OR REPLACE PROCEDURE createDepartamento(
    vnombre IN VARCHAR2,
    vubicacion IN VARCHAR2
    )
AS
    vid INT;
BEGIN
    SELECT MAX(id_departamento) + 1 INTO vid
    FROM Departamento;
    
    INSERT INTO Departamento(id_departamento, nombre, locacion)
    VALUES (vid, vnombre, vubicacion);
END;

--edit departamento 
CREATE OR REPLACE PROCEDURE editDepartamento(
    vnombre IN VARCHAR2,
    vubicacion IN VARCHAR2,
    vid IN INT
    )
AS
BEGIN
    UPDATE Departamento
    SET nombre = vnombre, locacion = vubicacion
    WHERE id_departamento = vid;
END;

--sp get all aulas
create or replace PROCEDURE getAulas(cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT * FROM Aula;
END;

--create new aula
CREATE OR REPLACE PROCEDURE getAula(
    vnum_aula IN INT,
    cl OUT SYS_REFCURSOR
    )
AS
BEGIN
    OPEN cl FOR SELECT *  FROM Aula WHERE id_aula = vnum_aula;
END;

--create new aula
CREATE OR REPLACE PROCEDURE createAula(
    vnum_aula IN INT,
    vcapacidad IN INT
    )
AS

BEGIN
    INSERT INTO Aula(id_aula, capacidad)
    VALUES (vnum_aula, vcapacidad);
END;

--edit aula 
CREATE OR REPLACE PROCEDURE editAula(
    vid IN INT,
    vcapacidad IN INT
    )
AS
BEGIN
    UPDATE Aula
    SET capacidad = vcapacidad
    WHERE id_aula = vid;
END;

--sp get all asignaturas
create or replace PROCEDURE getAsignaturas(cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR 
    SELECT a.id_asignatura as id_asignatura, a.nombre as nombre_asignatura, a.creditos as creditos, d.nombre as nombre_departamento, p.nombre || ' ' || p.apellido as nombre_profesor
    FROM Asignatura a
    JOIN Departamento d ON a.id_departamento = d.id_departamento
    JOIN Profesores p ON a.id_profesor = p.id_profesor;
END;

-- get asignatura por nombre
CREATE OR REPLACE PROCEDURE getAsignatura(vnombre IN VARCHAR2, cl OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR SELECT * FROM Asignatura WHERE Asignatura.nombre = vnombre;
END;

// create asignatura
create or replace PROCEDURE createAsignatura(
    vnombre IN VARCHAR2,
    vcreditos IN INT,
    vnombreDept IN VARCHAR2,
    vid_profesor IN INT
    )
AS
    vid INT;
    vid_dept INT;
BEGIN
    SELECT MAX(id_asignatura) + 1 INTO vid
    FROM Asignatura;

    SELECT id_departamento INTO vid_dept
    FROM Departamento
    WHERE nombre = vnombreDept;

    INSERT INTO Asignatura(id_asignatura, nombre, creditos, id_departamento, id_profesor)
    VALUES (vid, vnombre, vcreditos, vid_dept, vid_profesor);
END;

// edit asignatura
create or replace PROCEDURE editAsignatura(
    vnombre IN VARCHAR2,
    vcreditos IN INT,
    vnombreDept IN VARCHAR2,
    vid_profesor IN INT
    )
AS
    vid INT;
    vid_dept INT;
BEGIN
    SELECT id_asignatura INTO vid
    FROM Asignatura
    WHERE nombre = vnombre;

    SELECT id_departamento INTO vid_dept
    FROM Departamento
    WHERE nombre = vnombreDept;

    UPDATE Asignatura
    SET nombre =  vnombre, creditos = vcreditos, id_departamento = vid_dept, id_profesor = vid_profesor
    WHERE id_asignatura = vid;
END;

//get all grupos
create or replace PROCEDURE getGrupos(cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR 
    SELECT g.id_grupo as id_grupo, num_estudiantes, a.nombre as nombre_asignatura, p.nombre || ' ' || p.apellido as nombre_profesor
    FROM Grupos g
    JOIN Asignatura a ON g.id_asignatura = a.id_asignatura
    JOIN Profesores p ON g.id_profesor = p.id_profesor;
END;

//get grupo
create or replace PROCEDURE getGrupo(vid IN INT,cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR 
    SELECT g.id_grupo as id_grupo, num_estudiantes, a.nombre as nombre_asignatura, p.nombre || ' ' || p.apellido as nombre_profesor
    FROM Grupos g
    JOIN Asignatura a ON g.id_asignatura = a.id_asignatura
    JOIN Profesores p ON g.id_profesor = p.id_profesor
    WHERE g.id_grupo = vid;
END;

//create grupo
create or replace PROCEDURE createGrupo(
    vnombreAsignatura IN VARCHAR2,
    vid_profesor IN INT
    )
AS
    vid INT;
    vid_asig INT;
BEGIN
    SELECT MAX(id_grupo) + 1 INTO vid
    FROM Grupos;

    SELECT id_asignatura INTO vid_asig
    FROM Asignatura
    WHERE nombre = vnombreAsignatura;

    INSERT INTO Grupos (id_grupo, num_estudiantes, id_asignatura, id_profesor)
    VALUES (vid, 0, vid_asig, vid_profesor);
END;

//update grupo
create or replace PROCEDURE udpateGrupo(
    vid IN INT,
    vnombreAsignatura IN VARCHAR2,
    vid_profesor IN INT
    )
AS
    vid_asig INT;
BEGIN
    SELECT id_asignatura INTO vid_asig
    FROM Asignatura
    WHERE nombre = vnombreAsignatura;

    UPDATE Grupos 
    SET id_asignatura = vid_asig, id_profesor = vid_profesor
    WHERE id_grupo = vid;
END;

create or replace PROCEDURE getHorarios(cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR 
    SELECT h.id_horario as id_horario, dia, TO_CHAR(horaInicio, 'HH24:MI') horaInicio, TO_CHAR(horaFinaliza, 'HH24:MI') horaFinaliza, id_aula as num_aula,
    a.nombre as nombre_asignatura, p.nombre || ' ' || p.apellido as nombre_profesor
    FROM Horarios h
    JOIN Grupos g ON h.id_grupo = g.id_grupo
    JOIN Asignatura a ON g.id_asignatura = a.id_asignatura
    JOIN Profesores p ON g.id_profesor = p.id_profesor;
END;

--var cur refcursor;
--call getHorarios(:cur);
--print cur

create or replace PROCEDURE createHorario(
    vdia IN VARCHAR2,
    vinicio IN VARCHAR2,
    vfinal IN VARCHAR2,
    vid_grupo IN INT,
    vid_aula IN INT
    )
AS
    vid INT;
BEGIN
    SELECT MAX(id_horario) + 1 INTO vid
    FROM Horarios;

    INSERT INTO Horarios (id_horario, dia, horaInicio, horaFinaliza, id_grupo, id_aula)
    VALUES (vid, vdia, TO_DATE(vinicio, 'HH24:MI'), TO_DATE(vfinal, 'HH24:MI'), vid_grupo, vid_aula);
END;

create or replace PROCEDURE getHorario(vid_horario IN INT, cl IN OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cl FOR
    SELECT h.id_horario as id_horario, dia, TO_CHAR(horaInicio, 'HH24:MI') horaInicio, TO_CHAR(horaFinaliza, 'HH24:MI') horaFinaliza, id_aula as num_aula, h.id_grupo as id_grupo
    FROM Horarios h
    JOIN Grupos g ON h.id_grupo = g.id_grupo
    JOIN Asignatura a ON g.id_asignatura = a.id_asignatura
    JOIN Profesores p ON g.id_profesor = p.id_profesor
    WHERE id_horario = vid_horario;
END;

create or replace PROCEDURE udpateHorario(
    vid IN INT,
    vdia IN VARCHAR2,
    vhora_inicio IN VARCHAR2,
    vhora_fin IN VARCHAR2,
    vgrupo IN INT,
    vaula IN INT
    )
AS
    vid_asig INT;
BEGIN
    UPDATE Horarios 
    SET dia = vdia, horaInicio = TO_DATE(vhora_inicio, 'HH24:MI'), horaFinaliza = TO_DATE(vhora_fin, 'HH24:MI'), id_grupo = vgrupo, id_aula = vaula
    WHERE id_horario = vid;
END;

/*
CREATE TABLE Horarios (
    id_horario INT NOT NULL,
    dia VARCHAR(20),
    horaInicio date,
    horaFinaliza date,
    id_grupo INT,
    id_aula INT,
    PRIMARY KEY (id_horario)
);

CREATE TABLE Grupos (
    id_grupo INT NOT NULL,
    num_estudiantes int,
    id_asignatura INT,
    id_profesor INT,
    PRIMARY KEY (id_grupo)
);

CREATE TABLE Asignatura (
    id_asignatura INT NOT NULL,
    nombre varchar(50),
    creditos int,
    id_departamento INT,
    id_profesor INT,
    PRIMARY KEY (id_asignatura)
);

CREATE TABLE Profesores (
    id_profesor INT NOT NULL,
    nombre varchar(50),
    apellido varchar(50),
    email VARCHAR(50),
    num_celular int,
    PRIMARY KEY (id_profesor)
);
*/
