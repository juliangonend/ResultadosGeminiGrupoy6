package EjercicioDificultadMedia_GEMINI;
import java.util.ArrayList;
import java.util.List;

public class AlumnosMateriaConducta {
    public static void main(String[] args) {
        // Crear una lista de alumnos
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Juan Perez", "Matematicas", "Regular"));
        alumnos.add(new Alumno("Maria Gomez", "", "Excelente"));
        alumnos.add(new Alumno("Pedro Lopez", "Fisica", "Regular"));
        alumnos.add(new Alumno("Ana Martinez", "", "Buena"));

        // Mostrar todos los alumnos
        System.out.println("Listado de Alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println("- " + alumno.getNombreCompleto());
        }

        // Mostrar alumnos con materias previas y conducta
        System.out.println("\nListado de Alumnos con Materias Previas y Conducta:");
        for (Alumno alumno : alumnos) {
            if (!alumno.getMateriaPrevia().isEmpty()) {
                System.out.println("- " + alumno.getNombreCompleto() + ": " + alumno.getMateriaPrevia() + " (" + alumno.getConducta() + ")");
            }
        }
    }
}

