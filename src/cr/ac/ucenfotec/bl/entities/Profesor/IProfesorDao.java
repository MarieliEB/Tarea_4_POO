package cr.ac.ucenfotec.bl.entities.Profesor;

import java.util.ArrayList;

public interface IProfesorDao {
    void registrarProfesor(Profesor p) throws Exception;
    ArrayList<Profesor> listarProfesor() throws Exception;
}
