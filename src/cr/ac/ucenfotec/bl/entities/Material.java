package cr.ac.ucenfotec.bl.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Material {
    private String signature;
    private LocalDate fechaCompra;
    private boolean restringido;
    private String tema;

    public Material(String signature, LocalDate fechaCompra, boolean restringodo, String tema) {
        signature = signature;
        this.fechaCompra = fechaCompra;
        this.restringido = restringodo;
        this.tema = tema;
    }

    public String getSignature() {
        return signature;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public boolean isRestringido() {
        return restringido;
    }

    public String getTema() {
        return tema;
    }

    public void setSignature(String signature) {
        signature = signature;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setRestringodo(boolean restringodo) {
        this.restringido = restringodo;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return signature.equals(material.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signature);
    }

    @Override
    public String toString() {
        return "Material: " + '\n' +
                "Signature (ID)= " + signature + '\n' +
                "Fecha de compra= " + fechaCompra + '\n' +
                "Material es restringido= " + restringido + '\n' +
                "Tema= " + tema +
                '\n';
    }
}
