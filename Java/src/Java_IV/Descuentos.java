package Java_IV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Descuentos {
    private RepositorioLocalizadores repoLocalizadores;

    public Descuentos(RepositorioLocalizadores repoLoaclizadores) {
        this.repoLocalizadores = repoLocalizadores;
    }

    public double aplicarDescuentos(Cliente cliente, ArrayList<Reserva> listaReservas){
        double montoFinal = 0;
        return montoFinal;
    }

    private int descuentoPorLocalizadores(Cliente cliente){
        return repoLocalizadores.getListaLocalizador().stream()
                .reduce(0,(acc,cv)-> cv.getCliente().equals(cliente)? acc+1:acc , Integer::sum)
                > 1 ? 10 : 0;
    }

    private int descuentoPorPaquete(ArrayList<Reserva> paquete){
        List<TipoReserva> listaPaqueteCompleto = Arrays.asList(TipoReserva.values());
        for (Reserva cv : paquete) {
            listaPaqueteCompleto.removeIf(tipo -> tipo.equals(cv.getTipo()));
        }
        return listaPaqueteCompleto.size() == 0? 10 : 0;
    }

    private int descuentoPorDobles(double monto, ArrayList<Reserva> paquete){
        return 0;
    }

}
