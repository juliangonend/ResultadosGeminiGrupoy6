package EjercicioDificultadMedia_GEMINI;

public class Alumno {
    private String nombre;
    private String apellido;
    private String materiaPrevia;
    private String conducta;

    public Alumno(String nombreCompleto, String materiaPrevia, String conducta) {
        this.nombre = nombreCompleto.split(" ")[0];
        this.apellido = nombreCompleto.split(" ")[1];
        this.materiaPrevia = materiaPrevia;
        this.conducta = conducta;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getMateriaPrevia() {
        return materiaPrevia;
    }

    public String getConducta() {
        return conducta;
    }
}
