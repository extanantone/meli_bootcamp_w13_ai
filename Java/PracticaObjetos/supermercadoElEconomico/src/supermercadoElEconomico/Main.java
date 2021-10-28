package supermercadoElEconomico;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void imprimirClientes(ArrayList<Cliente>clientes) {
		clientes.stream()
		.forEach(c -> System.out.println(c.toString()));
		System.out.println("");
	}
	
	public static Cliente buscarCliente(ArrayList<Cliente>clientes, int dni) {
		return
		clientes.stream()
		.filter(c -> c.getDni() == dni)
		.findFirst().orElse(null);
	}
	
	public static void main(String[] args) {
		ArrayList<Cliente> clientesPrueba = new ArrayList<>();
		Cliente cliente1 = new Cliente("Jorge", "Perez", 123415);
		Cliente cliente2 = new Cliente("Maria", "Gutierrez", 345213);
		Cliente cliente3 = new Cliente("Carmen", "Lopez", 415134);
		clientesPrueba.add(cliente1);
		clientesPrueba.add(cliente2);
		clientesPrueba.add(cliente3);
		imprimirClientes(clientesPrueba);
		//Buscaremos a Maria por su DNI y la eliminaremos
		Cliente clienteBuscado = buscarCliente(clientesPrueba,345213);
		clientesPrueba.remove(clienteBuscado);
		imprimirClientes(clientesPrueba);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese dni del cliente a buscar: ");
		int dni = sc.nextInt();
		clienteBuscado = buscarCliente(clientesPrueba,dni);
		if(clienteBuscado != null) {
			System.out.println(clienteBuscado.toString());
		}
		else {
			System.out.println("El cliente no se encuentra registrado");
		}
		sc.close();
		
	}
}