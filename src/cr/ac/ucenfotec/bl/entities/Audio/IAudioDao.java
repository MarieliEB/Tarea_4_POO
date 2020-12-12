package cr.ac.ucenfotec.bl.entities.Audio;


import java.util.ArrayList;

public interface IAudioDao {

    void registrarAudio(Audio a) throws Exception;
    ArrayList<Audio> listarAudio() throws Exception;
}
