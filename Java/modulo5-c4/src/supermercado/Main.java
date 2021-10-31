package supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creando clientes...");
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Hugo","Tominelli", "24535874"));
        clientes.add(new Cliente("Camila","Lao", "11238299"));
        clientes.add(new Cliente("Matias","Sanchez", "32344121"));

        System.out.println("Creados, veamos quienes son:");
        for (Cliente c: clientes) System.out.println(c);

        System.out.println("Saquemos a uno:");
        clientes.remove(2);
        for (Cliente c: clientes) System.out.println(c);

        System.out.println("Ahora ingrese el DNI de alguno de ellos"
                + " y se mostrarán sus datos nuevamente:");
        Scanner entrada = new Scanner(System.in);
        String inDni = entrada.next();
        try {
            Integer dni = Integer.parseInt(inDni);
            boolean clienteEncontrado = false;
            for (Cliente c: clientes) {
                if (dni.equals(Integer.parseInt(c.getDni()))) {
                    System.out.println(c);
                    clienteEncontrado = true;
                }
            }
            if (!clienteEncontrado) {
                System.out.println("Dicho DNI no corresponde con algún cliente de la lista.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Dni inválido");
        }
    }
}
