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
            btnAgregarEstudianteClicked();
        }
        if(e.getSource() == this.listarProfesores.getBtnEditarProfesor()){
            btnEditarEstudianteClicked();
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

    private void btnAgregarEstudianteClicked(){
        this.listarProfesores.setVisible(false);
        AgregarEstudiante agregarEstudiante = new AgregarEstudiante();
        ControllerAgregarEstudiante controllerAgregarEstudiante = new ControllerAgregarEstudiante(agregarEstudiante);
        agregarEstudiante.setVisible(true);
    }

    private void btnEditarEstudianteClicked(){
        this.listarProfesores.setVisible(false);
        EditarEstudiante editarEstudiante = new EditarEstudiante();
        ControllerEditarEstudiante controllerEditarEstudiante = new ControllerEditarEstudiante(editarEstudiante);
        editarEstudiante.setVisible(true);
    }
}
