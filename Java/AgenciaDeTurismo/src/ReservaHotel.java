public class ReservaHotel implements Reserva{
    @Override
    public String tipo() {
        return "ReservaHotel";
    }

    @Override
    public double valor() {
        return 100D;
    }
}
