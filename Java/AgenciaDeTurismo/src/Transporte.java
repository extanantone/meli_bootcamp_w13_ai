public class Transporte implements Reserva {
    @Override
    public String tipo() {
        return "Transporte";
    }

    @Override
    public double valor() {
        return 100D;
    }

    public Transporte() {
    }
}
