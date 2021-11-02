import java.util.stream.Collector;

public class AgenciaViajes {
    public static double descuentoTotal(Localizador localizador,Repo repo){
        Double descuentoTotal=0.0;
        Long totalLoca=repo.getLocalizadoresVendidos().stream().filter((x) -> x.getCliente().getDni().equals(localizador.getCliente().getDni())).count();
        if(totalLoca>=2){
            descuentoTotal+=5.0;

        } if(!localizador.getPackTuristicos().getReservas().isEmpty()&&
        !localizador.getPackTuristicos().getBoletos().isEmpty()&&
        localizador.getPackTuristicos().isComida()&&
        localizador.getPackTuristicos().isTrasporte()){
            descuentoTotal+=10;

        }if(localizador.getPackTuristicos().getReservas().size()>=2 || localizador.getPackTuristicos().getBoletos().size()>=2 ){
            descuentoTotal+=5.0;
        }

        return descuentoTotal;


    }
    public static Localizador localizador(Cliente cliente,PackTuristico pack,Repo repo){
        Double totalLocalizador=0.0;
        Double totalReservas=0.0;
        Double totalBoletos=0.0;
        totalReservas = pack.getReservas().stream().mapToDouble(Reserva::getPrecio).sum();
        totalBoletos = pack.getBoletos().stream().mapToDouble(Boleto::getPrecio).sum();
        Localizador localizador = new Localizador(cliente,pack,0.0,totalReservas+totalBoletos);
        localizador.setDescuentoTotal(descuentoTotal(localizador,repo));
        totalLocalizador =(totalBoletos+totalReservas)-((totalBoletos+totalReservas)*localizador.getDescuentoTotal()/100);
        localizador.setValorTotal(totalLocalizador);
        repo.addLocalizadores(localizador);
        repo.addClientes(cliente);
        return  localizador;


    }
}
