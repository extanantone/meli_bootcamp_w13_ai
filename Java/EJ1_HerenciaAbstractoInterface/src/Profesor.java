public class Profesor {

    private String nombre;
    private String apellido;
    private String lehajo;
    private String materia;

    public Profesor(String nombre, String apellido, String lehajo, String materia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.lehajo = lehajo;
        this.materia = materia;
    }

    public void darClase(){
        System.out.println(this.nombre + " " + this.apellido + " da clase de " + this.materia );
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLehajo() {
        return lehajo;
    }

    public void setLehajo(String lehajo) {
        this.lehajo = lehajo;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", lehajo='" + lehajo + '\'' +
                '}';
    }
}
