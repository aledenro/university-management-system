package org.Controller;

import org.Model.ModelCreateEntity;
import org.Model.ModelGetEntity;
import org.View.AgregarProfesor;
import org.View.ListarProfesores;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerAgregarProfesor implements MouseListener {

    private AgregarProfesor agregarProfesor;
    private String cedula = "";
    private String nombre = "";
    private String apellido = "";
    private String correo = "";
    private String num_telefono = "";

    public ControllerAgregarProfesor(AgregarProfesor agregarProfesor) {
        this.agregarProfesor = agregarProfesor;
        this.agregarProfesor.getBtnAgregarProfesor().addMouseListener(this);
        this.agregarProfesor.getBtnVolver().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.agregarProfesor.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.agregarProfesor.getBtnAgregarProfesor()){
            btnAgregarProfesorClicked();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void btnVolverClicked(){
        this.agregarProfesor.setVisible(false);
        ListarProfesores listarProfesores = new ListarProfesores();
        ControllerListarProfesores controllerListarProfesores = new ControllerListarProfesores(listarProfesores);
        listarProfesores.setVisible(true);
    }

    private void btnAgregarProfesorClicked(){
        getValues();

        boolean anyEmptyField = this.cedula.isEmpty() || this.nombre.isEmpty() || this.apellido.isEmpty() ||
                this.correo.isEmpty() || this.num_telefono.isEmpty();

        if (anyEmptyField){
            JOptionPane.showMessageDialog(this.agregarProfesor, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ControllerFormatValidator controllerFormatValidator = new ControllerFormatValidator();
        if(!controllerFormatValidator.verifyFormatCedula(cedula)){
            JOptionPane.showMessageDialog(this.agregarProfesor, "Por favor verifique el formato de la cédula.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else if(!controllerFormatValidator.verifyFormatCorreo(correo)){
            JOptionPane.showMessageDialog(this.agregarProfesor, "Por favor verifique el formato del correo que contenga @ y .com o algún dominio valido.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else if(!controllerFormatValidator.verifyFormatNumTelefono(num_telefono)){
            JOptionPane.showMessageDialog(this.agregarProfesor, "Por favor verifique el formato del número de teléfono, que contenga solo números y tenga un largo de 8 digitos.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] profesor = modelGetEntity.getProfesor(cedula);

        if (profesor != null){
            JOptionPane.showMessageDialog(this.agregarProfesor, "El profesor con la cédula " + cedula + " ya existe. El nombre es " +
                            profesor[1] + " " + profesor[2] + ".",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelCreateEntity modelCreateEntity = new ModelCreateEntity();
        boolean creado = modelCreateEntity.createProfesor(nombre, apellido, correo, Integer.parseInt(num_telefono), cedula);

        if(creado){
            JOptionPane.showMessageDialog(this.agregarProfesor, "Profesor creado de manera satisfactoria.");
            setEmptyValues();
        }else{
            JOptionPane.showMessageDialog(this.agregarProfesor, "Error al agregar el profesor, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getValues(){
        this.cedula = this.agregarProfesor.getTxtCedula().getText();
        this.nombre = this.agregarProfesor.getTxtNombre().getText();
        this.apellido = this.agregarProfesor.getTxtApellido().getText();
        this.correo = this.agregarProfesor.getTxtCorreo().getText();
        this.num_telefono = this.agregarProfesor.getTxtTelefono().getText();
    }

    private void setEmptyValues(){
        this.agregarProfesor.getTxtCedula().setText("");
        this.agregarProfesor.getTxtNombre().setText("");
        this.agregarProfesor.getTxtApellido().setText("");
        this.agregarProfesor.getTxtCorreo().setText("");
        this.agregarProfesor.getTxtTelefono().setText("");
    }
}
