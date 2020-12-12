package cr.ac.ucenfotec.dao;


import cr.ac.ucenfotec.bl.entities.Administrativo.IAdministrativoDao;
import cr.ac.ucenfotec.bl.entities.Audio.IAudioDao;
import cr.ac.ucenfotec.bl.entities.Estudiante.IEstudianteDao;
import cr.ac.ucenfotec.bl.entities.Otros.IOtrosDao;
import cr.ac.ucenfotec.bl.entities.Profesor.IProfesorDao;
import cr.ac.ucenfotec.bl.entities.Texto.ITextoDao;
import cr.ac.ucenfotec.bl.entities.Video.IVideoDao;
import cr.ac.ucenfotec.dao.DAOFactory;

public class TextFileDaoFactory extends DAOFactory {

    @Override
    public IProfesorDao getProfesorDAO() {
        return null;
    }

    @Override
    public IAudioDao getAudioDAO() {
        return null;
    }

    @Override
    public IVideoDao getVideoDAO() {
        return null;
    }

    @Override
    public ITextoDao getTextoDAO() {
        return null;
    }

    @Override
    public IOtrosDao getOtrosDAO() {
        return null;
    }

    @Override
    public IEstudianteDao getEstudianteDAO() {
        return null;
    }

    @Override
    public IAdministrativoDao getAdministrativoDAO() {
        return null;
    }
}
