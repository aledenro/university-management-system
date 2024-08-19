package org.Controller;

import org.Model.ModelEditEntity;
import org.Model.ModelGetEntity;
import org.View.EditarAsignatura;
import org.View.EditarHorario;
import org.View.ListarAsignaturas;
import org.View.ListarHorarios;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerEditHorario implements MouseListener, ItemListener {

    private EditarHorario editarHorario;
    private String idHorario = "";
    private String dia = "";
    private String horaInicio = "";
    private String horaFinalizacion = "";
    private String grupo = "";
    private String aula = "";

    public ControllerEditHorario(EditarHorario editarHorario) {
        this.editarHorario = editarHorario;
        this.editarHorario.getBtnEditar().addMouseListener(this);
        this.editarHorario.getBtnVolver().addMouseListener(this);
        this.editarHorario.getCboIdHorario().addItemListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.editarHorario.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.editarHorario.getBtnEditar()){
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
        if (e.getSource() == this.editarHorario.getCboIdHorario()){
            setFoundValues();
        }
    }

    private void btnVolverClicked(){
        this.editarHorario.setVisible(false);
        ListarHorarios listarHorarios = new ListarHorarios();
        ControllerListarHorarios controllerListarHorarios = new ControllerListarHorarios(listarHorarios);
        listarHorarios.setVisible(true);
    }

    private void btnEditarClicked(){
        getValues();

        ModelEditEntity modelEditEntity = new ModelEditEntity();
        boolean creado = modelEditEntity.editHorario(Integer.parseInt(idHorario), dia, horaInicio, horaFinalizacion, Integer.parseInt(grupo), Integer.parseInt(aula));

        if(creado){
            JOptionPane.showMessageDialog(this.editarHorario, "Horario editado de manera satisfactoria.");
            ControllerPopularDropdowns controllerPopularDropdowns = new ControllerPopularDropdowns();
        }else{
            JOptionPane.showMessageDialog(this.editarHorario, "Error al editar el horario, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void getValues(){
        this.idHorario = this.editarHorario.getCboIdHorario().getSelectedItem().toString();
        this.dia = this.editarHorario.getCboDia().getSelectedItem().toString();
        this.horaInicio = this.editarHorario.getCboHoraInicio().getSelectedItem().toString();
        this.horaFinalizacion = this.editarHorario.getCboHoraFinalizacion().getSelectedItem().toString();
        this.grupo = this.editarHorario.getCboGrupo().getSelectedItem().toString();
        this.aula = this.editarHorario.getCboNumAula().getSelectedItem().toString();
    }

    public void setFoundValues(){
        getValues();
        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] horario = modelGetEntity.getHorario(Integer.parseInt(idHorario));

        String dia = horario[1].toString();

        for(int i = 0; i < this.editarHorario.getCboDia().getItemCount(); i++){
            if (this.editarHorario.getCboDia().getItemAt(i).toString().contains(dia)){
                this.editarHorario.getCboDia().setSelectedIndex(i);
            }
        }

        String inicio = horario[2].toString();

        for(int i = 0; i < this.editarHorario.getCboHoraInicio().getItemCount(); i++){
            if (this.editarHorario.getCboHoraInicio().getItemAt(i).toString().contains(inicio)){
                this.editarHorario.getCboHoraInicio().setSelectedIndex(i);
            }
        }

        String termina = horario[3].toString();

        for(int i = 0; i < this.editarHorario.getCboHoraFinalizacion().getItemCount(); i++){
            if (this.editarHorario.getCboHoraFinalizacion().getItemAt(i).toString().contains(termina)){
                this.editarHorario.getCboHoraFinalizacion().setSelectedIndex(i);
            }
        }

        String grupo = horario[4].toString();

        for(int i = 0; i < this.editarHorario.getCboGrupo().getItemCount(); i++){
            if (this.editarHorario.getCboGrupo().getItemAt(i).toString().contains(grupo)){
                this.editarHorario.getCboGrupo().setSelectedIndex(i);
            }
        }

        String aula =  horario[5].toString();

        for(int j = 0; j < this.editarHorario.getCboNumAula().getItemCount(); j++){
            if (this.editarHorario.getCboNumAula().getItemAt(j).toString().contains(aula)){
                this.editarHorario.getCboNumAula().setSelectedIndex(j);
            }
        }
    }

}
