package EjercicioDificultadMedia_ChatGPT;
import java.util.ArrayList;
public class BusquedaAlumno {
    public static void main(String[] args) {
        // Crear una lista de alumnos
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("Juan", "Perez", true, "Buena"));
        listaAlumnos.add(new Alumno("Maria", "Gomez", false, "Regular"));
        listaAlumnos.add(new Alumno("Pedro", "Lopez", true, "Excelente"));
        listaAlumnos.add(new Alumno("Ana", "Martinez", false, "Buena"));

        // Mostrar todos los alumnos
        System.out.println("Todos los alumnos:");
        for (Alumno alumno : listaAlumnos) {
            System.out.println("Nombre: " + alumno.nombre + ", Apellido: " + alumno.apellido);
        }

        // Mostrar alumnos con materias previas y su conducta
        System.out.println("\nAlumnos con materias previas y su conducta:");
        for (Alumno alumno : listaAlumnos) {
            if (alumno.materiasPrevias) {
                System.out.println("Nombre: " + alumno.nombre + ", Apellido: " + alumno.apellido);
                System.out.println("Conducta: " + alumno.conducta + "\n");
            }
        }
    }
    }

