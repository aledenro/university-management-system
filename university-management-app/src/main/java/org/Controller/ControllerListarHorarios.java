package org.Controller;

import org.View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerListarHorarios implements MouseListener {

    ListarHorarios listarHorarios;

    public ControllerListarHorarios(ListarHorarios listarHorarios) {
        this.listarHorarios = listarHorarios;
        this.listarHorarios.getBtnVolver().addMouseListener(this);
        this.listarHorarios.getBtnAgregar().addMouseListener(this);
        this.listarHorarios.getBtnEditar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.listarHorarios.getBtnVolver()){
            btnVolverClicked();
        }
        if (e.getSource() == this.listarHorarios.getBtnAgregar()){
            btnAgregarClicked();
        }
        if(e.getSource() == this.listarHorarios.getBtnEditar()){
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
        this.listarHorarios.setVisible(false);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(mainMenu);
    }

    private void btnAgregarClicked(){
        this.listarHorarios.setVisible(false);
        AgregarHorario agregarHorario = new AgregarHorario();
        ControllerAgregarHorario controllerAgregarHorario = new ControllerAgregarHorario(agregarHorario);
        agregarHorario.setVisible(true);
    }

    private void btnEditarClicked(){
        this.listarHorarios.setVisible(false);
        EditarHorario editarHorario = new EditarHorario();
        ControllerEditHorario controllerEditHorario = new ControllerEditHorario(editarHorario);
        controllerEditHorario.setFoundValues();
        editarHorario.setVisible(true);
    }
}
