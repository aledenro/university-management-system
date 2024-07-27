package org.Controller;

import org.View.AgregarEstudiante;
import org.View.EditarEstudiante;
import org.View.ListarEstudiantes;
import org.View.MainMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerListarEstudiantes implements MouseListener {

    ListarEstudiantes listarEstudiantes;

    public ControllerListarEstudiantes(ListarEstudiantes listarEstudiantes) {
        this.listarEstudiantes = listarEstudiantes;
        this.listarEstudiantes.getBtnVolver().addMouseListener(this);
        this.listarEstudiantes.getBtnAgregarEstudiante().addMouseListener(this);
        this.listarEstudiantes.getBtnEditarEstudiante().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.listarEstudiantes.getBtnVolver()){
            btnVolverClicked();
        }
        if (e.getSource() == this.listarEstudiantes.getBtnAgregarEstudiante()){
            btnAgregarEstudianteClicked();
        }
        if(e.getSource() == listarEstudiantes.getBtnEditarEstudiante()){
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
        this.listarEstudiantes.setVisible(false);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(mainMenu);
    }

    private void btnAgregarEstudianteClicked(){
        this.listarEstudiantes.setVisible(false);
        AgregarEstudiante agregarEstudiante = new AgregarEstudiante();
        ControllerAgregarEstudiante controllerAgregarEstudiante = new ControllerAgregarEstudiante(agregarEstudiante);
        agregarEstudiante.setVisible(true);
    }

    private void btnEditarEstudianteClicked(){
        this.listarEstudiantes.setVisible(false);
        EditarEstudiante editarEstudiante = new EditarEstudiante();
        ControllerEditarEstudiante controllerEditarEstudiante = new ControllerEditarEstudiante(editarEstudiante);
        editarEstudiante.setVisible(true);
    }
}
