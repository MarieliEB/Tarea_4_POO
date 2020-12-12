package cr.ac.ucenfotec.bl.entities.Video;

import cr.ac.ucenfotec.accesodatos.AccesoBD;
import cr.ac.ucenfotec.accesodatos.Conector;
import cr.ac.ucenfotec.utils.Utilities;
import java.time.ZoneId;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VideoDao implements IVideoDao{

    public void registrarVideo(Video v) throws Exception{
        try{
            String query = "INSERT INTO VIDEO (SIGNATURE, FECHA_COMPRA, RESTRINGIDO, TEMA, FORMATO, DURACION, IDIOMA, DIRECTOR) " +
                    "VALUES ('" + v.getSignature() + "','" + v.getFechaCompra() + "','"  + v.isRestringido() + "','" + v.getTema() +
                    "','" + v.getFormato() + "','"  + v.getDuracion() + "','" + v.getIdioma() + "','" + v.getDirector() + "')";
            Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]).ejecutarSQL(query);
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
        }
    }

    public ArrayList<Video> listarVideo() throws Exception{
        ArrayList<Video> videos = null;
        ResultSet rs = null;
        try{
            AccesoBD accesoDatos;
            String query = "SELECT SIGNATURE, FECHA_COMPRA, RESTRINGIDO, TEMA, FORMATO, DURACION, IDIOMA, DIRECTOR FROM VIDEO";
            accesoDatos= Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]);
            rs = accesoDatos.ejecutarSQL(query);
            //recorrer el rs
            while (rs.next()){
                Video tmpVideo = new Video(rs.getString("SIGNATURE"),
                        rs.getDate("FECHA_COMPRA").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        rs.getBoolean("RESTRINGIDO"), rs.getString("TEMA"), rs.getString("FORMATO"),
                        rs.getInt("DURACION"),rs.getString("IDIOMA"), rs.getString("DIRECTOR"));
                if(videos==null){
                    videos = new ArrayList<>();
                }
                videos.add(tmpVideo);
            }
            return videos;
        }
        catch (Exception e){
            throw e;
        }
    }
}


