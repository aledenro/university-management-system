package org.Controller;

import org.Model.ModelCreateEntity;
import org.Model.ModelGetEntity;
import org.View.AgregarEstudiante;
import org.View.ListarEstudiantes;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerAgregarEstudiante implements MouseListener {

    private AgregarEstudiante agregarEstudiante;
    private String cedula = "";
    private String nombre = "";
    private String apellido = "";
    private String correo = "";
    private String num_telefono = "";

    public ControllerAgregarEstudiante(AgregarEstudiante agregarEstudiante) {
        this.agregarEstudiante = agregarEstudiante;
        this.agregarEstudiante.getBtnAgregarEstudiante().addMouseListener(this);
        this.agregarEstudiante.getBtnVolver().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.agregarEstudiante.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.agregarEstudiante.getBtnAgregarEstudiante()){
            btnAgregarestudianteClicked();
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
        this.agregarEstudiante.setVisible(false);
        ListarEstudiantes listarEstudiantes = new ListarEstudiantes();
        ControllerListarEstudiantes controllerListarEstudiantes = new ControllerListarEstudiantes(listarEstudiantes);
        listarEstudiantes.setVisible(true);
    }

    private void btnAgregarestudianteClicked(){
        getValues();

        boolean anyEmptyField = this.cedula.isEmpty() || this.nombre.isEmpty() || this.apellido.isEmpty() ||
                this.correo.isEmpty() || this.num_telefono.isEmpty();

        if (anyEmptyField){
            JOptionPane.showMessageDialog(this.agregarEstudiante, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ControllerFormatValidator controllerFormatValidator = new ControllerFormatValidator();
        if(!controllerFormatValidator.verifyFormatCedula(cedula)){
            JOptionPane.showMessageDialog(this.agregarEstudiante, "Por favor verifique el formato de la cédula.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else if(!controllerFormatValidator.verifyFormatCorreo(correo)){
            JOptionPane.showMessageDialog(this.agregarEstudiante, "Por favor verifique el formato del correo que contenga @ y .com o algún dominio valido.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else if(!controllerFormatValidator.verifyFormatNumTelefono(num_telefono)){
            JOptionPane.showMessageDialog(this.agregarEstudiante, "Por favor verifique el formato del número de teléfono, que contenga solo números y tenga un largo de 8 digitos.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] estudiante = modelGetEntity.getEstudiante(cedula);

        if (estudiante != null){
            JOptionPane.showMessageDialog(this.agregarEstudiante, "El estudiante con la cédula " + cedula + " ya existe. El nombre es " +
                    estudiante[1] + " " + estudiante[2] + ".",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelCreateEntity modelCreateEntity = new ModelCreateEntity();
        boolean creado = modelCreateEntity.createEstudiante(nombre, apellido, correo, Integer.parseInt(num_telefono), cedula);

        if(creado){
            JOptionPane.showMessageDialog(this.agregarEstudiante, "Estudiante creado de manera satisfactoria.");
            setEmptyValues();
        }else{
            JOptionPane.showMessageDialog(this.agregarEstudiante, "Error al agregar el estudiante, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getValues(){
        this.cedula = this.agregarEstudiante.getTxtCedula().getText();
        this.nombre = this.agregarEstudiante.getTxtNombre().getText();
        this.apellido = this.agregarEstudiante.getTxtApellido().getText();
        this.correo = this.agregarEstudiante.getTxtCorreo().getText();
        this.num_telefono = this.agregarEstudiante.getTxtTelefono().getText();
    }

    private void setEmptyValues(){
        this.agregarEstudiante.getTxtCedula().setText("");
        this.agregarEstudiante.getTxtNombre().setText("");
        this.agregarEstudiante.getTxtApellido().setText("");
        this.agregarEstudiante.getTxtCorreo().setText("");
        this.agregarEstudiante.getTxtTelefono().setText("");
    }
}
