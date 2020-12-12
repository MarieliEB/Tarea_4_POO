package cr.ac.ucenfotec.bl.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {
    private Persona usuario;
    private ArrayList<Material> itemsEnPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Persona usuario, ArrayList<Material> itemsEnPrestamo, LocalDate fechaDevolucion) {
        this.usuario = usuario;
        this.itemsEnPrestamo = new ArrayList<>();
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(Material nuevoMaterial){
        this.itemsEnPrestamo.add(nuevoMaterial);
    }

    public Persona getUsuario() {
        return usuario;
    }

    public ArrayList<Material> getItemsEnPrestamo() {
        return itemsEnPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public void setItemsEnPrestamo(ArrayList<Material> itemsEnPrestamo) {
        this.itemsEnPrestamo = itemsEnPrestamo;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void addItem(Material material) {this.itemsEnPrestamo.add(material);}

    @Override
    public String toString() {
        String infoPrestamo= "";
        infoPrestamo += "Prestamo: " + "\n" +
                        "Persona= " + usuario + "\n" +
                        "Fecha de devolución= " + fechaDevolucion + "\n";
                infoPrestamo +=  "******Lista de materiales****** \n";
                if(itemsEnPrestamo.size() == 0){
                    infoPrestamo += "No posee cuentas  \n";
                }else {
                    infoPrestamo +=  listaItemsToString () + "\n";
                }
        return infoPrestamo;
    }

    public String listaItemsToString(){
        String infoItems= "";
        for (Material material: itemsEnPrestamo) {
            infoItems += material.toString () + "\n";
        }
        return infoItems;
    }


}
