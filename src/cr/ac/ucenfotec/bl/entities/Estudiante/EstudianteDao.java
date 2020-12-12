package cr.ac.ucenfotec.bl.entities.Estudiante;

import cr.ac.ucenfotec.accesodatos.AccesoBD;
import cr.ac.ucenfotec.accesodatos.Conector;
import cr.ac.ucenfotec.utils.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstudianteDao implements IEstudianteDao{

    public void registrarEstudiante(Estudiante e) throws Exception{
        try{
            String query = "INSERT INTO ESTUDIANTE (NOMBRE, APELLIDO, NUM_CARNET, CARRERA, CREDITOS_MATRICULADOS) " +
                    "VALUES ('" + e.getNombre() + "','" + e.getApellido() + "','"  + e.getNumCarnet() + "','" + e.getCarrera() +
                    "','" + e.getCreditosMatriculados() + "')";
            Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]).ejecutarSQL(query);
        }
        catch (SQLException ex){
            throw ex;
        }
        catch (Exception ex){
        }
    }

    public ArrayList<Estudiante> listarEstudiante() throws Exception{
        ArrayList<Estudiante> estudiante = null;
        ResultSet rs = null;
        try{
            AccesoBD accesoDatos;
            String query = "SELECT NOMBRE, APELLIDO, NUM_CARNET, CARRERA, CREDITOS_MATRICULADOS FROM ESTUDIANTE";
            accesoDatos= Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]);
            rs = accesoDatos.ejecutarSQL(query);
            //recorrer el rs
            while (rs.next()){
                Estudiante tmpEstudiante = new Estudiante(rs.getString("NOMBRE"), rs.getString("APELLIDO"),
                        rs.getInt("NUM_CARNET"), rs.getString("CARRERA"),
                        rs.getInt("CREDITOS_MATRICULADOS"));
                if(estudiante==null){
                    estudiante = new ArrayList<>();
                }
                estudiante.add(tmpEstudiante);
            }
            return estudiante;
        }
        catch (Exception e){
            throw e;
        }
    }
}
