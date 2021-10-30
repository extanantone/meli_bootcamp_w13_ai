package Java_IV;

import java.util.ArrayList;

public class Localizador {
    private Cliente cliente;
    private double total = 0;
    private ArrayList<Reserva> listaReservas = new ArrayList<>();

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addReserva(Reserva reserva){
        listaReservas.add(reserva);
        total += reserva.getPrecio();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador:" + "\n" +
                "cliente=" + cliente + "\n" +
                "total=" + total + "\n" +
                "listaReservas=" + listaReservas + "\n"
                ;
    }
}
