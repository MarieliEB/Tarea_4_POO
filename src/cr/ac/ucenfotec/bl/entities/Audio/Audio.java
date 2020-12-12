package cr.ac.ucenfotec.bl.entities.Audio;

import cr.ac.ucenfotec.bl.entities.Material;

import java.time.LocalDate;

public class Audio extends Material {

    private String formato;
    private int duracion;
    private String idioma;

    public Audio(String signature, LocalDate fechaCompra, boolean restringodo, String tema, String formato, int duracion, String idioma) {
        super(signature, fechaCompra, restringodo, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
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

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Audio: " + '\n' +
                "Formato= " + formato + '\n' +
                "Duración= " + duracion + '\n' +
                "Idioma= " + idioma +
                '\n';
    }

    public String dataToCSV(){
        return getFormato() + "," + getDuracion() + "," + getIdioma();
    }
}
