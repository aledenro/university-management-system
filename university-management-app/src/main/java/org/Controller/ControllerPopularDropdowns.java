package org.Controller;

import org.Model.*;

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

    public void llenarDropdownAsignaturas(JComboBox comboBox){
        ModelListarAsignaturas modelListarAsignaturas = new ModelListarAsignaturas();
        ArrayList<Object[]> asignaturas = modelListarAsignaturas.getAsignaturas();
        ArrayList<String> asignaturasArray = new ArrayList<>();

        for (Object [] asignatura : asignaturas){
            asignaturasArray.add(asignatura[0].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(asignaturasArray.toArray());

        comboBox.setModel(model);
    }

    public void llenarDropdownGrupos(JComboBox comboBox){
        ModelListarGrupos modelListarGrupos = new ModelListarGrupos();
        ArrayList<Object[]> grupos = modelListarGrupos.getGrupos();
        ArrayList<String> gruposArray = new ArrayList<>();

        for (Object [] grupo : grupos){
            gruposArray.add(grupo[0].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(gruposArray.toArray());

        comboBox.setModel(model);
    }
    public void llenarDropdownHorarios(JComboBox comboBox){
        ModelListarHorarios modelListarHorarios = new ModelListarHorarios();
        ArrayList<Object[]> horarios = modelListarHorarios.getHorarios();
        ArrayList<String> horariosArray = new ArrayList<>();

        for (Object [] horario : horarios){
            horariosArray.add(horario[0].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(horariosArray.toArray());

        comboBox.setModel(model);
    }

    public void llenarDropdownMatriculas(JComboBox comboBox){
        ModelListarMatriculas modelListarMatriculas = new ModelListarMatriculas();
        ArrayList<Object[]> matriculas = modelListarMatriculas.getMatriculas();
        ArrayList<String> matriculasArray = new ArrayList<>();

        for (Object [] matricula : matriculas){
            matriculasArray.add(matricula[0].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(matriculasArray.toArray());

        comboBox.setModel(model);
    }

    public void llenarDropdownHorariosConDetalles(JComboBox comboBox){
        ModelListarHorarios modelListarHorarios = new ModelListarHorarios();
        ArrayList<Object[]> horarios = modelListarHorarios.getHorarios();
        ArrayList<String> horariosArray = new ArrayList<>();

        for (Object [] horario : horarios){
            horariosArray.add(horario[0].toString() + " - " +  horario[5].toString() + " " + horario[1].toString() + " de " + horario[2].toString() + " a " +horario[3].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(horariosArray.toArray());

        comboBox.setModel(model);
    }


    public void llenarDropdownEstudiantes (JComboBox comboBox){
        ModelListarEstudiantes modelListarEstudiantes = new ModelListarEstudiantes();
        ArrayList<Object[]> estudiantes = modelListarEstudiantes.getEstudiantes();
        ArrayList<String> estudiantesArray = new ArrayList<>();

        for (Object [] estudiante : estudiantes){
            estudiantesArray.add(estudiante[0].toString() + " - " + estudiante[1].toString() + " " + estudiante[2].toString());
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(estudiantesArray.toArray());

        comboBox.setModel(model);
    }
}
