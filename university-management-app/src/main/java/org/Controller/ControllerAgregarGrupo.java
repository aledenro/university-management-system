package org.Controller;

import org.Model.ModelCreateEntity;
import org.Model.ModelGetEntity;
import org.View.AgregarAsignatura;
import org.View.AgregarGrupo;
import org.View.ListarAsignaturas;
import org.View.ListarGrupos;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerAgregarGrupo implements MouseListener {

    private AgregarGrupo agregarGrupo;
    private String nombreAsignatura = "";
    private String nombreProfesor = "";

    public ControllerAgregarGrupo(AgregarGrupo agregarGrupo) {
        this.agregarGrupo = agregarGrupo;
        this.agregarGrupo.getBtnAgregar().addMouseListener(this);
        this.agregarGrupo.getBtnVolver().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.agregarGrupo.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.agregarGrupo.getBtnAgregar()){
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
        this.agregarGrupo.setVisible(false);
        ListarGrupos listarGrupos = new ListarGrupos();
        ControllerListarGrupos controllerListarGrupos = new ControllerListarGrupos(listarGrupos);
        listarGrupos.setVisible(true);
    }

    private void btnAgregarClicked(){
        getValues();

        String id_profesor = nombreProfesor.charAt(0) + "";

        ModelCreateEntity modelCreateEntity = new ModelCreateEntity();
        boolean creado = modelCreateEntity.createGrupo(nombreAsignatura, Integer.parseInt(id_profesor));

        if(creado){
            JOptionPane.showMessageDialog(this.agregarGrupo, "Grupo creado de manera satisfactoria.");
        }else{
            JOptionPane.showMessageDialog(this.agregarGrupo, "Error al agregar el grupo, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void getValues(){
        this.nombreAsignatura = this.agregarGrupo.getCboAsignatura().getSelectedItem().toString();
        this.nombreProfesor = this.agregarGrupo.getCboProfesor().getSelectedItem().toString();
    }
}
