package cr.ac.ucenfotec.bl.entities.Otros;

import cr.ac.ucenfotec.bl.entities.Material;

import java.time.LocalDate;

public class Otros extends Material {
    private String descripcion;

    public Otros(String signature, LocalDate fechaCompra, boolean restringodo, String tema, String descripcion) {
        super(signature, fechaCompra, restringodo, tema);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Otros: " + '\n' +
                "Descripción= " + descripcion + '\n';
    }

    public String dataToCSV(){
        return getDescripcion();
    }
}
