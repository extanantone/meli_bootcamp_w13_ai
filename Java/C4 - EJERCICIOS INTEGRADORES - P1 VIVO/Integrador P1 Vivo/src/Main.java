import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         Repo repo = new Repo(new ArrayList<>(),new HashMap<>());
         Cliente cliente1 = new Cliente("12345","pepito");
         ///Prueba 1
         Reserva reserva = new Reserva(1,200.0,"Amor","12","13");
         Boleto boleto = new Boleto(1,200.0);
         PackTuristico pack1 = new PackTuristico(List.of(reserva),true,true,List.of(boleto));

         Localizador localizador = AgenciaViajes.localizador(cliente1,pack1,repo);
         System.out.println(localizador);
         ///Prueba 2
         Reserva reserva1 = new Reserva(1,200.0,"Amor","12","13");
         Boleto boleto1 = new Boleto(1,200.0);
         PackTuristico pack2 = new PackTuristico(List.of(reserva,reserva1),true,true,List.of(boleto,boleto1));
         Localizador localizador1 = AgenciaViajes.localizador(cliente1,pack2,repo);
         System.out.println(localizador1);
         ///Prueba 3
         PackTuristico pack3 = new PackTuristico(List.of(reserva),false,false,new ArrayList<>());
         Localizador localizador2 = AgenciaViajes.localizador(cliente1,pack3,repo);
         System.out.println(localizador2);
    }


}
