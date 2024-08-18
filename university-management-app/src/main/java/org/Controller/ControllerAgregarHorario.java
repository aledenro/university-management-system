package org.Controller;

import org.Model.ModelCreateEntity;
import org.View.AgregarGrupo;
import org.View.AgregarHorario;
import org.View.ListarGrupos;
import org.View.ListarHorarios;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerAgregarHorario implements MouseListener {

    private AgregarHorario agregarHorario;
    private String dia = "";
    private String horaInicio = "";
    private String horaFinalizacion = "";
    private String grupo = "";
    private String aula = "";

    public ControllerAgregarHorario(AgregarHorario agregarHorario) {
        this.agregarHorario = agregarHorario;
        this.agregarHorario.getBtnAgregar().addMouseListener(this);
        this.agregarHorario.getBtnVolver().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.agregarHorario.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.agregarHorario.getBtnAgregar()){
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
        this.agregarHorario.setVisible(false);
        ListarHorarios listarHorarios = new ListarHorarios();
        ControllerListarHorarios controllerListarHorarios = new ControllerListarHorarios(listarHorarios);
        listarHorarios.setVisible(true);
    }

    private void btnAgregarClicked(){
        getValues();

        ModelCreateEntity modelCreateEntity = new ModelCreateEntity();
        boolean creado = modelCreateEntity.createHorario(dia, horaInicio, horaFinalizacion, Integer.parseInt(grupo), Integer.parseInt(aula));

        if(creado){
            JOptionPane.showMessageDialog(this.agregarHorario, "Horario creado de manera satisfactoria.");
        }else{
            JOptionPane.showMessageDialog(this.agregarHorario, "Error al agregar el horario, contacte un administrador.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void getValues(){
        this.dia = this.agregarHorario.getCboDia().getSelectedItem().toString();
        this.horaInicio = this.agregarHorario.getCboHoraInicio().getSelectedItem().toString();
        this.horaFinalizacion = this.agregarHorario.getCboHoraFinalizacion().getSelectedItem().toString();
        this.grupo = this.agregarHorario.getCboGrupo().getSelectedItem().toString();
        this.aula = this.agregarHorario.getCboNumAula().getSelectedItem().toString();
    }
}
