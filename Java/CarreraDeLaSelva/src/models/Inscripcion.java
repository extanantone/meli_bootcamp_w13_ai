package models;

public class Inscripcion {


    public static final int CIRCUITO_CHICO = 1;
    public static final int CIRCUITO_MEDIO = 2;
    public static final int CIRCUITO_AVANZADO = 3;

    public int numeroInscripcion;
    public int montoInscripcion;
    public Persona participante;
    public int circuitoID;


    public Inscripcion(int numeroInscripcion, int circuitoID , Persona participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.montoInscripcion = calcularMontoInscripcion(circuitoID,participante.getEdad());
        this.participante = participante;
        this.circuitoID = circuitoID;
    }

    /*public Inscripcion(int numeroInscripcion, int circuitoID ) {
        this.numeroInscripcion = numeroInscripcion;
        this.montoInscripcion = calcularMontoInscripcion(circuitoID,participante.getEdad());
        this.circuitoID = circuitoID;
    }*/

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public int getMontoInscripcion() {
        return montoInscripcion;
    }

    public void setMontoInscripcion(int montoInscripcion) {
        this.montoInscripcion = montoInscripcion;
    }

    public Persona getParticipante() {
        return participante;
    }

    public void setParticipante(Persona participante) {
        this.participante = participante;
    }


    public int calcularMontoInscripcion(int circuitoID, int edad) {

        switch (circuitoID){

            case CIRCUITO_CHICO:
                return edad>18? 1500:1300;

            case CIRCUITO_MEDIO:
                return edad>18? 2000:2300;

            case CIRCUITO_AVANZADO:
                return  2800;

        }

    return 0;

    }


}
