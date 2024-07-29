package org.Controller;

import org.Model.ModelListarEstudiantes;
import org.View.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerMainMenu implements MouseListener {

    MainMenu mainMenu;

    public ControllerMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.mainMenu.getBtnEstudiantes().addMouseListener(this);
        this.mainMenu.getBtnProfesores().addMouseListener(this);
        this.mainMenu.getBtnDepartamentos().addMouseListener(this);
        this.mainMenu.getBtnAulas().addMouseListener(this);
        this.mainMenu.getBtnAsignaturas().addMouseListener(this);
        this.mainMenu.getBtnGrupos().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.mainMenu.getBtnEstudiantes()){
            btnEstudiantesClicked();
        }else if(e.getSource() == this.mainMenu.getBtnProfesores()){
            btnProfesoresClicked();
        }else if(e.getSource() == this.mainMenu.getBtnDepartamentos()){
            btnDepartamentosClicked();
        }else if(e.getSource() == this.mainMenu.getBtnAulas()){
            btnAulasClicked();
        }else if(e.getSource() == this.mainMenu.getBtnAsignaturas()){
            btnAsignaturasClicked();
        }else if(e.getSource() == this.mainMenu.getBtnGrupos()){
            btnGruposClicked();
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

    private void btnDepartamentosClicked(){
        this.mainMenu.setVisible(false);
        ListarDepartamentos listarDepartamentos = new ListarDepartamentos();
        ControllerListarDepartamentos controllerListarDepartamentos = new ControllerListarDepartamentos(listarDepartamentos);
        listarDepartamentos.setVisible(true);
    }

    private void btnAulasClicked(){
        this.mainMenu.setVisible(false);
        ListarAulas listarAulas = new ListarAulas();
        ControllerListarAulas controllerListarAulas = new ControllerListarAulas(listarAulas);
        listarAulas.setVisible(true);
    }

    private void btnAsignaturasClicked(){
        this.mainMenu.setVisible(false);
        ListarAsignaturas listarAsignaturas = new ListarAsignaturas();
        ControllerListarAsignaturas controllerListarAsignaturas = new ControllerListarAsignaturas(listarAsignaturas);
        listarAsignaturas.setVisible(true);
    }

    private void btnGruposClicked(){
        this.mainMenu.setVisible(false);
        ListarGrupos listarGrupos = new ListarGrupos();
        ControllerListarGrupos controllerListarGrupos = new ControllerListarGrupos(listarGrupos);
        listarGrupos.setVisible(true);
    }
}
