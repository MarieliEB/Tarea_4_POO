package cr.ac.ucenfotec.bl.entities.Texto;

import cr.ac.ucenfotec.bl.entities.Material;

import java.time.LocalDate;

public class Texto extends Material {
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
    private int numPaginas;
    private String idioma;

    public Texto(String signature, LocalDate fechaCompra, boolean restringido, String tema, String titulo, String nombreAutor, LocalDate fechaPublicacion, int numPaginas, String idioma) {
        super(signature, fechaCompra, restringido, tema);
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Texto: " + '\n' +
                "Título= " + titulo + '\n' +
                "Nombre de autor= " + nombreAutor + '\n' +
                "Fecha de publicación= " + fechaPublicacion + '\n' +
                "Número de páginas= " + numPaginas + '\n' +
                "Idioma= " + idioma +
                '\n';
    }

    public String dataToCSV(){
        return getTitulo() + "," + getNombreAutor() + "," + getFechaPublicacion() + "," + getNumPaginas() + "," + getIdioma();
    }
}
