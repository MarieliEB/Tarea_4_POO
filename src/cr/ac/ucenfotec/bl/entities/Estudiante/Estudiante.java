package cr.ac.ucenfotec.bl.entities.Estudiante;


import cr.ac.ucenfotec.bl.entities.Persona;

import java.util.Objects;

public class Estudiante extends Persona {
    private int numCarnet;
    private String carrera;
    private int creditosMatriculados;

    public Estudiante(int numCarnet, String carrera, int creditosMatriculados) {
        this.numCarnet = numCarnet;
        this.carrera = carrera;
        this.creditosMatriculados = creditosMatriculados;
    }

    public Estudiante(String nombre, String apellido, int numCarnet, String carrera, int creditosMatriculados) {
        super(nombre, apellido);
        this.numCarnet = numCarnet;
        this.carrera = carrera;
        this.creditosMatriculados = creditosMatriculados;
    }

    public int getNumCarnet() {
        return numCarnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getCreditosMatriculados() {
        return creditosMatriculados;
    }

    public void setNumCarnet(int numCarnet) {
        this.numCarnet = numCarnet;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setCreditosMatriculados(int creditosMatriculados) {
        this.creditosMatriculados = creditosMatriculados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estudiante that = (Estudiante) o;
        return numCarnet == that.numCarnet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numCarnet);
    }

    @Override
    public String toString() {
        return "Estudiante: " + '\n' +
                "Número de carnet= " + numCarnet + '\n' +
                "Carrera= " + carrera + '\n' +
                "Créditos matriculados= " + creditosMatriculados +
                '\n';
    }

    public String dataToCSV(){
        return getNombre() + "," + getApellido() + "," + numCarnet + "," + carrera + "," + creditosMatriculados;
    }
}
