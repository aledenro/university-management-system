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







