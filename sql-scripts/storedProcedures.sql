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