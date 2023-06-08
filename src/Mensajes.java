public class Mensajes {
    String menuInicio= """


                ----- Menú Principal -----
                Seleccione una opción:
                a. Mostrar listado de alumnos ordenados alfabéticamente
                b. Obtener promedio de edad de los alumnos
                c. Mostrar alumnos que adeudan materias de secundaria
                d. Encontrar alumno con la nota más alta en el curso de ingreso
                e. Mostrar alumnos que no abonaron la matrícula
                f. Agregar nuevo alumno
                g. Dar de baja a un alumno
                h. Modificar datos de un alumno
                x. Finalizar programa
                ---------------------------
                Opción:\s""";



    String fin ="Programa finalizado.";
    String notFound = "No se encontró ningún alumno con ese apellido.";




public void mostrarMenu (){
    System.out.println(menuInicio);
    }
public String errorMsj (){
       return "Opción no válida. Por favor, elija una opción correcta.";
    }






}
