package org.Controller;

import org.Model.ModelListarEstudiantes;
import org.View.ListarEstudiantes;
import org.View.MainMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerMainMenu implements MouseListener {

    MainMenu mainMenu;

    public ControllerMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.mainMenu.getBtnEstudiantes().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.mainMenu.getBtnEstudiantes()){
            btnEstudiantesClicked();
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
}
