import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private boolean adeudaMaterias;
    private int notaCursoIngreso;
    private boolean abonoMatricula;

    public Alumno(String nombre, String apellido, int edad, boolean adeudaMaterias, int notaCursoIngreso, boolean abonoMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.adeudaMaterias = adeudaMaterias;
        this.notaCursoIngreso = notaCursoIngreso;
        this.abonoMatricula = abonoMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAdeudaMaterias(boolean adeudaMaterias) {
        this.adeudaMaterias = adeudaMaterias;
    }

    public void setNotaCursoIngreso(int notaCursoIngreso) {
        this.notaCursoIngreso = notaCursoIngreso;
    }

    public void setAbonoMatricula(boolean abonoMatricula) {
        this.abonoMatricula = abonoMatricula;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isAdeudaMaterias() {
        return adeudaMaterias;
    }

    public int getNotaCursoIngreso() {
        return notaCursoIngreso;
    }

    public boolean hasAbonoMatricula() {
        return abonoMatricula;
    }

    static List<Alumno> alumnos = new ArrayList<>(
            Arrays.asList(
                    new Alumno("Juan", "Perez", 20, false, 8, true),
                    new Alumno("María", "Gomez", 22, true, 6, false),
                    new Alumno("Carlos", "Lopez", 18, false, 7, true)
            )
    );

    public String toString() {
        return apellido + ", " + nombre + "\t- " + edad + " años";
    }
}