package org.Controller;

import org.View.MainMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenuController implements MouseListener {

    MainMenu mainMenu;

    public MainMenuController(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.mainMenu.getBtnEstudiantes().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.mainMenu.getBtnEstudiantes()){
            System.out.println("Estudiantes");
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
}
