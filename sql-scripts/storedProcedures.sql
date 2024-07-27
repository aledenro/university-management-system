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

