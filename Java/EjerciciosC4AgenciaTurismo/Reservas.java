package Ejercicio1AgenciaTurismo;

public enum Reservas {

    BOLETOS(500.0),
    HOTEL(200.0),
    COMIDA(100.0),
    TRANSPORTE(50.0);

    private double costoDia;

    private Reservas(double costoDia ){
        this.costoDia = costoDia;
    }

    public double getCostoDia() {
        return costoDia;
    }
}
