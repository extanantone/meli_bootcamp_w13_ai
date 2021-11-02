import java.util.List;

public class PackTuristico {
    private List<Reserva> reservas;
    private boolean comida;
    private boolean trasporte;
    private List<Boleto> boletos;

    public PackTuristico(List<Reserva> reservas, boolean comida, boolean trasporte, List<Boleto> boletos) {
        this.reservas = reservas;
        this.comida = comida;
        this.trasporte = trasporte;
        this.boletos = boletos;
    }

    @Override
    public String toString() {
        return "Reservas: \n" + this.reservas +"\n"+
                "Comida: "+ (this.comida ? "Si" : "No") +"\n"+
                "Transporte: "+ (this.trasporte ? "Si" : "No") +"\n"+
                "Boletos: " + this.boletos+"\n";
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isTrasporte() {
        return trasporte;
    }

    public void setTrasporte(boolean trasporte) {
        this.trasporte = trasporte;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
}
