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

    public void popularTablaGrupos(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número de Grupo");
        model.addColumn("Cantidad de Estudiantes");
        model.addColumn("Nombre Asignatura");
        model.addColumn("Nombre Profesor");

        ModelListarGrupos modelListarGrupos = new ModelListarGrupos();
        ArrayList<Object[]> grupos = modelListarGrupos.getGrupos();

        for(Object[] grupo : grupos){
            model.addRow(grupo);
        }

        tabla.setModel(model);
    }

    public void popularTablaHorarios(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Identificador Horario");
        model.addColumn("Dia");
        model.addColumn("Hora de Inicio");
        model.addColumn("Hora de Finalización");
        model.addColumn("Num. Aula");
        model.addColumn("Nombre Asignatura");
        model.addColumn("Nombre Profesor");

        ModelListarHorarios modelListarHorarios = new ModelListarHorarios();
        ArrayList<Object[]> horarios = modelListarHorarios.getHorarios();

        for(Object[] horario : horarios){
            model.addRow(horario);
        }

        tabla.setModel(model);
    }

    public void popularTablaMatriculas(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Identificador Matricula");
        model.addColumn("Cedula");
        model.addColumn("Nombre Estudiante");
        model.addColumn("Fecha Matricula");
        model.addColumn("Dia");
        model.addColumn("Hora de Inicio");
        model.addColumn("Hora de Finalización");
        model.addColumn("Num. Aula");
        model.addColumn("Nombre Asignatura");
        model.addColumn("Nombre Profesor");

        ModelListarMatriculas modelListarMatriculas = new ModelListarMatriculas();
        ArrayList<Object[]> matriculas = modelListarMatriculas.getMatriculas();

        for(Object[] matricula : matriculas){
            model.addRow(matricula);
        }

        tabla.setModel(model);
    }
}
