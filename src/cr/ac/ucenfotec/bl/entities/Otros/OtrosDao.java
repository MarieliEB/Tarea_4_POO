package cr.ac.ucenfotec.bl.entities.Otros;

import cr.ac.ucenfotec.accesodatos.AccesoBD;
import cr.ac.ucenfotec.accesodatos.Conector;
import cr.ac.ucenfotec.utils.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

public class OtrosDao implements IOtrosDao {
    public void registrarOtros(Otros o) throws Exception{
        try{
            String query = "INSERT INTO OTROS (SIGNATURE, FECHA_COMPRA, RESTRINGIDO, TEMA, DESCRIPCION) " +
                    "VALUES ('" + o.getSignature() + "','" + o.getFechaCompra() + "','"  + o.isRestringido() + "','" + o.getTema() + o.getDescripcion() + "')";
            Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]).ejecutarSQL(query);
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
        }
    }

    public ArrayList<Otros> listarOtros() throws Exception{
        ArrayList<Otros> otros = null;
        ResultSet rs = null;
        try{
            AccesoBD accesoDatos;
            String query = "SELECT SIGNATURE, FECHA_COMPRA, RESTRINGIDO, TEMA, DESCRIPCION FROM OTROS";
            accesoDatos= Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]);
            rs = accesoDatos.ejecutarSQL(query);
            //recorrer el rs
            while (rs.next()){
                Otros tmpOtros = new Otros(rs.getString("SIGNATURE"),
                        rs.getDate("FECHA_COMPRA").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        rs.getBoolean("RESTRINGIDO"), rs.getString("TEMA"), rs.getString("DESCRIPCION"));
                if(otros==null){
                    otros = new ArrayList<>();
                }
                otros.add(tmpOtros);
            }
            return otros;
        }
        catch (Exception e){
            throw e;
        }
    }
}
