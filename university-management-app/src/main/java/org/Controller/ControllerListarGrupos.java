package org.Controller;

import org.View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerListarGrupos implements MouseListener {

    ListarGrupos listarGrupos;

    public ControllerListarGrupos(ListarGrupos listarGrupos) {
        this.listarGrupos = listarGrupos;
        this.listarGrupos.getBtnVolver().addMouseListener(this);
        this.listarGrupos.getBtnAgregar().addMouseListener(this);
        this.listarGrupos.getBtnEditar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.listarGrupos.getBtnVolver()){
            btnVolverClicked();
        }
        if (e.getSource() == this.listarGrupos.getBtnAgregar()){
            btnAgregarClicked();
        }
        if(e.getSource() == this.listarGrupos.getBtnEditar()){
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
        this.listarGrupos.setVisible(false);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(mainMenu);
    }

    private void btnAgregarClicked(){
        this.listarGrupos.setVisible(false);
        AgregarAsignatura agregarAsignatura = new AgregarAsignatura();
        ControllerAgregarAsignatura controllerAgregarAsignatura = new ControllerAgregarAsignatura(agregarAsignatura);
        agregarAsignatura.setVisible(true);
    }

    private void btnEditarClicked(){
        this.listarGrupos.setVisible(false);
        EditarAsignatura editarAsignatura = new EditarAsignatura();
        ControllerEditAsignatura controllerEditAsignatura = new ControllerEditAsignatura(editarAsignatura);
        controllerEditAsignatura.setFoundValues();
        editarAsignatura.setVisible(true);
    }
}
