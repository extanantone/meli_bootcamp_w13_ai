package ejercicio2;

public class Participante {
    private String nombre;
    private String apellido;
    private Apuntable posecion;
    private int puntaje;

    public Participante() {
    }

    public Participante(String nombre, String apellido, Apuntable posecion, int puntaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posecion = posecion;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Apuntable getPosecion() {
        return posecion;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPosecion(Apuntable posecion) {
        this.posecion = posecion;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
