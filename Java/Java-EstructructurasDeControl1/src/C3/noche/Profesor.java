package C3.noche;

public class Profesor extends Persona {

    private int numeroContrato;

    public Profesor(String nombre, String dni, int numeroContrato) {
        super(nombre, dni);
        this.numeroContrato = numeroContrato;
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    @Override
    public String saludar() {
        return "Hola mi nombre es "+getNombre()+" y soy profesor";
    }
}
