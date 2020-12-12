package cr.ac.ucenfotec.bl.entities.Video;

import cr.ac.ucenfotec.bl.entities.Material;

import java.time.LocalDate;

public class Video extends Material {
    private String formato;
    private int duracion;
    private String idioma;
    private String director;

    public Video(String signature, LocalDate fechaCompra, boolean restringido, String tema, String formato, int duracion, String idioma, String director) {
        super(signature, fechaCompra, restringido, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
        this.director = director;
    }

    public String getFormato() {
        return formato;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getDirector() {
        return director;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Video: " + '\n' +
                "Formato= " + formato + '\n' +
                "Duración= " + duracion + '\n' +
                "Idioma= " + idioma + '\n' +
                "Director= " + director +
                '\n';
    }

    public String dataToCSV(){
        return getFormato() + "," + getDuracion() + "," + getIdioma() + "," + getDirector();
    }
}
