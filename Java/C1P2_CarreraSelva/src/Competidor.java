public class Competidor {

    int numParticipante;
    int dni;
    String nombre;
    String apellido;
    int edad;
    int celular;
    int numEmerg;
    String gSanguineo;
    int pagoInscripcion;

    public Competidor(int dni, String nombre, String apellido, int edad, int celular, int numEmerg, String gSanguineo) {
        this.numParticipante = 0;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmerg = numEmerg;
        this.gSanguineo = gSanguineo;
        this.pagoInscripcion = 0;
    }

    public int getNumParticipante() {
        return numParticipante;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public int getPagoInscripcion() {
        return pagoInscripcion;
    }

    public void setNumParticipante(int numParticipante) {
        this.numParticipante = numParticipante;
    }

    public void setPagoInscripcion(int pagoInscripcion) {
        this.pagoInscripcion = pagoInscripcion;
    }
}
