package cr.ac.ucenfotec.bl.entities.Profesor;

import cr.ac.ucenfotec.accesodatos.AccesoBD;
import cr.ac.ucenfotec.accesodatos.Conector;
import cr.ac.ucenfotec.utils.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

public class ProfesorDao implements IProfesorDao{

    public void registrarProfesor(Profesor p) throws Exception{
        try{
            String query = "INSERT INTO PROFESOR (NOMBRE, APELLIDO, IDENTIFICACION, TIPO_CONTRATO, FECHA_CONTRATACION) " +
                    "VALUES ('" + p.getNombre() + "','" + p.getApellido() + "','"  + p.getIdentificacion() + "','" + p.getTipoContrato() +
                    "','" + p.getFechaContratacion() + "')";
            Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]).ejecutarSQL(query);
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
        }
    }

    public ArrayList<Profesor> listarProfesor() throws Exception{
        ArrayList<Profesor> profesor = null;
        ResultSet rs = null;
        try{
            AccesoBD accesoDatos;
            String query = "SELECT NOMBRE, APELLIDO, IDENTIFICACION, TIPO_CONTRATO, FECHA_CONTRATACION FROM PROFESOR";
            accesoDatos= Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]);
            rs = accesoDatos.ejecutarSQL(query);
            //recorrer el rs
            while (rs.next()){
                Profesor tmpProfesor = new Profesor(rs.getString("NOMBRE"), rs.getString("APELLIDO"),
                        rs.getString("IDENTIFICACION"), rs.getString("TIPO_CONTRATO"),
                        rs.getDate("FECHA_CONTRATACION").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                if(profesor==null){
                    profesor = new ArrayList<>();
                }
                profesor.add(tmpProfesor);
            }
            return profesor;
        }
        catch (Exception e){
            throw e;
        }
    }
}
