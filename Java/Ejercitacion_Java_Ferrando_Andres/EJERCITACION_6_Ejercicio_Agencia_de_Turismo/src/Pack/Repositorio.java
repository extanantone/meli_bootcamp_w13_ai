package Pack;

import java.util.ArrayList;

public class Repositorio {

    Cliente cliente;
    ArrayList<Localizador> arrayLocalizador = new ArrayList();

    public Repositorio(Cliente cliente, ArrayList<Localizador> arrayReservas) {
        this.cliente = cliente;
        this.arrayLocalizador = arrayReservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Localizador> getArrayLocalizador() {
        return arrayLocalizador;
    }

    public void setArrayLocalizador(ArrayList<Localizador> arrayLocalizador) {
        this.arrayLocalizador = arrayLocalizador;
    }

    public void agregarLocalizador(Localizador localizador)
    {
        arrayLocalizador.add(localizador);
        System.out.println("Reserva creada y agregada");
    }


}
