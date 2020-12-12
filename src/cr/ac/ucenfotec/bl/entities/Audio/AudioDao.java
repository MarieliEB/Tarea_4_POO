package cr.ac.ucenfotec.bl.entities.Audio;

import cr.ac.ucenfotec.accesodatos.AccesoBD;
import cr.ac.ucenfotec.accesodatos.Conector;
import cr.ac.ucenfotec.utils.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

public class AudioDao implements IAudioDao{

    public void registrarAudio(Audio a) throws Exception{
        try{
            String query = "INSERT INTO AUDIO (SIGNATURE, FECHA_COMPRA, RESTRINGIDO, TEMA, FORMATO, DURACION, IDIOMA) " +
                    "VALUES ('" + a.getSignature() + "','" + a.getFechaCompra() + "','"  + a.isRestringido() + "','" + a.getTema() +
                    "','" + a.getFormato() + "','"  + a.getDuracion() + "','" + a.getIdioma() + "')";
            Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]).ejecutarSQL(query);
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
        }
    }

    public ArrayList<Audio> listarAudio() throws Exception{
        ArrayList<Audio> audio = null;
        ResultSet rs = null;
        try{
            AccesoBD accesoDatos;
            String query = "SELECT SIGNATURE, FECHA_COMPRA, RESTRINGIDO, TEMA, FORMATO, DURACION, IDIOMA FROM AUDIO";
            accesoDatos= Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]);
            rs = accesoDatos.ejecutarSQL(query);
            //recorrer el rs
            while (rs.next()){
                Audio tmpAudio = new Audio(rs.getString("SIGNATURE"),
                        rs.getDate("FECHA_COMPRA").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        rs.getBoolean("RESTRINGIDO"), rs.getString("TEMA"), rs.getString("FORMATO"),
                        rs.getInt("DURACION"), rs.getString("IDIOMA"));
                if(audio==null){
                    audio = new ArrayList<>();
                }
                audio.add(tmpAudio);
            }
            return audio;
        }
        catch (Exception e){
            throw e;
        }
    }
}
