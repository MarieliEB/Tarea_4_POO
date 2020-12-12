package cr.ac.ucenfotec.bl.entities.Administrativo;

import cr.ac.ucenfotec.accesodatos.AccesoBD;
import cr.ac.ucenfotec.accesodatos.Conector;
import cr.ac.ucenfotec.utils.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

public class AdministrativoDao implements IAdministrativoDao{

    public void registrarAdministrativo(Administrativo a) throws Exception{
        try{
            String query = "INSERT INTO ADMINISTRATIVO (NOMBRE, APELLIDO, IDENTIFICACION, TIPO_NOMBREMIENTO, HORAS_ASIGNADAS) " +
                    "VALUES ('" + a.getNombre() + "','" + a.getApellido() + "','"  + a.getIdentificacion() + "','" + a.getTipoNombramiento() +
                    "','" + a.getCantHorasAsignadas() + "')";
            Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]).ejecutarSQL(query);
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
        }
    }

    public ArrayList<Administrativo> listarAdministrativo() throws Exception{
        ArrayList<Administrativo> administrativo = null;
        ResultSet rs = null;
        try{
            AccesoBD accesoDatos;
            String query = "SELECT NOMBRE, APELLIDO, IDENTIFICACION, TIPO_NOMBREMIENTO, HORAS_ASIGNADAS FROM ADMINISTRATIVO";
            accesoDatos= Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]);
            rs = accesoDatos.ejecutarSQL(query);
            //recorrer el rs
            while (rs.next()){
                Administrativo tmpAdministrativo = new Administrativo(rs.getString("NOMBRE"), rs.getString("APELLIDO"),
                        rs.getString("IDENTIFICACION"), rs.getString("TIPO_NOMBREMIENTO"),
                        rs.getInt("HORAS_ASIGNADAS"));
                if(administrativo==null){
                    administrativo = new ArrayList<>();
                }
                administrativo.add(tmpAdministrativo);
            }
            return administrativo;
        }
        catch (Exception e){
            throw e;
        }
    }
}
