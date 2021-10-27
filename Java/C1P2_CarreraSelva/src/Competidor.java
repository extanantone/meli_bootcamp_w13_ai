public class Competidor {

    int numParticipante;
    int dni;
    String nombre;
    String apellido;
    int edad;
    int celular;
    int numEmerg;
    String gSanguineo;

    public Competidor(int numParticipante, int dni, String nombre, String apellido, int edad, int celular, int numEmerg, String gSanguineo) {
        this.numParticipante = numParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmerg = numEmerg;
        this.gSanguineo = gSanguineo;
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

    public void setNumParticipante(int numParticipante) {
        this.numParticipante = numParticipante;
    }
}
