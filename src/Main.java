import java.util.*;


public class Main {
    /**
     * agrego alumnos por defecto para tener con que interactuar, se puede agregar mas
     */



    private static Scanner scanner = new Scanner(System.in);
    static Mensajes mensajes = new Mensajes();


    public static void main(String[] args) {

        boolean finalizado = false;

        while (!finalizado) {
            mensajes.mostrarMenu();
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "a" -> CRUD.mostrarAlumnosOrdenadosPorApellido();
                case "b" -> CRUD.obtenerPromedioEdadAlumnos();
                case "c" -> CRUD.mostrarAlumnosAdeudanMaterias();
                case "d" -> CRUD.encontrarAlumnoNotaMasAlta();
                case "e" -> CRUD.mostrarAlumnosSinAbonoMatricula();
                case "f" -> CRUD.agregarNuevoAlumno();
                case "g" -> CRUD.darDeBajaAlumno();
                case "h" -> CRUD.modificarDatosAlumno();
                case "x" -> finalizado = true;
                default -> System.out.println(mensajes.errorMsj());

            }
        }

        scanner.close();
        System.out.println(mensajes.fin);
    }













}







