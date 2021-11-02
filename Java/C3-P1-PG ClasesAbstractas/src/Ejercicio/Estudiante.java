package Ejercicio;

public class Estudiante extends Persona implements Tutor, EstudianteTecnico {
    private String rol;

    public Estudiante() {
        super();
        this.rol= "Estudiante";
    }

    public Estudiante(String nombre, String codigo, String rol) {
        super(nombre, codigo);
        this.rol= rol;
    }

    @Override
    public String dictarClase() {
        if (this.rol.equals("Tutor"))
            return "El estudiante esta habilitado para dictar clases";
        else
            return "Acceso denegado a dictar clases, comuniquese con su administrador.";
    }

    @Override
    public String prestarSoporte() {
        if (this.rol.equals("Tecnico"))
            return "El estudiante esta habilitado para prestar soporte tecnico";
        else
            return "Acceso denegado a prestar soporte, comuniquese con su administrador.";
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "rol='" + rol + '\'' +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
