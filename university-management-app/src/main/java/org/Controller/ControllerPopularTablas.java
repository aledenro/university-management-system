package org.Controller;

import org.Model.ModelListarDepartamentos;
import org.Model.ModelListarEstudiantes;
import org.Model.ModelListarProfesores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControllerPopularTablas {
    public void popularTablaEstudiantes(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cédula");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Correo");
        model.addColumn("Teléfono");

        ModelListarEstudiantes modelListarEstudiantes = new ModelListarEstudiantes();
        ArrayList<Object[]> estudiantes = modelListarEstudiantes.getEstudiantes();

        for(Object[] estudiante : estudiantes){
            model.addRow(estudiante);
        }

        tabla.setModel(model);
    }

    public void popularTablaProfesores(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cédula");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Correo");
        model.addColumn("Teléfono");

        ModelListarProfesores modelListarProfesores = new ModelListarProfesores();
        ArrayList<Object[]> profesores = modelListarProfesores.getProfesores();

        for(Object[] profesor : profesores){
            model.addRow(profesor);
        }

        tabla.setModel(model);
    }

    public void popularTablaDepartamentos(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Ubicación");

        ModelListarDepartamentos modelListarDepartamentos = new ModelListarDepartamentos();
        ArrayList<Object[]> departamentos = modelListarDepartamentos.getDepartamentos();

        for(Object[] departamento : departamentos){
            model.addRow(departamento);
        }

        tabla.setModel(model);
    }
}
