package org.Controller;

import org.Model.ModelEditEntity;
import org.Model.ModelGetEntity;
import org.View.EditarAula;
import org.View.ListarAulas;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControllerEditarAula implements MouseListener, ItemListener {

    private EditarAula editarAula;

    private String idAula = "";
    private String capacidad = "";

    public ControllerEditarAula(EditarAula editarAula) {
        this.editarAula = editarAula;
        this.editarAula.getBtnVolver().addMouseListener(this);
        this.editarAula.getBtnGuardar().addMouseListener(this);
        this.editarAula.getCboAula().addItemListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.editarAula.getBtnVolver()){
            btnVolverClicked();
        }

        if (e.getSource() == this.editarAula.getBtnGuardar()){
            btnGuardarClicked();
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == this.editarAula.getCboAula()){
            setFoundValues();
        }
    }

    private void btnVolverClicked(){
        this.editarAula.setVisible(false);
        ListarAulas listarAulas = new ListarAulas();
        ControllerListarAulas controllerListarAulas = new ControllerListarAulas(listarAulas);
        listarAulas.setVisible(true);
    }

    private void btnGuardarClicked() {

        boolean anyEmptyField = this.editarAula.getTxtCapacidad().getText().isEmpty();

        if (anyEmptyField) {
            JOptionPane.showMessageDialog(this.editarAula, "Por favor verifique que haya completado todos los campos.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ControllerFormatValidator formatValidator = new ControllerFormatValidator();

        boolean containsOnlyNumbers = formatValidator.verifyOnlyNumbers(this.idAula) && formatValidator.verifyOnlyNumbers(this.capacidad);

        if (!containsOnlyNumbers){
            JOptionPane.showMessageDialog(this.editarAula, "Por favor verifique que los campos solo contengan números.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        getValues();
        
            ModelEditEntity modelEditEntity = new ModelEditEntity();
            boolean creado = modelEditEntity.editAula(Integer.parseInt(idAula), Integer.parseInt(capacidad));

            if (creado) {
                JOptionPane.showMessageDialog(this.editarAula, "Aula editada de manera satisfactoria.");
                setFoundValues();
            } else {
                JOptionPane.showMessageDialog(this.editarAula, "Error al editar el aula, contacte un administrador",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    private void getValues(){
        this.capacidad = this.editarAula.getTxtCapacidad().getText();
        this.idAula = this.editarAula.getCboAula().getSelectedItem().toString();
    }

    public void setFoundValues(){
        getValues();
        ModelGetEntity modelGetEntity = new ModelGetEntity();
        Object[] aula = modelGetEntity.getAula(Integer.parseInt(this.idAula));
        this.editarAula.getTxtCapacidad().setText(aula[1].toString());
    }
}
