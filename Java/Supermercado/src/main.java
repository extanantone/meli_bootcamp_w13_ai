import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        //Inicializo los clientes.
        Cliente c1 = new Cliente(13445543, "Roberto", "Carlos");
        Cliente c2 = new Cliente(45678543, "Zinedine", "Zidane");
        Cliente c3 = new Cliente(32234765, "Raul", "Gonzalez Blanco");
        List<Cliente> clientList = new java.util.ArrayList<>(List.of(c1, c2, c3));

        //Inicializo los items.
        Item i1 = new Item(1, "Galletitas", 2, 20D);
        Item i2 = new Item(2, "Arroz", 1, 5D);
        Item i3 = new Item(3, "Cerveza", 6, 200D);

        //Inicializo las facturas.
        Factura f1 = new Factura(c1, List.of(i1,i2));
        if( !clientList.contains(f1.getCliente())){
            System.out.println("Cliente no encontrado, agregando a la lista de clientes...");
            clientList.add(f1.getCliente());
        }
        Factura f2 = new Factura(c3, List.of(i1,i3));
        if( !clientList.contains(f2.getCliente())){
            System.out.println("Cliente no encontrado, agregando a la lista de clientes...");
            clientList.add(f1.getCliente());
        }
        List<Factura> facturaList = new ArrayList<>(List.of(f1, f2));



        System.out.println("Se imprimen los clientes: ");
        clientList.forEach(cliente -> System.out.println(cliente.toString()));
        System.out.println("--------------");
        System.out.println("Se imprimen las facturas");
        System.out.println(f1.toString());

        System.out.println("--------------");
        System.out.println("Se elimina un cliente de la lista.");
        clientList.remove(c1);
        System.out.println("--------------");
        System.out.println("Se imprimen los clientes: ");
        clientList.forEach(cliente -> System.out.println(cliente.toString()));



    }


}
