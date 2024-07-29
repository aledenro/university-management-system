package org.Controller;

import org.Model.ModelCreateEntity;
import org.Model.ModelGetEntity;
import org.View.AgregarAula;
import org.View.ListarAulas;
import org.View.ListarDepartamentos;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerAgregarAula implements MouseListener {

    private AgregarAula agregarAula;
    private String numAula = "";
    private String capacidad = "";


    public ControllerAgregarAula(AgregarAula agregarAula) {
        this.agregarAula = agregarAula;
        this.agregarAula.getBtnAgregar().addMouseListener(this);
        this.agregarAula.getBtnVolver().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.agregarAula.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.agregarAula.getBtnAgregar()){
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
        this.agregarAula.setVisible(false);
        ListarAulas listarAulas = new ListarAulas();
        ControllerListarAulas controllerListarAulas = new ControllerListarAulas(listarAulas);
        listarAulas.setVisible(true);
    }

    private void btnAgregarClicked(){
        getValues();

        boolean anyEmptyField = this.numAula.isEmpty() || this.capacidad.isEmpty();

        if (anyEmptyField){
            JOptionPane.showMessageDialog(this.agregarAula, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ControllerFormatValidator formatValidator = new ControllerFormatValidator();

        boolean containsOnlyNumbers = formatValidator.verifyOnlyNumbers(this.numAula) && formatValidator.verifyOnlyNumbers(this.capacidad);

        if (!containsOnlyNumbers){
            JOptionPane.showMessageDialog(this.agregarAula, "Por favor verifique que los campos solo contengan números.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] aula = modelGetEntity.getAula(Integer.parseInt(numAula));

        if (aula != null){
            JOptionPane.showMessageDialog(this.agregarAula, "El aula ya existe.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelCreateEntity modelCreateEntity = new ModelCreateEntity();
        boolean creado = modelCreateEntity.createAula(Integer.parseInt(numAula), Integer.parseInt(capacidad));

        if(creado){
            JOptionPane.showMessageDialog(this.agregarAula, "Aula creada de manera satisfactoria.");
            setEmptyValues();
        }else{
            JOptionPane.showMessageDialog(this.agregarAula, "Error al agregar el aula, contacte un administrador",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getValues(){
        this.numAula = this.agregarAula.getTxtNumAula().getText();
        this.capacidad = this.agregarAula.getTxtCapacidad().getText();
    }

    private void setEmptyValues(){
        this.agregarAula.getTxtNumAula().setText("");
        this.agregarAula.getTxtCapacidad().setText("");
    }
}
