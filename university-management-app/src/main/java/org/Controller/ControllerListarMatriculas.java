package org.Controller;

import org.Model.ModelDeleteEntity;
import org.View.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerListarMatriculas implements MouseListener {

    ListarMatricula listarMatricula;

    public ControllerListarMatriculas(ListarMatricula listarMatricula) {
        this.listarMatricula = listarMatricula;
        this.listarMatricula.getBtnVolver().addMouseListener(this);
        this.listarMatricula.getBtnEliminar().addMouseListener(this);
        this.listarMatricula.getBtnAgregar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.listarMatricula.getBtnVolver()){
            btnVolverClicked();
        }
        if (e.getSource() == this.listarMatricula.getBtnAgregar()){
            btnAgregarClicked();
        }
        if(e.getSource() == this.listarMatricula.getBtnEliminar()){
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

    private void btnVolverClicked(){
        this.listarMatricula.setVisible(false);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(mainMenu);
    }

    private void btnAgregarClicked(){
        this.listarMatricula.setVisible(false);
        AgregarHorario agregarHorario = new AgregarHorario();
        ControllerAgregarHorario controllerAgregarHorario = new ControllerAgregarHorario(agregarHorario);
        agregarHorario.setVisible(true);
    }

    private void btnEditarClicked(){
        ModelDeleteEntity modelDeleteEntity = new ModelDeleteEntity();
        boolean eliminado = modelDeleteEntity.deleteMatricula(Integer.parseInt(listarMatricula.getCboIds().getSelectedItem().toString()));

        if (eliminado){
            JOptionPane.showMessageDialog(listarMatricula, "Matricula eliminada correctamente.");
        }

        ControllerPopularTablas controllerPopularTablas = new ControllerPopularTablas();
        controllerPopularTablas.popularTablaMatriculas(listarMatricula.getTblHorarios());
        ControllerPopularDropdowns controllerPopularDropdowns = new ControllerPopularDropdowns();
        controllerPopularDropdowns.llenarDropdownMatriculas(listarMatricula.getCboIds());
    }
}
