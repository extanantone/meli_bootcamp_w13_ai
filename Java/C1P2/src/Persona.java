public class Persona {
    private double dni;
    private String nombre;
    private String apellido;
    private int edad;
    private double celular;
    private double numeroEmergencia;
    private String grupoSanguineo;

    public Persona(double dni, String nombre, String apellido, int edad, double celular, double numeroEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public double getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public double getCelular() {
        return celular;
    }

    public double getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
}
