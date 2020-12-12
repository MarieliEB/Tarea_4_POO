package cr.ac.ucenfotec.bl.entities;

public class Persona {
    private String nombre;
    private String apellido;

    //Constructor
    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getter
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    //Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nombre.equals(persona.nombre) &&
                apellido.equals(persona.apellido);
    }

    //ToString
    @Override
    public String toString() {
        return "Persona: " + '\n' +
                "Nombre= " + nombre + '\n' +
                "Apellido= " + apellido +
                '\n';
    }


    public String dataToCSV(){
        return getNombre() + "," + getApellido();
    }
}
