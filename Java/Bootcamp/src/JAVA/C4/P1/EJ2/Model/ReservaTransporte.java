package JAVA.C4.P1.EJ2.Model;

public class ReservaTransporte extends Reserva {
    private boolean viajeExterior;

    public ReservaTransporte(int codigo, String nombreEmpresa, int cantidad, boolean viajeExterior) {
        super(codigo, nombreEmpresa, 400, cantidad);
        this.viajeExterior = viajeExterior;
    }

    @Override
    public String toString() {
        return "ReservaTransporte{" +
                "viajeExterior=" + viajeExterior +
                '}';
    }

    public boolean isViajeExterior() {
        return viajeExterior;
    }

    public void setViajeExterior(boolean viajeExterior) {
        this.viajeExterior = viajeExterior;
    }
}
