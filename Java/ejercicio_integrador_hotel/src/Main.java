import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        Repositorio repostiorio=new Repositorio();

        List<Reserva> plan1=new ArrayList<>();

        Reserva reserva1= new Boleto_viaje(3000,"tokyo","bogota",new Comida(200,"Platino",
                new Transporte(300,"Express",new Reserva_hotel(500, "Hilton", new Paquete_base(1000,"paquete base")))));
        plan1.add(reserva1);

        Viajero viajero1= new Viajero("pepito perez", 23213432);

        Localizador localizador1=new Localizador(viajero1,plan1);
        repostiorio.agregar(localizador1);






        System.out.println(reserva1.getDetalle()+ "; El precio total es de: "+reserva1.getPrecio());
    }
}
