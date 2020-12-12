package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.Gestor;
import cr.ac.ucenfotec.ui.UI;

import java.io.IOException;
import java.time.LocalDate;

public class Controller {

    private UI interfaz = new UI();
    private Gestor controllerGestor = new Gestor();

    public Controller(){
    }
    public void start() throws Exception {
        int opcion = -1;
        do{
            interfaz.mostrarMenu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        }
        while (opcion!=-0);
    }

    public void procesarOpcion(int pOpcion) throws Exception
    {
        switch (pOpcion)
        {
            case 1:
                registrarUsuario();
                break;
            case 2:
                seleccionarListaUsuarios();
                break;
            case 3:
                //registrarMaterial();
                break;
            case 4:
                //listarMateriales();
                break;
            case 5:
                interfaz.imprimirMensaje( "Fin !!");
                break;
            default:
                interfaz.imprimirMensaje("Opcion inválida");
                break;
        }
    }

    public void registrarUsuario()throws Exception {
        String nombre;
        String apellido;
        interfaz.imprimirMensaje("Digite el nombre del nuevo usuario");
        nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el apellido");
        apellido = interfaz.leerTexto();
        String mensaje = "Seleccione el tipo de usuario que desea registrar: ";
        mensaje+= "1. Administrativo";
        mensaje+= "2. Profesor";
        mensaje+= "3. Estudiante";
        interfaz.imprimirMensaje(mensaje);
        int tipoUsuario = Integer.parseInt(interfaz.leerTexto());
        procesarOpcionUsuario(tipoUsuario, nombre, apellido);
    }

    private void procesarOpcionUsuario(int tipoUsuario, String nombre, String apellido) throws Exception{
        switch (tipoUsuario)
        {
            case 1:
                registrarAdministrativo(nombre, apellido);
                break;
            case 2:
                registrarProfesor(nombre, apellido);
                break;
            case 3:
                registrarEstudiante(nombre, apellido);
                break;
            default:
                interfaz.imprimirMensaje("Opcion inválida");
                break;
        }
    }

    public void registrarAdministrativo(String nombre, String apellido) throws Exception {
        String identificacion;
        String tipoNombramiento;
        int cantHorasAsignadas;
        interfaz.imprimirMensaje("Digite la identificación");
        identificacion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el tipo de nombramiento");
        tipoNombramiento = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite la cantidad de horas asignadas a el nuevo administrativo");
        cantHorasAsignadas = Integer.parseInt(interfaz.leerTexto());
        controllerGestor.registrarAdministativo(nombre, apellido, identificacion, tipoNombramiento, cantHorasAsignadas);
    }

    public void registrarProfesor(String nombre, String apellido) throws Exception {
        String identificacion;
        String tipoContrato;
        LocalDate fechaContratacion;
        interfaz.imprimirMensaje("Digite la identificación");
        identificacion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el tipo de contrato");
        tipoContrato = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite la fecha de contratacion \n");
        interfaz.imprimirMensaje("Digite el año \n");
        int anio = Integer.parseInt(interfaz.leerTexto());
        interfaz.imprimirMensaje("Digite el mes \n");
        int mes = Integer.parseInt(interfaz.leerTexto());
        interfaz.imprimirMensaje("Digite el día \n");
        int dia =Integer.parseInt(interfaz.leerTexto());
        fechaContratacion = LocalDate.now();
        controllerGestor.registrarProfesor(nombre, apellido, identificacion, tipoContrato, fechaContratacion);
    }

    public void registrarEstudiante(String nombre, String apellido) throws Exception {
        int numCarnet;
        String carrera;
        int creditosMatriculados;
        interfaz.imprimirMensaje("Digite el número de carnet");
        numCarnet = Integer.parseInt(interfaz.leerTexto());
        interfaz.imprimirMensaje("Digite la carrera que cursa el estudiante");
        carrera = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite los créditos matriculados \n");
        creditosMatriculados = Integer.parseInt(interfaz.leerTexto());
        controllerGestor.registrarEstudiante(nombre, apellido, numCarnet, carrera, creditosMatriculados);
    }

    public void listarUsuarios(int listaUsuarios) throws Exception{

        switch (listaUsuarios)
        {
            case 1:
                String[] dataAdministrativos = controllerGestor.listarAdministrativo();
                for(String dato: dataAdministrativos){
                    interfaz.imprimirMensaje(dato.toString());
                }
                break;
            case 2:
                String[] dataProfesores = controllerGestor.listarProfesor();
                for(String dato: dataProfesores){
                    interfaz.imprimirMensaje(dato.toString());
                }
                break;
            case 3:
                String[] dataEstudiantes = controllerGestor.listarEstudiante();
                for(String dato: dataEstudiantes){
                    interfaz.imprimirMensaje(dato.toString());
                }
                break;
            default:
                interfaz.imprimirMensaje("Opcion inválida");
                break;
        }
    }

    public void seleccionarListaUsuarios() throws Exception{
        String mensaje = "Seleccione la lista de usuario que desea imprimir: ";
        mensaje+= "1. Administrativo";
        mensaje+= "2. Profesor";
        mensaje+= "3. Estudiante";
        interfaz.imprimirMensaje(mensaje);
        int listaUsuarios = Integer.parseInt(interfaz.leerTexto());
        listarUsuarios(listaUsuarios);
    }
}
