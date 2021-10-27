import java.util.*;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente(1234, "pepito", "perez"));
        clientes.add(new Cliente(1235, "pablito", "bochica"));
        clientes.add(new Cliente(1236, "juanito", "redencion"));
        mostrar_clientes(clientes);
        System.out.println("Digite el dni del cliente que quiere borrar:");
        int borrar = scan.nextInt();
        clientes = eliminar_cliente(clientes, borrar);
        System.out.println("Digite el dni del cliente que quiere buscar:");
        int dni = scan.nextInt();
        buscar_cliente(clientes, dni);
    }
    public static void mostrar_clientes(List<Cliente> clientes){
        for (Cliente cl: clientes) {
            System.out.println(cl.toString());
        }
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
