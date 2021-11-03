package AgenciaDeTurismo;

public class Reserva {
    int tipo;

    public Reserva(int tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        switch (this.tipo) {
            case 1:
                return "Hotel";
            case 2:
                return "comida";
            case 3:
                return "viaje";
            case 4:
                return "Transporte";
            default:
                return "Hotel";

        }
    }
}
