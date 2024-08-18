package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelListarHorarios {

    public ArrayList<Object[]> getHorarios(){
        ArrayList<Object []> horarios = new ArrayList<>();
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();

            String sql = "{call getHorarios(?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.registerOutParameter(1, OracleTypes.CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(1);

            while(result.next()){
                Object [] item = {result.getLong("id_horario"), result.getString("dia")
                        , result.getString("horaInicio"), result.getString("horaFinaliza"), result.getLong("num_aula")
                        , result.getString("nombre_asignatura"), result.getString("nombre_profesor")};
                horarios.add(item);
            }

            return horarios;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al extraer los horarios (getHorarios): " + e);
        }
    }
}
