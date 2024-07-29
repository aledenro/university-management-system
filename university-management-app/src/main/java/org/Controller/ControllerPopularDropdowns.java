package org.Controller;

import org.Model.ModelGetEntity;
import org.Model.ModelListarAulas;
import org.Model.ModelListarDepartamentos;
import org.Model.ModelListarProfesores;

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

    public void llenarDropdownProfesores(JComboBox comboBox){
        ModelListarProfesores modelListarProfesores = new ModelListarProfesores();
        ArrayList<Object[]> profesores = modelListarProfesores.getProfesores();
        ArrayList<String> profesoresArray = new ArrayList<>();

        for (Object [] profesor : profesores){
            profesoresArray.add(profesor[5].toString() + " " + profesor[1].toString() + " " + profesor[2].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(profesoresArray.toArray());

        comboBox.setModel(model);
    }
}
