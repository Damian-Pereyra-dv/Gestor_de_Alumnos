import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class CRUD {

    private static Scanner scanner = new Scanner(System.in);
    static Mensajes mensaje = new Mensajes();


    static void agregarNuevoAlumno() {
        System.out.println("Ingrese los datos del nuevo alumno: \no ingrese 1. para regresar al menu principal: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        if (volverMainMenu(nombre)) return;

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // línea pendiente
        System.out.print("Adeuda materias de secundaria (1- SI/ 2- NO): ");
        int adeudaMateriasOpcion = scanner.nextInt();
        boolean adeudaMaterias = (adeudaMateriasOpcion == 1);
        scanner.nextLine();
        System.out.print("Nota en el curso de ingreso: ");
        int notaCursoIngreso = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Abonó la matrícula (1- SI/ 2- NO): ");
        int adeudaMatriculaOpc = scanner.nextInt();
        boolean abonoMatricula = (adeudaMatriculaOpc == 1);
        scanner.nextLine();

        Alumno nuevoAlumno = new Alumno(nombre, apellido, edad, adeudaMaterias, notaCursoIngreso, abonoMatricula);
        Alumno.alumnos.add(nuevoAlumno);

        System.out.println("Nuevo alumno agregado correctamente.");
    }

    static void darDeBajaAlumno() {
        System.out.print("Ingrese el apellido del alumno que desea dar de BAJA \no ingrese 1. para regresar al menu principal: ");
        String apellido = scanner.nextLine();

        if (volverMainMenu(apellido)) return;

        boolean alumnoEncontrado = false;
        for (Alumno alumno : Alumno.alumnos) {
            if (alumno.getApellido().equalsIgnoreCase(apellido)) {
                Alumno.alumnos.remove(alumno);
                alumnoEncontrado = true;
                System.out.println("Alumno dado de baja correctamente.");
                break;
            }
        }

        if (!alumnoEncontrado) {
            System.out.println(mensaje.notFound);
        }
    }

    static void modificarDatosAlumno() {
        System.out.print("Ingrese el apellido del alumno que desea modificar (ingrese 1 para regresar al menú principal): ");
        String apellido = scanner.nextLine();

        if (volverMainMenu(apellido)) {
            return;
        }

        for (Alumno alumno : Alumno.alumnos) {
            if (alumno.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Ingrese los nuevos datos del alumno:");
                System.out.print("Nombre: ");
                alumno.setNombre(scanner.nextLine());
                System.out.print("Apellido: ");
                alumno.setApellido(scanner.nextLine());
                System.out.print("Edad: ");
                alumno.setEdad(scanner.nextInt());
                scanner.nextLine(); //línea pendiente
                System.out.print("Adeuda materias de secundaria (1-SI / 2-NO): ");
                int adeudaOpcion = scanner.nextInt();
                alumno.setAdeudaMaterias(adeudaOpcion == 1);
                scanner.nextLine();
                System.out.print("Nota en el curso de ingreso: ");
                alumno.setNotaCursoIngreso(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Abonó la matrícula (1-SI/2-NO): ");
                int abonoOpcion = scanner.nextInt();
                alumno.setAbonoMatricula(abonoOpcion == 1);
                scanner.nextLine();

                System.out.println("Datos del alumno modificados correctamente.");
                return;
            }
        }

        System.out.println(mensaje.notFound);
    }

    static void obtenerPromedioEdadAlumnos() {
        if (Alumno.alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            int totalEdades = 0;
            for (Alumno alumno : Alumno.alumnos) {
                totalEdades += alumno.getEdad();
            }
            double promedioEdad = (double) totalEdades / Alumno.alumnos.size();
            System.out.printf("El promedio de edad de los alumnos es: %.2f%n", promedioEdad);
        }
    }

    static void mostrarAlumnosAdeudanMaterias() {
        List<Alumno> alumnosAdeudanMaterias = Alumno.alumnos.stream()
                .filter(Alumno::isAdeudaMaterias).toList();

        if (alumnosAdeudanMaterias.isEmpty()) {
            System.out.println("No hay alumnos que adeuden materias de secundaria.");
        } else {
            System.out.println("Alumnos que adeudan materias de secundaria:");
            for (Alumno alumno : alumnosAdeudanMaterias) {
                System.out.println(alumno.toString());
            }
        }
    }

    static void encontrarAlumnoNotaMasAlta() {
        if (Alumno.alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            Alumno alumnoNotaMasAlta = Alumno.alumnos.stream()
                    .max(Comparator.comparingInt(Alumno::getNotaCursoIngreso))
                    .orElse(null);

            System.out.println("El alumno con la nota más alta en el curso de ingreso es:");
            System.out.println(alumnoNotaMasAlta.toString() + " con " + alumnoNotaMasAlta.getNotaCursoIngreso());
        }
    }

    static void mostrarAlumnosSinAbonoMatricula() {
        List<Alumno> alumnosSinAbonoMatricula = Alumno.alumnos.stream()
                .filter(alumno -> !alumno.hasAbonoMatricula()).toList();

        if (alumnosSinAbonoMatricula.isEmpty()) {
            System.out.println("Todos los alumnos han abonado la matrícula.");
        } else {
            System.out.println("Alumnos que no han abonado la matrícula:");
            for (Alumno alumno : alumnosSinAbonoMatricula) {
                System.out.println(alumno.toString());
            }
        }
    }


    private static boolean volverMainMenu(String apellido) {
        if (apellido.equals("1")) {
            System.out.println("\n\nRegresando al menú principal...");
            return true;
        }
        return false;
    }
    static void mostrarAlumnosOrdenadosPorApellido() {
        if (Alumno.alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            List<Alumno> alumnosOrdenados = new ArrayList<>(Alumno.alumnos);
            alumnosOrdenados.sort(Comparator.comparing(Alumno::getApellido).reversed());
            for (Alumno alumno : alumnosOrdenados) {
                System.out.println(alumno.toString());
            }
        }
    }
}






