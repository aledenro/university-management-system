package org.Controller;

import org.Model.ModelEditEntity;
import org.Model.ModelGetEntity;
import org.View.EditarAsignatura;
import org.View.EditarGrupo;
import org.View.ListarAsignaturas;
import org.View.ListarGrupos;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerEditarGrupo implements MouseListener, ItemListener {

    private EditarGrupo editarGrupo;
    private String nombreAsignatura = "";
    private String nombreProfesor = "";

    private String numGrupo = "";

    public ControllerEditarGrupo(EditarGrupo editarGrupo) {
        this.editarGrupo = editarGrupo;
        this.editarGrupo.getBtnEditar().addMouseListener(this);
        this.editarGrupo.getBtnVolver().addMouseListener(this);
        this.editarGrupo.getCboNumGrupo().addItemListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.editarGrupo.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.editarGrupo.getBtnEditar()){
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
        if (e.getSource() == this.editarGrupo.getCboNumGrupo()){
            setFoundValues();
        }
    }

    private void btnVolverClicked(){
        this.editarGrupo.setVisible(false);
        ListarGrupos listarGrupos = new ListarGrupos();
        ControllerListarGrupos controllerListarGrupos = new ControllerListarGrupos(listarGrupos);
        listarGrupos.setVisible(true);
    }

    private void btnEditarClicked(){
        getValues();

        String id_profesor = nombreProfesor.charAt(0) + "";

        ModelEditEntity modelEditEntity = new ModelEditEntity();
        boolean creado = modelEditEntity.editGrupo(Integer.parseInt(numGrupo), nombreAsignatura, Integer.parseInt(id_profesor));

        if(creado){
            JOptionPane.showMessageDialog(this.editarGrupo, "Grupo editado de manera satisfactoria.");
            ControllerPopularDropdowns controllerPopularDropdowns = new ControllerPopularDropdowns();
        }else{
            JOptionPane.showMessageDialog(this.editarGrupo, "Error al editar el grupo, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void getValues(){
        this.numGrupo = this.editarGrupo.getCboNumGrupo().getSelectedItem().toString();
        this.nombreProfesor = this.editarGrupo.getCboProfesor().getSelectedItem().toString();
        this.nombreAsignatura = this.editarGrupo.getCboAsignatura().getSelectedItem().toString();
    }

    public void setFoundValues(){
        getValues();
        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] grupo = modelGetEntity.getGrupo(Integer.parseInt(numGrupo));
        String asignatura = grupo[2].toString();

        for(int i = 0; i < this.editarGrupo.getCboAsignatura().getItemCount(); i++){
            if (this.editarGrupo.getCboAsignatura().getItemAt(i).toString().contains(asignatura)){
                this.editarGrupo.getCboAsignatura().setSelectedIndex(i);
            }
        }

        String profesor =  grupo[3].toString();

        for(int j = 0; j < this.editarGrupo.getCboProfesor().getItemCount(); j++){
            if (this.editarGrupo.getCboProfesor().getItemAt(j).toString().contains(profesor)){
                this.editarGrupo.getCboProfesor().setSelectedIndex(j);
            }
        }
    }

}
