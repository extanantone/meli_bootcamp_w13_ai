import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList();
        clientes.add(new Cliente(1234, "pepito", "perez"));
        clientes.add(new Cliente(1235, "pablito", "bochica"));
        clientes.add(new Cliente(1236, "juanito", "redencion"));
        mostrar_clientes(clientes);
        clientes = eliminar_cliente(clientes, 0);
        System.out.println("Digite el dni del cliente que quiere buscar:");
        int dni = scan.nextInt();
        buscar_cliente(clientes, dni);
    }
    public static void mostrar_clientes(ArrayList<Cliente> clientes){
        for (Cliente cl: clientes) {
            System.out.println(cl.toString());
        }
    }
    public static ArrayList<Cliente> eliminar_cliente(ArrayList<Cliente> clientes, int indice){
        clientes.remove(indice);
        mostrar_clientes(clientes);
        return clientes;
    }
    public static void buscar_cliente(ArrayList<Cliente> clientes, int dni){
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
