package org.Controller;

import org.View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerListarAsignaturas implements MouseListener {

    ListarAsignaturas listarAsignaturas;

    public ControllerListarAsignaturas(ListarAsignaturas listarAsignaturas) {
        this.listarAsignaturas = listarAsignaturas;
        this.listarAsignaturas.getBtnVolver().addMouseListener(this);
        this.listarAsignaturas.getBtnAgregar().addMouseListener(this);
        this.listarAsignaturas.getBtnEditar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.listarAsignaturas.getBtnVolver()){
            btnVolverClicked();
        }
        if (e.getSource() == this.listarAsignaturas.getBtnAgregar()){
            btnAgregarClicked();
        }
        if(e.getSource() == this.listarAsignaturas.getBtnEditar()){
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
        this.listarAsignaturas.setVisible(false);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(mainMenu);
    }

    private void btnAgregarClicked(){
        this.listarAsignaturas.setVisible(false);
        AgregarAsignatura agregarAsignatura = new AgregarAsignatura();
        ControllerAgregarAsignatura controllerAgregarAsignatura = new ControllerAgregarAsignatura(agregarAsignatura);
        agregarAsignatura.setVisible(true);
    }

    private void btnEditarClicked(){
        this.listarAsignaturas.setVisible(false);
        EditarAsignatura editarAsignatura = new EditarAsignatura();
        ControllerEditAsignatura controllerEditAsignatura = new ControllerEditAsignatura(editarAsignatura);
        controllerEditAsignatura.setFoundValues();
        editarAsignatura.setVisible(true);
    }
}
