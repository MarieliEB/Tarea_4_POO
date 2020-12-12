package cr.ac.ucenfotec.bl.entities.Administrativo;

import java.util.ArrayList;

public interface IAdministrativoDao {

    void registrarAdministrativo(Administrativo a) throws Exception;
    ArrayList<Administrativo> listarAdministrativo() throws Exception;
}
