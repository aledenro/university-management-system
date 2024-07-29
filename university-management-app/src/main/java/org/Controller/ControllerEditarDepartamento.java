package org.Controller;

import org.Model.ModelEditEntity;
import org.Model.ModelGetEntity;
import org.View.EditarDepartamento;
import org.View.ListarDepartamentos;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerEditarDepartamento implements MouseListener, ItemListener {

    private EditarDepartamento editarDepartamento;
    private String ubicacion = "";
    private String nombre = "";
    private String departamento = "";

    private int idDepartamento = 0;

    public ControllerEditarDepartamento(EditarDepartamento editarDepartamento) {
        this.editarDepartamento = editarDepartamento;
        this.editarDepartamento.getBtnVolver().addMouseListener(this);
        this.editarDepartamento.getBtnGuardar().addMouseListener(this);
        this.editarDepartamento.getCboDepartamento().addItemListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.editarDepartamento.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.editarDepartamento.getBtnGuardar()){
            btnGuardarClicked();
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
        if(e.getSource() == this.editarDepartamento.getCboDepartamento()){
            setFoundValues();
        }
    }

    private void btnVolverClicked(){
        this.editarDepartamento.setVisible(false);
        ListarDepartamentos listarDepartamentos = new ListarDepartamentos();
        ControllerListarDepartamentos controllerListarDepartamentos = new ControllerListarDepartamentos(listarDepartamentos);
        listarDepartamentos.setVisible(true);
    }

    private void btnGuardarClicked() {
        getValues();

        boolean anyEmptyField = this.nombre.isEmpty() || this.ubicacion.isEmpty();

        if (anyEmptyField) {
            JOptionPane.showMessageDialog(this.editarDepartamento, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
            ModelEditEntity modelEditEntity = new ModelEditEntity();
            boolean creado = modelEditEntity.editDepartamento(nombre, ubicacion, idDepartamento);

            if (creado) {
                JOptionPane.showMessageDialog(this.editarDepartamento, "Departamento editado de manera satisgactoria.");
                ControllerPopularDropdowns controllerPopularDropdowns = new ControllerPopularDropdowns();
                controllerPopularDropdowns.llenarDropdownDepartamentos(this.editarDepartamento.getCboDepartamento());
                setFoundValues();
            } else {
                JOptionPane.showMessageDialog(this.editarDepartamento, "Error al editar el departamento, contacte un administrador",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    private void getValues(){
        this.nombre = this.editarDepartamento.getTxtNombre().getText();
        this.ubicacion = this.editarDepartamento.getTxtUbicacion().getText();
        this.departamento = this.editarDepartamento.getCboDepartamento().getSelectedItem().toString();
    }

    private void setEmptyValues(){
        this.editarDepartamento.getTxtNombre().setText("");
        this.editarDepartamento.getTxtUbicacion().setText("");
    }

    public void setFoundValues(){
        getValues();
        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] departamento = modelGetEntity.getDepartamento(this.departamento);
        this.editarDepartamento.getTxtNombre().setText(departamento[0].toString());
        this.editarDepartamento.getTxtUbicacion().setText(departamento[1].toString());
        this.idDepartamento = Integer.parseInt(departamento[2].toString());
    }
}
