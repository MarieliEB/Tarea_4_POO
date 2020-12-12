package cr.ac.ucenfotec.bl.entities.Otros;

import java.util.ArrayList;

public interface IOtrosDao {
    void registrarOtros(Otros o) throws Exception;
    ArrayList<Otros> listarOtros() throws Exception;
}
