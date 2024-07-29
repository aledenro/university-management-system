package org.Controller;

import org.View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerListarAulas implements MouseListener {

    ListarAulas listarAulas;

    public ControllerListarAulas(ListarAulas listarAulas) {
        this.listarAulas = listarAulas;
        this.listarAulas.getBtnVolver().addMouseListener(this);
        this.listarAulas.getBtnAgregar().addMouseListener(this);
        this.listarAulas.getBtnEditar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.listarAulas.getBtnVolver()){
            btnVolverClicked();
        }
        if (e.getSource() == this.listarAulas.getBtnAgregar()){
            btnAgregarClicked();
        }
        if(e.getSource() == listarAulas.getBtnEditar()){
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
        this.listarAulas.setVisible(false);
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        ControllerMainMenu controllerMainMenu = new ControllerMainMenu(mainMenu);
    }

    private void btnAgregarClicked(){
        this.listarAulas.setVisible(false);
        AgregarAula agregarAula = new AgregarAula();
        ControllerAgregarAula controllerAgregarAula = new ControllerAgregarAula(agregarAula);
        agregarAula.setVisible(true);
    }

    private void btnEditarClicked(){
        this.listarAulas.setVisible(false);
        EditarDepartamento editarDepartamento = new EditarDepartamento();
        ControllerEditarDepartamento controllerEditarDepartamento = new ControllerEditarDepartamento(editarDepartamento);
        controllerEditarDepartamento.setFoundValues();
        editarDepartamento.setVisible(true);
    }
}
