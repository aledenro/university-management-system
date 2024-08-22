package org.Controller;

import org.Model.ModelCreateEntity;
import org.View.AgregarHorario;
import org.View.AgregarMatricula;
import org.View.ListarHorarios;
import org.View.ListarMatricula;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerAgregarMatricula implements MouseListener {

    private AgregarMatricula agregarMatricula;
    private String cedula = "";
    private String idHorario = "";

    public ControllerAgregarMatricula(AgregarMatricula agregarMatricula) {
        this.agregarMatricula = agregarMatricula;
        this.agregarMatricula.getBtnAgregar().addMouseListener(this);
        this.agregarMatricula.getBtnVolver().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.agregarMatricula.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.agregarMatricula.getBtnAgregar()){
            btnAgregarClicked();
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
        this.agregarMatricula.setVisible(false);
        ListarMatricula listarMatricula = new ListarMatricula();
        ControllerListarMatriculas controllerListarMatriculas = new ControllerListarMatriculas(listarMatricula);
        listarMatricula.setVisible(true);
    }

    private void btnAgregarClicked(){
        getValues();

        cedula = cedula.replaceAll("\\s.*", "");

        ModelCreateEntity modelCreateEntity = new ModelCreateEntity();
        boolean creado = modelCreateEntity.createMatricula(cedula, Integer.parseInt(idHorario));

        if(creado){
            JOptionPane.showMessageDialog(this.agregarMatricula, "Matricula agregada de manera satisfactoria.");
        }else{
            JOptionPane.showMessageDialog(this.agregarMatricula, "Error al agregar la matricula, contacte un administrador.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void getValues(){
        this.cedula = this.agregarMatricula.getCboEstudiante().getSelectedItem().toString();
        this.idHorario = this.agregarMatricula.getCboHorario().getSelectedItem().toString().charAt(0) + "";
    }
}
