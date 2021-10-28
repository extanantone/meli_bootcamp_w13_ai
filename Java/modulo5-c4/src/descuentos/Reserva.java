package descuentos;

public class Reserva {
    int tipo;

    public Reserva(int inTipo) {
        this.tipo = inTipo;
    }

    @Override
    public String toString() {
        switch (this.tipo) {
            case 1:
                return "Hotel";
            case 2:
                return "Comida";
            case 3:
                return "Viaje";
            case 4:
                return "Transporte";
            default:
                return "Hotel";
        }
    }
}
