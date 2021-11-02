import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cliente leo = new Cliente("39931000", "Leo", "Messi");
        Cliente cristiano = new Cliente("39931001", "Cristiano", "Ronaldo");
        Cliente mbappe = new Cliente("39931002", "Kylian", "Mbappe");

        Collection<Cliente> clientes = new ArrayList<>();
        clientes.add(leo);
        clientes.add(cristiano);
        clientes.add(mbappe);

        System.out.println("---Lista completa de clientes-----");
        clientes.stream().forEach(System.out::println);
        System.out.println("----------------------------------\n");


        System.out.println("---Lista de clientes sin cristiano-----");
        clientes.removeIf(cliente -> cliente.getDni().equals("39931001"));
        clientes.stream().forEach(System.out::println);
        System.out.println("----------------------------------");

        System.out.println("Ingrese un dni para buscarlo en la lista");

        Scanner input = new Scanner (System.in);
        String dniSearch = input.nextLine ();

        System.out.println("Cliente con dni "+dniSearch+":");
        Cliente clienteSearch = clientes.stream().filter(cliente -> cliente.getDni().equals(dniSearch)).findAny().orElse(null);
        System.out.println(clienteSearch != null ? clienteSearch : "No se encontro el cliente");

        List<Item> items = new ArrayList<>();
        items.add(new Item("001", "Yerba", 1, 400.0));
        Cliente aguero = new Cliente("39931003", "Sergio", "Aguero");
        Cliente clienteExists = clientes.stream().filter(cliente -> cliente.getDni().equals(aguero.getDni())).findAny().orElse(null);
        if (clienteExists == null) {
            clientes.add(aguero);
        }
        Factura factura = new Factura(leo, items);

        System.out.println("---Lista nueva de clientes-----");
        clientes.stream().forEach(System.out::println);
        System.out.println("----------------------------------\n");
    }
}
