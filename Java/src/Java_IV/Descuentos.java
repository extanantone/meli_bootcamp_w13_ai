package Java_IV;

import java.util.ArrayList;

public class Descuentos {
    private RepositorioLocalizadores repoLocalizadores;

    public Descuentos(RepositorioLocalizadores repoLoaclizadores) {
        this.repoLocalizadores = repoLocalizadores;
    }

    public double aplicarDescuentos(Cliente cliente, ArrayList<Reserva> listaReservas){
        double montoFinal = 0;
        return montoFinal;
    }

    private int descuentoPorLocalizadores(double monto, Cliente cliente){
        return repoLocalizadores.getListaLocalizador().stream()
                .reduce(0,(acc,cv)-> cv.getCliente().equals(cliente)? acc+1:acc , Integer::sum)
                > 1 ? 10 : 0;
    }

    private int descuentoPorPaquete(double monto, ArrayList<Reserva> paquete){
        return 0;
    }

    private int descuentoPorDobles(double monto, ArrayList<Reserva> paquete){
        return 0;
    }

}
