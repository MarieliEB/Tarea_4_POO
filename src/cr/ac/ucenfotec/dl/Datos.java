package cr.ac.ucenfotec.dl;

import cr.ac.ucenfotec.bl.entities.Administrativo.Administrativo;
import cr.ac.ucenfotec.bl.entities.Audio.Audio;
import cr.ac.ucenfotec.bl.entities.Estudiante.Estudiante;
import cr.ac.ucenfotec.bl.entities.Material;
import cr.ac.ucenfotec.bl.entities.Otros.Otros;
import cr.ac.ucenfotec.bl.entities.Persona;
import cr.ac.ucenfotec.bl.entities.Profesor.Profesor;
import cr.ac.ucenfotec.bl.entities.Texto.Texto;
import cr.ac.ucenfotec.bl.entities.Video.Video;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class Datos {

    public Datos() {

    }

    private final String ARCHIVO_DEFAULT = "Archivo.txt";
    private final String ARCHIVO_ADMINISTRATIVO = "ArchivoAdministrativo.txt";
    private final String ARCHIVO_ESTUDIANTE = "ArchivoEstudiante.txt";
    private final String ARCHIVO_PROFESOR = "ArchivoProfesor.txt";
    private final String ARCHIVO_TEXTO = "ArchivoTexto.txt";
    private final String ARCHIVO_OTROS = "ArchivoOtros.txt";
    private final String ARCHIVO_AUDIO = "ArchivoAudio.txt";
    private final String ARCHIVO_VIDEO = "ArchivoVideo.txt";

    /**
     * guarda personas en el archivo de texto
     *
     * @param p
     */
    public void guardarPersona(Persona p) {
        try {
            FileWriter writer = setFileWriter(p.getClass().getSimpleName());
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(p.dataToCSV());
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //factory method.
    /**
     * Inicializa el file writer.
     *
     * @param className
     * @return
     * @throws IOException
     */
    private FileWriter setFileWriter(String className) throws IOException {
        switch (className) {
            case "Administrativo":
                return new FileWriter(ARCHIVO_ADMINISTRATIVO, true);
            case "Estudiante":
                return new FileWriter(ARCHIVO_ESTUDIANTE, true);
            case "Profesor":
                return new FileWriter(ARCHIVO_PROFESOR, true);
            case "Audio":
                return new FileWriter(ARCHIVO_AUDIO, true);
            case "Video":
                return new FileWriter(ARCHIVO_VIDEO, true);
            case "Texto":
                return new FileWriter(ARCHIVO_TEXTO, true);
            case "Otros":
                return new FileWriter(ARCHIVO_OTROS, true);
            default:
                return new FileWriter(ARCHIVO_DEFAULT, true);
        }
    }

    //fatory method
    private FileReader setFileReader(String className) throws IOException {
        switch (className) {
            case "Administrativo":
                return new FileReader(ARCHIVO_ADMINISTRATIVO);
            case "Estudiante":
                return new FileReader(ARCHIVO_ESTUDIANTE);
            case "Profesor":
                return new FileReader(ARCHIVO_PROFESOR);
            case "Audio":
                return new FileReader(ARCHIVO_AUDIO);
            case "Video":
                return new FileReader(ARCHIVO_VIDEO);
            case "Texto":
                return new FileReader(ARCHIVO_TEXTO);
            case "Otros":
                return new FileReader(ARCHIVO_OTROS);
            default:
                return new FileReader(ARCHIVO_DEFAULT);
        }
    }

    //factory method
    private Persona crearPersona(String className, String[] datos) {
        switch (className) {
            case "Administrativo":
                return new Administrativo(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
            case "Estudiante":
                return new Estudiante(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], Integer.parseInt(datos[4]));
            case "Profesor":
                LocalDate date = LocalDate.now();
                return new Profesor(datos[0], datos[1], datos[2], datos[3], date);
            default:
                return null;
        }
    }

    //factory method
    private Material crearMaterial (String className, String[] datos) {
        LocalDate date = LocalDate.now();
        switch (className) {
            case "Audio":
                return new Audio(datos[0], date, Boolean.parseBoolean(datos[1]), datos[2], datos[3], Integer.parseInt(datos[4]), datos[5]);
            case "Video":
                return new Video(datos[0], date, Boolean.parseBoolean(datos[1]), datos[2], datos[3],Integer.parseInt(datos[4]), datos[5], datos[6]);
            case "Texto":
                return new Texto(datos[0], date, Boolean.parseBoolean(datos[1]),  datos[2], datos[3], datos[4], date, Integer.parseInt(datos[5]), datos[6]);
            case "Otros":
                return new Otros(datos[0], date,Boolean.parseBoolean(datos[1]),  datos[2], datos[3]);
            default:
                return null;
        }
    }

    /**
     * Lista las personas de un archivo de texto.
     *
     * @param className
     * @return
     */
    public ArrayList<Persona> getInfoPersonasFromText(String className) {
        ArrayList<Persona> personas = null;
        try {
            FileReader reader = setFileReader(className);
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            String[] infoPersona = new String[5];

            while ((datos = buffer.readLine()) != null) {
                if (personas == null) {
                    personas = new ArrayList<>();
                }
                personas.add(crearPersona(className, datos.split(",")));
            }
            reader.close();//se cierra el reader.

        } catch (IOException e) {
            e.printStackTrace();
        }
        return personas;
    }

    /**
     * Lista las materiales de un archivo de texto.
     *
     * @param className
     * @return
     */
    public ArrayList<Material> getInfoMaterialesFromText(String className) {
        ArrayList<Material> materiales = null;
        try {
            FileReader reader = setFileReader(className);
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            String[] infoMateriales = new String[7];

            while ((datos = buffer.readLine()) != null) {
                if (materiales == null) {
                    materiales = new ArrayList<>();
                }
                materiales.add(crearMaterial(className, datos.split(",")));
            }
            reader.close();//se cierra el reader.

        } catch (IOException e) {
            e.printStackTrace();
        }
        return materiales;
    }
}
