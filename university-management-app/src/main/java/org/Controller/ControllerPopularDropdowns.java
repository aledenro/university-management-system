package org.Controller;

import org.Model.ModelGetEntity;
import org.Model.ModelListarAulas;
import org.Model.ModelListarDepartamentos;

import javax.swing.*;
import java.util.ArrayList;

public class ControllerPopularDropdowns {

    public ControllerPopularDropdowns() {
    }

    public void llenarDropdownDepartamentos(JComboBox comboBox){
        ModelListarDepartamentos modelListarDepartamentos = new ModelListarDepartamentos();
        ArrayList<Object[]> departamentos = modelListarDepartamentos.getDepartamentos();
        ArrayList<String> depts = new ArrayList<>();

        for (Object [] departamento : departamentos){
            depts.add(departamento[0].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(depts.toArray());

        comboBox.setModel(model);
    }

    public void llenarDropdownAulas(JComboBox comboBox){
        ModelListarAulas modelListarAulas = new ModelListarAulas();
        ArrayList<Object[]> aulas = modelListarAulas.getAulas();
        ArrayList<String> aulasArray = new ArrayList<>();

        for (Object [] aula : aulas){
            aulasArray.add(aula[0].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(aulasArray.toArray());

        comboBox.setModel(model);
    }
}
