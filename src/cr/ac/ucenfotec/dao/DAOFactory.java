package cr.ac.ucenfotec.dao;


import cr.ac.ucenfotec.bl.entities.Administrativo.IAdministrativoDao;
import cr.ac.ucenfotec.bl.entities.Audio.IAudioDao;
import cr.ac.ucenfotec.bl.entities.Estudiante.IEstudianteDao;
import cr.ac.ucenfotec.bl.entities.Otros.IOtrosDao;
import cr.ac.ucenfotec.bl.entities.Profesor.IProfesorDao;
import cr.ac.ucenfotec.bl.entities.Texto.ITextoDao;
import cr.ac.ucenfotec.bl.entities.Video.IVideoDao;

public abstract class DAOFactory {
    public static int SQLSERVER=1;
    public static int TEXT_FILE = 2;


    public static DAOFactory getDaoFactory(int whichFactory){
        switch (whichFactory){
            case 1:
                return new SqlServerDaoFactory();
            case 2:
                return new TextFileDaoFactory();
            default:
                return null;
        }
    }

    public abstract IEstudianteDao getEstudianteDAO();
    public abstract IAdministrativoDao getAdministrativoDAO();
    public abstract IProfesorDao getProfesorDAO();
    public abstract IAudioDao getAudioDAO();
    public abstract IVideoDao getVideoDAO();
    public abstract ITextoDao getTextoDAO();
    public abstract IOtrosDao getOtrosDAO();

}
