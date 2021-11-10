package Reservas;

public class Aereo extends Reserva{

    private String companiaAerea;
    private String origen;
    private String destino;

    public Aereo(double precio, int cantidad, String companiaAerea, String origen, String destino) {
        super(precio, cantidad);
        this.companiaAerea = companiaAerea;
        this.origen = origen;
        this.destino = destino;
    }

    public String getCompaniaAerea() {
        return companiaAerea;
    }

    public void setCompaniaAerea(String companiaAerea) {
        this.companiaAerea = companiaAerea;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Aereo{" +
                "companiaAerea='" + companiaAerea + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
