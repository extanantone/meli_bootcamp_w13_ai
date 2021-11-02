package bootcamp;

import bootcamp.modelo.Cliente;
import bootcamp.modelo.Factura;
import bootcamp.modelo.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Supermercado {

    private List<Cliente> clientes;
    private List<Factura> facturas;

    public static void main(String[] args) {

        /*Supermercado superEconomico = new Supermercado(new ArrayList<>(), new ArrayList<>());

        superEconomico.agregarCliente(new Cliente(23445667L, "Roberto", "Perez"));
        superEconomico.agregarCliente(new Cliente(41009007L, "Miguel", "Hernandez"));
        superEconomico.agregarCliente(new Cliente(17333444L, "Antonio", "Delfino"));

        superEconomico.imprimirClientes();

        //borrado de cliente
        System.out.print("Ingrese el DNI del cliente a eliminar: ");
        Scanner scan = new Scanner(System.in);
        Long dni = scan.nextLong();

        Cliente clienteABorrar = superEconomico.buscarCliente(dni);
        if(superEconomico.eliminarCliente(clienteABorrar)){
            System.out.println("Cliente '" + clienteABorrar.getNombre() + " " + clienteABorrar.getApellido() + "' eliminado correctamente");
        } else {
            System.out.println("No se encuentra registrado un cliente con DNI " + dni);
        }

        System.out.println("\n--------------------------\n");
        superEconomico.imprimirClientes();

        //busqueda de cliente
        System.out.print("Ingrese el DNI del cliente a buscar: ");
        dni = scan.nextLong();
        Cliente clienteBuscado = superEconomico.buscarCliente(dni);
        if(clienteBuscado == null){
            System.out.println("No se encuentra el cliente solicitado");
        }else{
            System.out.println("Cliente encontrado, sus datos son:");
            System.out.println(clienteBuscado);
        }*/

       /* List<Item> lista1 = new ArrayList<>();
        lista1.add(new Item(12, "detergente", 3, 55.5));
        lista1.add(new Item(3, "fideos", 1, 44));
        Factura factura = new Factura(new Cliente(12345678L, "Marcos", "Peretti"), lista1, 1L);

        superEconomico.agregarFactura(factura);
        superEconomico.imprimirFacturas();
        superEconomico.imprimirClientes();*/

        Supermercado superEconomico = new Supermercado();

        System.out.println("¡Bienvenidos a Super Economico!");
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("\n");
            System.out.println("Seleccione una acción a realizar:\n"
                                + "1) Buscar cliente \n"
                                + "2) Buscar factura \n"
                                + "3) Eliminar cliente \n"
                                + "4) Eliminar factura \n"
                                + "5) Listar clientes \n"
                                + "6) Listar facturas \n"
                                + "7) Crear cliente \n"
                                + "8) Crear factura \n"
                                + "9) Modificar datos cliente \n"
                                + "10) Modificar datos factura \n"
                                + "11) Salir");
            int entrada = scan.nextInt();
            switch (entrada){
                case 1:
                    System.out.print("Ingrese el DNI del cliente a buscar: ");
                    Long dni = scan.nextLong();
                    Cliente cliente = superEconomico.buscarCliente(dni);
                    if(cliente == null){
                        System.out.println("No se encuentra un cliente con DNI " + dni);
                    }else{
                        System.out.println(cliente);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el ID de la factura a buscar: ");
                    Long id = scan.nextLong();
                    Factura factura = superEconomico.buscarFactura(id);
                    if(factura == null){
                        System.out.println("No se encuentra una factura con ID " + id);
                    }else{
                        System.out.println(factura);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el DNI del cliente a eliminar: ");
                    dni = scan.nextLong();
                    superEconomico.eliminarCliente(dni);
                    break;
                case 4:
                    System.out.print("Ingrese el ID de la factura a eliminar: ");
                    id = scan.nextLong();
                    superEconomico.eliminarFactura(id);
                    break;
                case 5:
                    System.out.println("Lista de clientes:");
                    superEconomico.imprimirClientes();
                    break;
                case 6:
                    System.out.println("Lista de facturas:");
                    superEconomico.imprimirFacturas();
                    break;
                case 7:
                    superEconomico.crearCliente();
                    break;
                case 8:
                    superEconomico.crearFactura();
                    break;
                case 9:
                    System.out.print("Ingrese el DNI del cliente a modificar: ");
                    dni = scan.nextLong();
                    superEconomico.modificarCliente(dni);
                    break;
                case 10:
                    System.out.print("Ingrese el ID de la factura a modificar: ");
                    id = scan.nextLong();
                    scan.nextLine();
                    superEconomico.modificarFactura(id);
                    break;
                case 11:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta");

            }
        }
    }

    public Supermercado(List<Cliente> clientes, List<Factura> facturas) {
        this.clientes = clientes;
        this.facturas = facturas;
    }

    public Supermercado() {
        this.clientes = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura){
        if(buscarCliente(factura.getCliente().getDni()) == null){
            this.clientes.add(factura.getCliente()); //agrega el cliente a la lista de clientes
        }
        factura.calcularCostoTotal();
        this.facturas.add(factura);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void crearFactura(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los datos de la factura:");
        System.out.print("Id: ");
        Long idFactura = scan.nextLong();
        if(buscarFactura(idFactura) != null){
            System.out.println("Ya existe una factura con ID " + idFactura);
            return;
        }
        scan.nextLine(); //consume el \n
        System.out.print("DNI del cliente: ");
        Long dni = scan.nextLong();
        scan.nextLine();
        Cliente cliente = buscarCliente(dni);
        if(cliente == null){
            //si no hay cliente con ese dni registrado, lo creo con todos sus datos
            System.out.println("El cliente con DNI " + dni + " no se encuentra registrado, a continuación deberá crearlo");
            cliente = crearCliente();
        }
        String input;
        List<Item> listaItems = new ArrayList<>();
        do {
            System.out.print("Desea agregar un item? [s/n]: ");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("s")) {
                listaItems.add(crearItem());
            }
        }while(input.equalsIgnoreCase("s"));

        agregarFactura(new Factura(cliente, listaItems, idFactura));
    }

    public Cliente crearCliente(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los siguientes datos del cliente:");
        System.out.print("DNI: ");
        Long dni = scan.nextLong();
        //dni = Long.parseLong(scan.nextLine());
        scan.nextLine(); //consume el \n
        System.out.print("Nombre: ");
        System.out.flush();
        String nombre = scan.nextLine();
        System.out.print("Apellido: ");
        String apellido = scan.nextLine();
        return agregarCliente(dni, nombre, apellido);
    }

    //retorna el nuevo cliente agregado o null si ya existia
    public Cliente agregarCliente(Long dni, String nombre, String apellido){
        Cliente cliente = null;
        if(buscarCliente(dni) == null){
            cliente = new Cliente(dni, nombre, apellido);
            this.clientes.add(cliente);
            System.out.println("Cliente creado correctamente");
        }else{
            System.out.println("Ya existe un cliente con DNI " + dni);
        }
        return cliente;
    }

    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void modificarCliente(Long dni){
        Cliente clienteModificar = buscarCliente(dni);
        if(clienteModificar == null){
            System.out.println("No se encuentra registrado un cliente con DNI " + dni);
        }else{
            Scanner scan = new Scanner(System.in);
            System.out.print("Ingrese el nuevo nombre [0 para no modificar el nombre]: ");
            String nombre = scan.nextLine();
            if(!nombre.equals("0")){
                clienteModificar.setNombre(nombre);
            }
            System.out.print("Ingrese el nuevo apellido [0 para no modificar el apellido]: ");
            String apellido = scan.nextLine();
            if(!apellido.equals("0")){
                clienteModificar.setApellido(apellido);
            }
            System.out.print("Ingrese el nuevo DNI [0 para no modificar el DNI]: ");
            Long dniNuevo = scan.nextLong();
            if(!dniNuevo.equals(0L)){
                clienteModificar.setDni(dniNuevo);
            }
            System.out.println("Cliente modificado correctamente");
        }
    }

    public Item crearItem(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los siguientes datos del Item:");
        System.out.print("Codigo del item: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        System.out.print("Nombre: ");
        System.out.flush();
        String nombre = scan.nextLine();

        System.out.print("Cantidad comprada: ");
        int cant = scan.nextInt();

        System.out.print("Costo unitario: ");
        double costo = scan.nextDouble();

        return new Item(codigo, nombre, cant, costo);
    }

    public void modificarItem(Item item){
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el nuevo codigo: ");
        item.setCodigo(scan.nextInt());
        System.out.print("Ingrese la nueva cantidad comprada: ");
        item.setCantidadComprada(scan.nextInt());
        System.out.print("Ingrese el nuevo costo unitario: ");
        item.setCostoUnitario(scan.nextDouble());
    }

    public void modificarFactura(Long idFactura){
        Factura facturaModificar = buscarFactura(idFactura);
        if(facturaModificar == null){
            System.out.println("No se encuentra una factura con ID " + idFactura);
        }else{
            Scanner scan = new Scanner(System.in);
            System.out.print("Ingrese el DNI del nuevo cliente a asociar a la factura [0 para no modificar el cliente]: ");
            Long dni = scan.nextLong();
            scan.nextLine(); //consume el \n
            if(!dni.equals(0L)){
                Cliente cliente = buscarCliente(dni);
                if(cliente != null){
                    facturaModificar.setCliente(cliente); //asocio factura a otro cliente ya registrado
                }else{
                    System.out.print("El cliente con DNI " + dni + " no se encuentra registrado. ¿Desea crearlo? [s/n]: ");
                    if(scan.nextLine().equalsIgnoreCase("s")){
                        cliente = crearCliente();
                        facturaModificar.setCliente(cliente);
                    }
                }
            }
            System.out.print("Desea modificar alguno de los items? [s/n]: ");
            String input = scan.nextLine();
            if(input.equalsIgnoreCase("s")){
                System.out.print("Ingrese el codigo del item a modificar: ");
                int codigo = scan.nextInt();
                scan.nextLine(); // \n
                Item itemModificar = facturaModificar.buscarItem(codigo);
                if(itemModificar != null){
                    modificarItem(itemModificar); //se modifican los datos de un item
                }else{
                    System.out.println("No se encuentra el item con codigo " + codigo + " en la factura ID " + idFactura);
                }
            }
            System.out.print("Desea agregar nuevos items? [s/n]: ");
            input = scan.nextLine();
            if(input.equalsIgnoreCase("s")){
                System.out.println("Ingrese uno a uno los datos de cada item");
                do{
                   facturaModificar.getListaItems().add(crearItem());
                    System.out.print("Finalizar? [s/n]: ");
                }while(scan.nextLine().equalsIgnoreCase("n"));
            }
            System.out.print("Ingrese el nuevo ID [0 para no modificar el ID]:");
            Long idNuevo = scan.nextLong();
            scan.nextLine(); //saca el \n
            if(!idNuevo.equals(0L)){
                facturaModificar.setId(idNuevo);
            }
            facturaModificar.calcularCostoTotal(); //se recalcula el costo total
            System.out.println("Factura modificada correctamente");
        }
    }

    public void eliminarFactura(Long idFactura){
        Factura factura = buscarFactura(idFactura);
        if(factura == null){
            System.out.println("No se encuentra una factura con ID " + idFactura + " registrada");
        }else{
            this.facturas.remove(factura);
            System.out.println("Factura " + factura.getId() + " eliminada correctamente");
        }
    }

    public void eliminarCliente(Long dni){
        Cliente cliente = buscarCliente(dni);
        if(cliente == null){
            System.out.println("No se encuentra un cliente con DNI " + dni + " registrado");
        }else{
            eliminarCliente(cliente); //elimino el primero ya que debe ser solo 1 cliente
            System.out.println("Cliente " + cliente + " eliminado correctamente");
        }
    }

    //elimina un cliente de la lista, retorna true si existia tal cliente
    public boolean eliminarCliente(Cliente cliente){
        return this.clientes.remove(cliente);
    }

    public void imprimirClientes(){
        for(Cliente cli : this.clientes) {
            System.out.println(cli);
        }
    }

    public void imprimirFacturas(){
        for(Factura fact : this.facturas) {
            System.out.println(fact);
        }
    }

    //retrona null si el cliente no se encuentra
    public Cliente buscarCliente(Long dni){
        List<Cliente> listaClientes;
        listaClientes = this.clientes.stream().filter((x) -> x.getDni().equals(dni)).collect(Collectors.toList());
        Cliente clienteRet = (listaClientes.size() == 0)? null : listaClientes.get(0);
        return clienteRet;
    }

    //retorna null si no hay una factura con tal id
    public Factura buscarFactura(Long idFactura){
        List<Factura> listaFacturas;
        listaFacturas = this.facturas.stream().filter((x) -> x.getId().equals(idFactura)).collect(Collectors.toList());
        Factura facturaRet = (listaFacturas.size() == 0)? null : listaFacturas.get(0);
        return facturaRet;
    }
}
