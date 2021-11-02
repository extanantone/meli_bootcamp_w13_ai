package JAVA.C4.P1.EJ2.Model;

public class ReservaComida extends Reserva {
    private boolean esVegetariano;

    public ReservaComida(int codigo, String nombreEmpresa, int cantidad, boolean esVegetariano) {
        super(codigo, nombreEmpresa, 200, cantidad);
        this.esVegetariano = esVegetariano;
    }

    @Override
    public String toString() {
        return "ReservaComida{" +
                "esVegetariano=" + esVegetariano +
                '}';
    }

    public boolean isEsVegetariano() {
        return esVegetariano;
    }

    public void setEsVegetariano(boolean esVegetariano) {
        this.esVegetariano = esVegetariano;
    }
}
