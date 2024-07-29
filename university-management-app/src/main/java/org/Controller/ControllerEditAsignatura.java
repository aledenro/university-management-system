package org.Controller;

import org.Model.ModelCreateEntity;
import org.Model.ModelEditEntity;
import org.Model.ModelGetEntity;
import org.View.EditarAsignatura;
import org.View.ListarAsignaturas;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerEditAsignatura implements MouseListener, ItemListener {

    private EditarAsignatura editarAsignatura;
    private String creditos = "";
    private String nombre = "";
    private String nombreDepartamento = "";
    private String nombreProfesor = "";

    private String asignaturaEditar = "";

    public ControllerEditAsignatura(EditarAsignatura editarAsignatura) {
        this.editarAsignatura = editarAsignatura;
        this.editarAsignatura.getBtnAgregar().addMouseListener(this);
        this.editarAsignatura.getBtnVolver().addMouseListener(this);
        this.editarAsignatura.getCboAsignaturaEditar().addItemListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.editarAsignatura.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.editarAsignatura.getBtnAgregar()){
            btnEditarClicked();
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == this.editarAsignatura.getCboAsignaturaEditar()){
            setFoundValues();
        }
    }

    private void btnVolverClicked(){
        this.editarAsignatura.setVisible(false);
        ListarAsignaturas listarAsignaturas = new ListarAsignaturas();
        ControllerListarAsignaturas controllerListarAsignaturas = new ControllerListarAsignaturas(listarAsignaturas);
        listarAsignaturas.setVisible(true);
    }

    private void btnEditarClicked(){
        getValues();

        boolean anyEmptyField = this.creditos.isEmpty() || this.nombre.isEmpty();

        if (anyEmptyField){
            JOptionPane.showMessageDialog(this.editarAsignatura, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ControllerFormatValidator controllerFormatValidator = new ControllerFormatValidator();
        if(!controllerFormatValidator.verifyOnlyNumbers(creditos)) {
            JOptionPane.showMessageDialog(this.editarAsignatura, "Por favor verifique que el campo de cresitos solo posea numeros.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id_profesor = nombreProfesor.charAt(0) + "";

        ModelEditEntity modelEditEntity = new ModelEditEntity();
        boolean creado = modelEditEntity.editAsignatura(nombre, Integer.parseInt(creditos), nombreDepartamento, Integer.parseInt(id_profesor));

        if(creado){
            JOptionPane.showMessageDialog(this.editarAsignatura, "Asignatura editada de manera satisfactoria.");
            ControllerPopularDropdowns controllerPopularDropdowns = new ControllerPopularDropdowns();
            controllerPopularDropdowns.llenarDropdownAsignaturas(this.editarAsignatura.getCboAsignaturaEditar());
            setFoundValues();
        }else{
            JOptionPane.showMessageDialog(this.editarAsignatura, "Error al editar la asigatura, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void getValues(){
        this.creditos = this.editarAsignatura.getTxtCreditos().getText();
        this.nombre = this.editarAsignatura.getTxtNombre().getText();
        this.nombreDepartamento = this.editarAsignatura.getCboDepartamento().getSelectedItem().toString();
        this.nombreProfesor = this.editarAsignatura.getCboProfesor().getSelectedItem().toString();
        this.asignaturaEditar = this.editarAsignatura.getCboAsignaturaEditar().getSelectedItem().toString();
    }

    public void setFoundValues(){
        getValues();
        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] asignatura = modelGetEntity.getAsignatura(asignaturaEditar);
        this.editarAsignatura.getTxtCreditos().setText(asignatura[1].toString());
        this.editarAsignatura.getTxtNombre().setText(asignatura[0].toString());
        String departamento = asignatura[2].toString();

        for(int i = 0; i < this.editarAsignatura.getCboDepartamento().getItemCount(); i++){
            if (this.editarAsignatura.getCboDepartamento().getItemAt(i).toString().contains(departamento)){
                this.editarAsignatura.getCboDepartamento().setSelectedIndex(i);
            }
        }

        String profesor =  asignatura[3].toString();

        for(int j = 0; j < this.editarAsignatura.getCboProfesor().getItemCount(); j++){
            if (this.editarAsignatura.getCboProfesor().getItemAt(j).toString().contains(profesor)){
                this.editarAsignatura.getCboProfesor().setSelectedIndex(j);
            }
        }
    }

}
