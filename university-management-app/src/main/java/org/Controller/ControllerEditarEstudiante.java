package org.Controller;

import org.Model.ModelCreateEntity;
import org.Model.ModelEditEntity;
import org.Model.ModelGetEntity;
import org.View.EditarEstudiante;
import org.View.ListarEstudiantes;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerEditarEstudiante implements MouseListener {

    private EditarEstudiante editarEstudiante;
    private String cedula = "";
    private String nombre = "";
    private String apellido = "";
    private String correo = "";
    private String num_telefono = "";

    private boolean estudianteValido = false;

    public ControllerEditarEstudiante(EditarEstudiante editarEstudiante) {
        this.editarEstudiante = editarEstudiante;
        this.editarEstudiante.getBtnGuardar().addMouseListener(this);
        this.editarEstudiante.getBtnVolver().addMouseListener(this);
        this.editarEstudiante.getBtnBuscar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.editarEstudiante.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.editarEstudiante.getBtnGuardar()){
            btnGuardarEstudianteClicked();
        }

        if (e.getSource() == this.editarEstudiante.getBtnBuscar()){
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
        this.editarEstudiante.setVisible(false);
        ListarEstudiantes listarEstudiantes = new ListarEstudiantes();
        ControllerListarEstudiantes controllerListarEstudiantes = new ControllerListarEstudiantes(listarEstudiantes);
        listarEstudiantes.setVisible(true);
    }

    private void btnGuardarEstudianteClicked() {
        getValues();

        boolean anyEmptyField = this.cedula.isEmpty() || this.nombre.isEmpty() || this.apellido.isEmpty() ||
                this.correo.isEmpty() || this.num_telefono.isEmpty();

        if (anyEmptyField) {
            JOptionPane.showMessageDialog(this.editarEstudiante, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ControllerFormatValidator controllerFormatValidator = new ControllerFormatValidator();
        if (!controllerFormatValidator.verifyFormatCedula(cedula)) {
            JOptionPane.showMessageDialog(this.editarEstudiante, "Por favor verifique el formato de la cédula.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (!controllerFormatValidator.verifyFormatCorreo(correo)) {
            JOptionPane.showMessageDialog(this.editarEstudiante, "Por favor verifique el formato del correo que contenga @ y .com o algún dominio valido.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (!controllerFormatValidator.verifyFormatNumTelefono(num_telefono)) {
            JOptionPane.showMessageDialog(this.editarEstudiante, "Por favor verifique el formato del número de teléfono, que contenga solo números y tenga un largo de 8 digitos.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (estudianteValido) {
            ModelEditEntity modelEditEntity = new ModelEditEntity();
            boolean creado = modelEditEntity.editEstudiante(nombre, apellido, correo, Integer.parseInt(num_telefono), cedula);

            if (creado) {
                JOptionPane.showMessageDialog(this.editarEstudiante, "Estudiante editado de manera satisgactoria.");
                setEmptyValues();
            } else {
                JOptionPane.showMessageDialog(this.editarEstudiante, "Error al editar el estudiante, contacte un administrador",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(this.editarEstudiante, "Por favor verifique la cédula del estudiante a editar.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnBuscarClicked(){
        getValues();
        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] estudiante = modelGetEntity.getEstudiante(cedula);

        if (estudiante == null) {
            JOptionPane.showMessageDialog(this.editarEstudiante, "El estudiante con la cédula " + cedula + " no existe.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            setFoundValues(estudiante);
            this.estudianteValido = true;
        }
    }

    private void getValues(){
        this.cedula = this.editarEstudiante.getTxtCedula().getText();
        this.nombre = this.editarEstudiante.getTxtNombre().getText();
        this.apellido = this.editarEstudiante.getTxtApellido().getText();
        this.correo = this.editarEstudiante.getTxtCorreo().getText();
        this.num_telefono = this.editarEstudiante.getTxtTelefono().getText();
    }

    private void setEmptyValues(){
        this.editarEstudiante.getTxtCedula().setText("");
        this.editarEstudiante.getTxtNombre().setText("");
        this.editarEstudiante.getTxtApellido().setText("");
        this.editarEstudiante.getTxtCorreo().setText("");
        this.editarEstudiante.getTxtTelefono().setText("");
        this.estudianteValido = false;
    }

    private void setFoundValues(Object[] estudiante){
        this.editarEstudiante.getTxtNombre().setText(estudiante[1].toString());
        this.editarEstudiante.getTxtApellido().setText(estudiante[2].toString());
        this.editarEstudiante.getTxtCorreo().setText(estudiante[3].toString());
        this.editarEstudiante.getTxtTelefono().setText(estudiante[4].toString());
    }
}
