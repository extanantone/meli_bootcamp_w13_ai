public class BoletoViaje implements Reserva{
    @Override
    public String tipo() {
        return "BoletoViaje";
    }

    @Override
    public double valor() {
        return 100D;
    }
}
