package org.Controller;

import org.Model.ModelEditEntity;
import org.Model.ModelGetEntity;
import org.View.EditarProfesor;
import org.View.ListarProfesores;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerEditarProfesor implements MouseListener {

    private EditarProfesor editarProfesor;
    private String cedula = "";
    private String nombre = "";
    private String apellido = "";
    private String correo = "";
    private String num_telefono = "";

    private boolean profesorValido = false;

    public ControllerEditarProfesor(EditarProfesor editarProfesor) {
        this.editarProfesor = editarProfesor;
        this.editarProfesor.getBtnGuardar().addMouseListener(this);
        this.editarProfesor.getBtnVolver().addMouseListener(this);
        this.editarProfesor.getBtnBuscar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.editarProfesor.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.editarProfesor.getBtnGuardar()){
            btnGuardarProfesorClicked();
        }

        if (e.getSource() == this.editarProfesor.getBtnBuscar()){
            btnBuscarClicked();
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
        this.editarProfesor.setVisible(false);
        ListarProfesores listarProfesores = new ListarProfesores();
        ControllerListarProfesores controllerListarProfesores = new ControllerListarProfesores(listarProfesores);
        listarProfesores.setVisible(true);
    }

    private void btnGuardarProfesorClicked() {
        getValues();

        boolean anyEmptyField = this.cedula.isEmpty() || this.nombre.isEmpty() || this.apellido.isEmpty() ||
                this.correo.isEmpty() || this.num_telefono.isEmpty();

        if (anyEmptyField) {
            JOptionPane.showMessageDialog(this.editarProfesor, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ControllerFormatValidator controllerFormatValidator = new ControllerFormatValidator();
        if (!controllerFormatValidator.verifyFormatCedula(cedula)) {
            JOptionPane.showMessageDialog(this.editarProfesor, "Por favor verifique el formato de la cédula.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (!controllerFormatValidator.verifyFormatCorreo(correo)) {
            JOptionPane.showMessageDialog(this.editarProfesor, "Por favor verifique el formato del correo que contenga @ y .com o algún dominio valido.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (!controllerFormatValidator.verifyFormatNumTelefono(num_telefono)) {
            JOptionPane.showMessageDialog(this.editarProfesor, "Por favor verifique el formato del número de teléfono, que contenga solo números y tenga un largo de 8 digitos.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (profesorValido) {
            ModelEditEntity modelEditEntity = new ModelEditEntity();
            boolean creado = modelEditEntity.editProfesor(nombre, apellido, correo, Integer.parseInt(num_telefono), cedula);

            if (creado) {
                JOptionPane.showMessageDialog(this.editarProfesor, "Profesor editado de manera satisfactoria.");
                setEmptyValues();
            } else {
                JOptionPane.showMessageDialog(this.editarProfesor, "Error al editar el profesor, contacte un administrador",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(this.editarProfesor, "Por favor verifique la cédula del profesor a editar.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnBuscarClicked(){
        getValues();
        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] profesor = modelGetEntity.getProfesor(cedula);

        if (profesor == null) {
            JOptionPane.showMessageDialog(this.editarProfesor, "El profesor con la cédula " + cedula + " no existe.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            setFoundValues(profesor);
            this.profesorValido = true;
        }
    }

    private void getValues(){
        this.cedula = this.editarProfesor.getTxtCedula().getText();
        this.nombre = this.editarProfesor.getTxtNombre().getText();
        this.apellido = this.editarProfesor.getTxtApellido().getText();
        this.correo = this.editarProfesor.getTxtCorreo().getText();
        this.num_telefono = this.editarProfesor.getTxtTelefono().getText();
    }

    private void setEmptyValues(){
        this.editarProfesor.getTxtCedula().setText("");
        this.editarProfesor.getTxtNombre().setText("");
        this.editarProfesor.getTxtApellido().setText("");
        this.editarProfesor.getTxtCorreo().setText("");
        this.editarProfesor.getTxtTelefono().setText("");
        this.profesorValido = false;
    }

    private void setFoundValues(Object[] profesor){
        this.editarProfesor.getTxtNombre().setText(profesor[1].toString());
        this.editarProfesor.getTxtApellido().setText(profesor[2].toString());
        this.editarProfesor.getTxtCorreo().setText(profesor[3].toString());
        this.editarProfesor.getTxtTelefono().setText(profesor[4].toString());
    }
}
