package JAVA.C4.P1.EJ2.Model;

public class ReservaBoletoViaje extends Reserva {
    private boolean esPrimeraClase;

    public ReservaBoletoViaje(int codigo, String nombreEmpresa, int cantidad, boolean esPrimeraClase) {
        super(codigo, nombreEmpresa, 100, cantidad);
        this.esPrimeraClase = esPrimeraClase;
    }

    public boolean isEsPrimeraClase() {
        return esPrimeraClase;
    }

    public void setEsPrimeraClase(boolean esPrimeraClase) {
        this.esPrimeraClase = esPrimeraClase;
    }

    @Override
    public String toString() {
        return "ReservaBoletoViaje{" +
                "esPrimeraClase=" + esPrimeraClase +
                '}';
    }
}
