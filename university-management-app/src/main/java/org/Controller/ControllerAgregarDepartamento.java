package org.Controller;

import org.Model.ModelCreateEntity;
import org.Model.ModelGetEntity;
import org.View.AgregarDepartamento;
import org.View.ListarDepartamentos;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerAgregarDepartamento implements MouseListener {

    private AgregarDepartamento agregarDepartamento;
    private String nombre = "";
    private String ubicacion = "";


    public ControllerAgregarDepartamento(AgregarDepartamento agregarDepartamento) {
        this.agregarDepartamento = agregarDepartamento;
        this.agregarDepartamento.getBtnAgregar().addMouseListener(this);
        this.agregarDepartamento.getBtnVolver().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.agregarDepartamento.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.agregarDepartamento.getBtnAgregar()){
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
        this.agregarDepartamento.setVisible(false);
        ListarDepartamentos listarDepartamentos = new ListarDepartamentos();
        ControllerListarDepartamentos controllerListarDepartamentos = new ControllerListarDepartamentos(listarDepartamentos);
        listarDepartamentos.setVisible(true);
    }

    private void btnAgregarClicked(){
        getValues();

        boolean anyEmptyField = this.nombre.isEmpty() || this.ubicacion.isEmpty();

        if (anyEmptyField){
            JOptionPane.showMessageDialog(this.agregarDepartamento, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] departamento = modelGetEntity.getDepartamento(nombre);

        if (departamento != null){
            JOptionPane.showMessageDialog(this.agregarDepartamento, "El departamento ya existe.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelCreateEntity modelCreateEntity = new ModelCreateEntity();
        boolean creado = modelCreateEntity.createDepartamento(nombre, ubicacion);

        if(creado){
            JOptionPane.showMessageDialog(this.agregarDepartamento, "Departamento creado de manera satisfactoria.");
            setEmptyValues();
        }else{
            JOptionPane.showMessageDialog(this.agregarDepartamento, "Error al agregar el estudiante, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getValues(){
        this.nombre = this.agregarDepartamento.getTxtNombre().getText();
        this.ubicacion = this.agregarDepartamento.getTxtUbicacion().getText();
    }

    private void setEmptyValues(){
        this.agregarDepartamento.getTxtNombre().setText("");
        this.agregarDepartamento.getTxtUbicacion().setText("");
    }
}
