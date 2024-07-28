package org.Controller;

import org.View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerListarProfesores implements MouseListener {

    ListarProfesores listarProfesores;

    public ControllerListarProfesores(ListarProfesores listarProfesores) {
        this.listarProfesores = listarProfesores;
        this.listarProfesores.getBtnVolver().addMouseListener(this);
        this.listarProfesores.getBtnAgregarProfesor().addMouseListener(this);
        this.listarProfesores.getBtnEditarProfesor().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() ==  this.listarProfesores.getBtnVolver()){
            btnVolverClicked();
        }
        if (e.getSource() == this.listarProfesores.getBtnAgregarProfesor()){
            btnAgregarProfesorClicked();
        }
        if(e.getSource() == this.listarProfesores.getBtnEditarProfesor()){
            btnEditarProfesorClicked();
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
        this.listarProfesores.setVisible(false);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(mainMenu);
    }

    private void btnAgregarProfesorClicked(){
        this.listarProfesores.setVisible(false);
        AgregarProfesor agregarProfesor = new AgregarProfesor();
        ControllerAgregarProfesor controllerAgregarProfesor = new ControllerAgregarProfesor(agregarProfesor);
        agregarProfesor.setVisible(true);
    }

    private void btnEditarProfesorClicked(){
        this.listarProfesores.setVisible(false);
        EditarProfesor editarProfesor = new EditarProfesor();
        ControllerEditarProfesor controllerEditarProfesor = new ControllerEditarProfesor(editarProfesor);
        editarProfesor.setVisible(true);
    }
}
