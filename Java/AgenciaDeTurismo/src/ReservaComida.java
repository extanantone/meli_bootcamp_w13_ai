public class ReservaComida implements Reserva{
    @Override
    public String tipo() {
        return "ReservaComida";
    }

    @Override
    public double valor() {
        return 100D;
    }
}
