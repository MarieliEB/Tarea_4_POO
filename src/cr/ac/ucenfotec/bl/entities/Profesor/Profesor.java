package cr.ac.ucenfotec.bl.entities.Profesor;

import cr.ac.ucenfotec.bl.entities.Persona;

import java.time.LocalDate;
import java.util.Objects;

public class Profesor extends Persona {

    private String identificacion;
    private String tipoContrato;
    private LocalDate fechaContratacion;


    public Profesor() {
    }

    public Profesor(String identificacion, String tipoContrato, LocalDate fechaContratacion) {
        this.identificacion = identificacion;
        this.tipoContrato = tipoContrato;
        this.fechaContratacion = fechaContratacion;
    }

    public Profesor(String nombre, String apellido, String identificacion, String tipoContrato, LocalDate fechaContratacion) {
        super(nombre, apellido);
        this.identificacion = identificacion;
        this.tipoContrato = tipoContrato;
        this.fechaContratacion = fechaContratacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profesor profesor = (Profesor) o;
        return identificacion.equals(profesor.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion);
    }

    @Override
    public String toString() {
        return "Profesor: " + '\n' +
                "Identificación= " + identificacion + '\n' +
                "Tipo de contrato= " + tipoContrato + '\n' +
                "Fecha de contratación= " + fechaContratacion +
                '\n';
    }

    public String dataToCSV(){
        return getNombre() + "," + getApellido() + "," + identificacion + "," + tipoContrato + "," + fechaContratacion;
    }
}
