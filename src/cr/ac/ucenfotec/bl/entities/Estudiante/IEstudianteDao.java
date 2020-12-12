package cr.ac.ucenfotec.bl.entities.Estudiante;

import java.util.ArrayList;

public interface IEstudianteDao {

    void registrarEstudiante(Estudiante a) throws Exception;
    ArrayList<Estudiante> listarEstudiante() throws Exception;
}

