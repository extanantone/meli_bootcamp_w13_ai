public class participante {


    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;
    private  String categoria;


    public participante(String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo, String categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria = categoria;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getDni() {
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
    public String getCelular() {
        return celular;
    }
    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    @Override
    public String toString() {
        return "participante{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", numeroEmergencia='" + numeroEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
