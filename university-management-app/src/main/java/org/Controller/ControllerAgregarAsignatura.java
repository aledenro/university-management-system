package org.Controller;

import org.Model.ModelCreateEntity;
import org.Model.ModelGetEntity;
import org.View.AgregarAsignatura;
import org.View.AgregarEstudiante;
import org.View.ListarAsignaturas;
import org.View.ListarEstudiantes;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerAgregarAsignatura implements MouseListener {

    private AgregarAsignatura agregarAsignatura;
    private String creditos = "";
    private String nombre = "";
    private String nombreDepartamento = "";
    private String nombreProfesor = "";

    public ControllerAgregarAsignatura(AgregarAsignatura agregarAsignatura) {
        this.agregarAsignatura = agregarAsignatura;
        this.agregarAsignatura.getBtnAgregar().addMouseListener(this);
        this.agregarAsignatura.getBtnVolver().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.agregarAsignatura.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.agregarAsignatura.getBtnAgregar()){
            btnAgregarClicked();
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
        this.agregarAsignatura.setVisible(false);
        ListarAsignaturas listarAsignaturas = new ListarAsignaturas();
        ControllerListarAsignaturas controllerListarAsignaturas = new ControllerListarAsignaturas(listarAsignaturas);
        listarAsignaturas.setVisible(true);
    }

    private void btnAgregarClicked(){
        getValues();

        boolean anyEmptyField = this.creditos.isEmpty() || this.nombre.isEmpty();

        if (anyEmptyField){
            JOptionPane.showMessageDialog(this.agregarAsignatura, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ControllerFormatValidator controllerFormatValidator = new ControllerFormatValidator();
        if(!controllerFormatValidator.verifyOnlyNumbers(creditos)) {
            JOptionPane.showMessageDialog(this.agregarAsignatura, "Por favor verifique que el campo de cresitos solo posea numeros.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] asignatura = modelGetEntity.getAsignatura(nombre);

        if (asignatura != null){
            JOptionPane.showMessageDialog(this.agregarAsignatura, "La asignatura con el nombre " + nombre + " ya existe.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id_profesor = nombreProfesor.charAt(0) + "";

        ModelCreateEntity modelCreateEntity = new ModelCreateEntity();
        boolean creado = modelCreateEntity.createAsignatura(nombre, Integer.parseInt(creditos), nombreDepartamento, Integer.parseInt(id_profesor));

        if(creado){
            JOptionPane.showMessageDialog(this.agregarAsignatura, "Asignatura creada de manera satisfactoria.");
            setEmptyValues();
        }else{
            JOptionPane.showMessageDialog(this.agregarAsignatura, "Error al agregar la asignatura, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void getValues(){
        this.creditos = this.agregarAsignatura.getTxtCreditos().getText();
        this.nombre = this.agregarAsignatura.getTxtNombre().getText();
        this.nombreDepartamento = this.agregarAsignatura.getCboDepartamento().getSelectedItem().toString();
        this.nombreProfesor = this.agregarAsignatura.getCboProfesor().getSelectedItem().toString();
    }

    private void setEmptyValues(){
        this.agregarAsignatura.getTxtCreditos().setText("");
        this.agregarAsignatura.getTxtNombre().setText("");
    }

}
