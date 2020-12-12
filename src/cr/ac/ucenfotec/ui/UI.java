package cr.ac.ucenfotec.ui;

import espinoza.elizabeth.utilities.ui.ApplicationUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class UI extends ApplicationUI {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintStream out = System.out;


    public void mostrarMenu(){
        out.println("---- BIENVENIDO ---- !!");
        out.println("MENÚ PRINCIPAL");
        out.println("1.Registrar usuario");
        out.println("2.Listar usuarios");
        out.println("3.Registrar material");
        out.println("4.Listar materiales");
        out.println("5.Salir");
    }
}

