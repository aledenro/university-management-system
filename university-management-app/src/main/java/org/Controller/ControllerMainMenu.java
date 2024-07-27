package org.Controller;

import org.Model.ModelListarEstudiantes;
import org.View.ListarEstudiantes;
import org.View.ListarProfesores;
import org.View.MainMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerMainMenu implements MouseListener {

    MainMenu mainMenu;

    public ControllerMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.mainMenu.getBtnEstudiantes().addMouseListener(this);
        this.mainMenu.getBtnProfesores().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.mainMenu.getBtnEstudiantes()){
            btnEstudiantesClicked();
        }else if(e.getSource() == this.mainMenu.getBtnProfesores()){
            btnProfesoresClicked();
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

    private void btnEstudiantesClicked(){
        this.mainMenu.setVisible(false);
        ListarEstudiantes listarEstudiantes = new ListarEstudiantes();
        ControllerListarEstudiantes modelListarEstudiantes = new ControllerListarEstudiantes(listarEstudiantes);
        listarEstudiantes.setVisible(true);
    }

    private void btnProfesoresClicked(){
        this.mainMenu.setVisible(false);
        ListarProfesores listarProfesores = new ListarProfesores();
        ControllerListarProfesores controllerListarProfesores = new ControllerListarProfesores(listarProfesores);
        listarProfesores.setVisible(true);
    }
}
