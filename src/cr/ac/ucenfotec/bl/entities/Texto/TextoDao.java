package cr.ac.ucenfotec.bl.entities.Texto;

import cr.ac.ucenfotec.accesodatos.AccesoBD;
import cr.ac.ucenfotec.accesodatos.Conector;
import cr.ac.ucenfotec.bl.entities.Video.Video;
import cr.ac.ucenfotec.utils.Utilities;
import org.w3c.dom.Text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;

public class TextoDao implements ITextoDao{

    public void registrarTexto(Texto t) throws Exception{
        try{
            String query = "INSERT INTO TEXTO (SIGNATURE, FECHA_COMPRA, RESTRINGIDO, TEMA, TITULO, NOMBRE_AUTOR, FECHA_PUBLICACION, NUM_PAGINAS, IDIOMA) " +
                    "VALUES ('" + t.getSignature() + "','" + t.getFechaCompra() + "','"  + t.isRestringido() + "','" + t.getTema() +
                    "','" + t.getTitulo() + "','"  + t.getNombreAutor() + "','" + t.getFechaPublicacion() + "','" + t.getNumPaginas() + "','" + t.getIdioma() + "')";
            Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]).ejecutarSQL(query);
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
        }
    }

    public ArrayList<Texto> listarTexto() throws Exception{
        ArrayList<Texto> textos = null;
        ResultSet rs = null;
        try{
            AccesoBD accesoDatos;
            String query = "SELECT SIGNATURE, FECHA_COMPRA, RESTRINGIDO, TEMA, TITULO, NOMBRE_AUTOR, FECHA_PUBLICACION, NUM_PAGINAS, IDIOMA FROM TEXTO";
            accesoDatos= Conector.getConnector(Utilities.getProperties()[0],Utilities.getProperties()[1]);
            rs = accesoDatos.ejecutarSQL(query);
            //recorrer el rs
            while (rs.next()){
                Texto tmpTextos = new Texto(rs.getString("SIGNATURE"),
                        rs.getDate("FECHA_COMPRA").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        rs.getBoolean("RESTRINGIDO"), rs.getString("TEMA"), rs.getString("TITULO"),
                        rs.getString("NOMBRE_AUTOR"),rs.getDate("FECHA_PUBLICACION").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        rs.getInt("NUM_PAGINAS"), rs.getString("IDIOMA"));
                if(textos==null){
                    textos = new ArrayList<>();
                }
                textos.add(tmpTextos);
            }
            return textos;
        }
        catch (Exception e){
            throw e;
        }
    }
}
