package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.Administrativo.Administrativo;
import cr.ac.ucenfotec.bl.entities.Administrativo.AdministrativoDao;
import cr.ac.ucenfotec.bl.entities.Administrativo.IAdministrativoDao;
import cr.ac.ucenfotec.bl.entities.Audio.Audio;
import cr.ac.ucenfotec.bl.entities.Audio.AudioDao;
import cr.ac.ucenfotec.bl.entities.Audio.IAudioDao;
import cr.ac.ucenfotec.bl.entities.Estudiante.Estudiante;
import cr.ac.ucenfotec.bl.entities.Estudiante.EstudianteDao;
import cr.ac.ucenfotec.bl.entities.Estudiante.IEstudianteDao;
import cr.ac.ucenfotec.bl.entities.Otros.IOtrosDao;
import cr.ac.ucenfotec.bl.entities.Otros.Otros;
import cr.ac.ucenfotec.bl.entities.Otros.OtrosDao;
import cr.ac.ucenfotec.bl.entities.Profesor.IProfesorDao;
import cr.ac.ucenfotec.bl.entities.Profesor.Profesor;
import cr.ac.ucenfotec.bl.entities.Profesor.ProfesorDao;
import cr.ac.ucenfotec.bl.entities.Texto.ITextoDao;
import cr.ac.ucenfotec.bl.entities.Texto.Texto;
import cr.ac.ucenfotec.bl.entities.Texto.TextoDao;
import cr.ac.ucenfotec.bl.entities.Video.IVideoDao;
import cr.ac.ucenfotec.bl.entities.Video.Video;
import cr.ac.ucenfotec.bl.entities.Video.VideoDao;
import cr.ac.ucenfotec.dao.DAOFactory;
import cr.ac.ucenfotec.dl.Datos;
import cr.ac.ucenfotec.utils.Utilities;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Gestor {
    private Datos db;
    public Gestor() {
        db = new Datos();
    }

    public void registrarAdministativo(String nombre, String apellido, String identificacion, String tipoNombramiento, int cantHorasAsignadas) throws Exception{
        try{
            DAOFactory factory = DAOFactory.getDaoFactory(Integer.parseInt(Utilities.getMotorDB()));
            IAdministrativoDao dao = factory.getAdministrativoDAO();
            dao.registrarAdministrativo(new Administrativo(nombre, apellido, identificacion, tipoNombramiento, cantHorasAsignadas));
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
            throw  e;
        }
    }

    public String[] listarAdministrativo() throws Exception{
        int motorBD = Integer.parseInt(Utilities.getMotorDB());
        ArrayList<Administrativo> datos = new ArrayList<>();
            AdministrativoDao dao = new AdministrativoDao();
            dao.listarAdministrativo();

        String lista[] = new String[datos.size()];
        int pos = 0;
        for(Administrativo c : datos){
            lista[pos] = c.toString();
            pos++;
        }
        return lista;
    }

    public void registrarEstudiante(String nombre,String apellido,int numCarnet,String carrera, int creditosMatriculados) throws Exception{
        try{
            DAOFactory factory = DAOFactory.getDaoFactory(Integer.parseInt(Utilities.getMotorDB()));
            IEstudianteDao dao = factory.getEstudianteDAO();
            dao.registrarEstudiante(new Estudiante(nombre, apellido, numCarnet, carrera, creditosMatriculados));
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
            throw  e;
        }
    }

    public String[] listarEstudiante() throws Exception{
        ArrayList<Estudiante> datos = new ArrayList<>();
        EstudianteDao dao = new EstudianteDao();
        dao.listarEstudiante();

        String lista[] = new String[datos.size()];
        int pos = 0;
        for(Estudiante e : datos){
            lista[pos] = e.toString();
            pos++;
        }
        return lista;
    }

    public void registrarProfesor(String nombre,String apellido,String identificacion,String tipoContrato, LocalDate fechaContratacion) throws Exception{
        try{
            DAOFactory factory = DAOFactory.getDaoFactory(Integer.parseInt(Utilities.getMotorDB()));
            IProfesorDao dao = factory.getProfesorDAO();
            dao.registrarProfesor(new Profesor(nombre, apellido, identificacion, tipoContrato, fechaContratacion));
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
            throw  e;
        }
    }

    public String[] listarProfesor() throws Exception{
        ArrayList<Profesor> datos = new ArrayList<>();
        ProfesorDao dao = new ProfesorDao();
        dao.listarProfesor();

        String lista[] = new String[datos.size()];
        int pos = 0;
        for(Profesor e : datos){
            lista[pos] = e.toString();
            pos++;
        }
        return lista;
    }

    public void registrarVideo(String signature, LocalDate fechaCompra, boolean restringido, String tema, String formato, int duracion, String idioma, String director) throws Exception{
        try{
            DAOFactory factory = DAOFactory.getDaoFactory(Integer.parseInt(Utilities.getMotorDB()));
            IVideoDao dao = factory.getVideoDAO();
            dao.registrarVideo(new Video(signature, fechaCompra, restringido, tema, formato, duracion, idioma, director));
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
            throw  e;
        }
    }

    public String[] listarVideo() throws Exception{
        ArrayList<Video> datos = new ArrayList<>();
        VideoDao dao = new VideoDao();
        dao.listarVideo();

        String lista[] = new String[datos.size()];
        int pos = 0;
        for(Video v : datos){
            lista[pos] = v.toString();
            pos++;
        }
        return lista;
    }

    public void registrarAudio(String signature, LocalDate fechaCompra, boolean restringido, String tema, String formato, int duracion, String idioma) throws Exception{
        try{
            DAOFactory factory = DAOFactory.getDaoFactory(Integer.parseInt(Utilities.getMotorDB()));
            IAudioDao dao = factory.getAudioDAO();
            dao.registrarAudio(new Audio(signature, fechaCompra, restringido, tema, formato, duracion, idioma));
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
            throw  e;
        }
    }

    public String[] listarAudio() throws Exception{
        ArrayList<Audio> datos = new ArrayList<>();
        AudioDao dao = new AudioDao();
        dao.listarAudio();

        String lista[] = new String[datos.size()];
        int pos = 0;
        for(Audio a : datos){
            lista[pos] = a.toString();
            pos++;
        }
        return lista;
    }

    public void registrarTexto(String signature, LocalDate fechaCompra, boolean restringido, String tema, String titulo, String nombreAutor, LocalDate fechaPublicacion, int numPaginas, String idioma) throws Exception{
        try{
            DAOFactory factory = DAOFactory.getDaoFactory(Integer.parseInt(Utilities.getMotorDB()));
            ITextoDao dao = factory.getTextoDAO();
            dao.registrarTexto(new Texto(signature, fechaCompra, restringido, tema, titulo, nombreAutor, fechaPublicacion, numPaginas, idioma));
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
            throw  e;
        }
    }

    public String[] listarTexto() throws Exception{
        ArrayList<Texto> datos = new ArrayList<>();
        TextoDao dao = new TextoDao();
        dao.listarTexto();

        String lista[] = new String[datos.size()];
        int pos = 0;
        for(Texto t : datos){
            lista[pos] = t.toString();
            pos++;
        }
        return lista;
    }

    public void registrarOtros(String signature, LocalDate fechaCompra, boolean restringodo, String tema, String descripcion) throws Exception{
        try{
            DAOFactory factory = DAOFactory.getDaoFactory(Integer.parseInt(Utilities.getMotorDB()));
            IOtrosDao dao = factory.getOtrosDAO();
            dao.registrarOtros(new Otros(signature, fechaCompra, restringodo, tema, descripcion));
        }
        catch (SQLException e){
            throw e;
        }
        catch (Exception e){
            throw  e;
        }
    }

    public String[] listarOtros() throws Exception{
        ArrayList<Otros> datos = new ArrayList<>();
        OtrosDao dao = new OtrosDao();
        dao.listarOtros();

        String lista[] = new String[datos.size()];
        int pos = 0;
        for(Otros o : datos){
            lista[pos] = o.toString();
            pos++;
        }
        return lista;
    }

}
