package org.Controller;

import org.Model.ModelListarEstudiantes;

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
}
