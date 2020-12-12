package cr.ac.ucenfotec.bl.entities.Video;

import java.util.ArrayList;

public interface IVideoDao {
    void registrarVideo(Video v) throws Exception;
    ArrayList<Video> listarVideo() throws Exception;
}
