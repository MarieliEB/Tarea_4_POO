package cr.ac.ucenfotec.bl.entities.Administrativo;

import cr.ac.ucenfotec.bl.entities.Persona;

import java.util.Objects;

public class Administrativo extends Persona {

    private String identificacion;
    private String tipoNombramiento;
    private int cantHorasAsignadas;

    public Administrativo(String identificacion, String tipoNombramiento, int cantHorasAsignadas) {
        this.identificacion = identificacion;
        this.tipoNombramiento = tipoNombramiento;
        this.cantHorasAsignadas = cantHorasAsignadas;
    }

    public Administrativo(String nombre, String apellido, String identificacion, String tipoNombramiento, int cantHorasAsignadas) {
        super(nombre, apellido);
        this.identificacion = identificacion;
        this.tipoNombramiento = tipoNombramiento;
        this.cantHorasAsignadas = cantHorasAsignadas;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTipoNombramiento() {
        return tipoNombramiento;
    }

    public int getCantHorasAsignadas() {
        return cantHorasAsignadas;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setTipoNombramiento(String tipoNombramiento) {
        this.tipoNombramiento = tipoNombramiento;
    }

    public void setCantHorasAsignadas(int cantHorasAsignadas) {
        this.cantHorasAsignadas = cantHorasAsignadas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Administrativo that = (Administrativo) o;
        return identificacion.equals(that.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion);
    }

    @Override
    public String toString() {
        return "Administrativo: " + '\n' +
                "Identificación= " + identificacion + '\n' +
                "Tipo de nombramiento= " + tipoNombramiento + '\n' +
                "Ccantidad de horas asignadas= " + cantHorasAsignadas +
                '\n';
    }

    public String dataToCSV(){
        return getNombre() + "," + getApellido() + "," + identificacion + "," + tipoNombramiento + "," + cantHorasAsignadas;
    }
}
