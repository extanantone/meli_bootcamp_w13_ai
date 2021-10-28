import java.util.*;

public class main {
    public static void main(String[] args){
        int idFactura=111;
        Map<Integer, Factura> facturas = new HashMap<Integer, Factura>();
        Scanner scan = new Scanner(System.in);
        List<Cliente> clientes= new ArrayList<>();
        List<Item>items = new ArrayList<Item>();

        Cliente perenjito = new Cliente(1237, "perenjito", "suarez");
        clientes.add(new Cliente(1234, "pepito", "perez"));
        clientes.add(new Cliente(1235, "pablito", "bochica"));
        clientes.add(new Cliente(1236, "juanito", "redencion"));
        clientes.add(perenjito);
        mostrar_clientes(clientes);
        System.out.println("Digite el dni del cliente que quiere borrar:");
        int borrar = scan.nextInt();
        clientes = eliminar_cliente(clientes, borrar);
        System.out.println("Digite el dni del cliente que quiere buscar:");
        int dni = scan.nextInt();
        buscar_cliente(clientes, dni);

        items.add(new Item(123, "pepino", 2, 1500));
        items.add(new Item(124, "banano", 4, 2500));
        Factura factura = crearFactura(perenjito, items);
        boolean flag=verificarFactura(factura, clientes);
        if (flag){
            facturas.put(idFactura, factura);
            idFactura+=1;
            for (Map.Entry<Integer, Factura> entry : facturas.entrySet()) {
                System.out.println("Número de factura: "+ entry.getKey());
                System.out.println("Datos del cliente: "+entry.getValue().getCliente().toString());
                System.out.println("Los items en la factura son: ");
                List<Item> auxiliar= entry.getValue().getItems();
                for (Item ite : auxiliar) {
                    System.out.println(ite.toString());
                }
                System.out.println("El total es: $"+entry.getValue().getTotal());
            }
        }else{
            System.out.println("El usuario no está registrado por tanto no se puede guardar la factura.");
        }

    }
    public static Factura crearFactura(Cliente cliente, List<Item>items){
        double total=0;
        for (Item it: items) {
            total+= it.getCosto();
        }
        Factura fac = new Factura(cliente, items, total);
        return fac;
    }
    public static void mostrar_clientes(List<Cliente> clientes){
        for (Cliente cl: clientes) {
            System.out.println(cl.toString());
        }
    }
    public static boolean verificarFactura(Factura factura, List<Cliente> clientes){
        int  dni=factura.getCliente().getDni();
        boolean ep=false;
        for (Cliente cl: clientes) {
            if(cl.getDni()==dni){
                 ep=true;
            }
        }
        return ep;
    }
    public static List<Cliente> eliminar_cliente(List<Cliente> clientes, int dni){
        int i=0;
        boolean flag = false;
        for (Cliente cl: clientes) {
            if(cl.getDni()==dni){
                clientes.remove(i);
                flag=true;
                System.out.println("Se eliminó con exito");
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("El cliente no existe");
        }
        mostrar_clientes(clientes);
        return clientes;
    }
    public static void buscar_cliente(List<Cliente> clientes, int dni){
        boolean flag=false;
        for (Cliente cl: clientes) {
            if(cl.getDni()==dni){
                System.out.println(String.format("Los datos del cliente que solicito son: Nombre -> %s, Apellido -> %s, DNI -> %d", cl.getNombre(), cl.getApellido(), cl.getDni()));
                flag = true;
            }
        }
        if(!flag){
            System.out.println("El cliente no existe");
        }
    }

}
