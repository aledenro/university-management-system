package org.Controller;

import org.View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerListarDepartamentos implements MouseListener {

    ListarDepartamentos listarDepartamentos;

    public ControllerListarDepartamentos(ListarDepartamentos listarDepartamentos) {
        this.listarDepartamentos = listarDepartamentos;
        this.listarDepartamentos.getBtnVolver().addMouseListener(this);
        this.listarDepartamentos.getBtnAgregarDepartamento().addMouseListener(this);
        this.listarDepartamentos.getBtnEditarDepartamento().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.listarDepartamentos.getBtnVolver()){
            btnVolverClicked();
        }
        if (e.getSource() == this.listarDepartamentos.getBtnAgregarDepartamento()){
            btnAgregarDepartamentoClicked();
        }
        if(e.getSource() == listarDepartamentos.getBtnEditarDepartamento()){
            btnEditarDepartamentoClicked();
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
        this.listarDepartamentos.setVisible(false);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(mainMenu);
    }

    private void btnAgregarDepartamentoClicked(){
        this.listarDepartamentos.setVisible(false);
        AgregarDepartamento agregarDepartamento = new AgregarDepartamento();
        ControllerAgregarDepartamento controllerAgregarDepartamento = new ControllerAgregarDepartamento(agregarDepartamento);
        agregarDepartamento.setVisible(true);
    }

    private void btnEditarDepartamentoClicked(){
        this.listarDepartamentos.setVisible(false);
        EditarDepartamento editarDepartamento = new EditarDepartamento();
        ControllerEditarDepartamento controllerEditarDepartamento = new ControllerEditarDepartamento(editarDepartamento);
        controllerEditarDepartamento.setFoundValues();
        editarDepartamento.setVisible(true);
    }
}
