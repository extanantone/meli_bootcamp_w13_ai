package ejercicio1;

public class Profesor implements Teaches {
    private String nombre;
    private String apellido;
    private String departamento;

    public Profesor(String nombre, String apellido, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void ensenar() {
        System.out.println("Esta enseñando el profesor " + nombre + apellido);
    }
}
