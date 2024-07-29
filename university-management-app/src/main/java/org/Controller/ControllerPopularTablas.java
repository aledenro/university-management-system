package org.Controller;

import org.Model.*;

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

    public void popularTablaAulas(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número de Aula");
        model.addColumn("Capacidad");

        ModelListarAulas modelListarAulas = new ModelListarAulas();
        ArrayList<Object[]> aulas = modelListarAulas.getAulas();

        for(Object[] aula : aulas){
            model.addRow(aula);
        }

        tabla.setModel(model);
    }

    public void popularTablaAsignaturas(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre Asignatura");
        model.addColumn("Creditos");
        model.addColumn("Nombre Departamento");
        model.addColumn("Nombre Profesor");

        ModelListarAsignaturas modelListarAsignaturas = new ModelListarAsignaturas();
        ArrayList<Object[]> asignaturas = modelListarAsignaturas.getAsignaturas();

        for(Object[] asignatura : asignaturas){
            model.addRow(asignatura);
        }

        tabla.setModel(model);
    }
}
