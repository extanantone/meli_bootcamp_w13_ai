import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(123456, "Facundo","Gomez");
        Cliente c2 = new Cliente(654321, "Victoria","Garcia");
        Cliente c3 = new Cliente(123123,"Lionel","Messi");

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);

        for (Cliente c: listaClientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a borrar: ");
        Long dniBorrado = teclado.nextLong();
        boolean bandera = false;
        for (Cliente c : listaClientes){
            if(c.getDni().equals(dniBorrado)){
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if(bandera){
            System.out.println("Se elimino el cliente correctamente");
            for (Cliente c: listaClientes) {
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
            }
        }else{
            System.out.println("No se encontro el cliente a borrar");
        }

        System.out.println("Ingrese el dni de la persona a buscar: ");
        Long dniBuscado = teclado.nextLong();
        bandera = false;
        for (Cliente c : listaClientes){
            if(c.getDni().equals(dniBuscado)){
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                bandera = true;
                break;
            }
        }

        if(!bandera){
            System.out.println("Cliente no encontrado");
        }
    }
}
