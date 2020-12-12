package cr.ac.ucenfotec.bl.entities.Texto;

import java.util.ArrayList;

public interface ITextoDao {
    void registrarTexto(Texto t) throws Exception;
    ArrayList<Texto> listarTexto() throws Exception;
}
