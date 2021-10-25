public class Participante {
    int dni;
    String nombre;
    String apellido;
    int edad;
    long celular;
    long emergencia;
    String sanguineo;

    public Participante(int dni, String nombre, String apellido, int edad,
                        long celular, long emergencia, String grupo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.emergencia = emergencia;
        this.sanguineo = grupo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public long getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(long numero) {
        this.emergencia = numero;
    }

    public String getSanguineo() {
        return sanguineo;
    }

    public void setSanguineo(String grupo) {
        this.sanguineo = grupo;
    }

    public void showParticipante() {
        System.out.println("\tDNI: " + this.getDni());
        System.out.println("\tNombre: " + this.getNombre());
        System.out.println("\tApellido: " + this.getApellido());
        System.out.println("\tEdad: " + this.getEdad());
        System.out.println("\tCelular: " + this.getCelular());
        System.out.println("\tNúmero de emergencia: " + this.getEmergencia());
        System.out.println("\tGrupo sanguíneo: " + this.getSanguineo());

    }
}
