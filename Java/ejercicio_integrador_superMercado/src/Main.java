
import model.Cliente;
import model.Factura;
import model.Mercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Mercado mercado=new Mercado();

        int option=0;
        Scanner teclado = new Scanner(System.in);

        while(option!=5){
            System.out.println("Escriba el numero la accion que desea realizar:");
            System.out.println("1. ver todos los clientes");
            System.out.println("2. borrar un cliente");
            System.out.println("3. buscar un cliente");
            System.out.println("4. crear una factura");
            System.out.println("5. salir");
            option=teclado.nextInt();
            if(option!=5){
                switch (option){
                    case 1:
                        mercado.verClientes();
                        break;
                    case 2:
                        System.out.println("Ingrese el dni de la persona a borrar");
                        Long dniBorrado = teclado.nextLong();
                        mercado.borrarCliente(dniBorrado);
                        break;
                    case 3:
                        System.out.println("Ingrese el dni a buscar");
                        Long dniBuscado = teclado.nextLong();
                        mercado.buscarCliente(dniBuscado);
                        break;
                    case 4:
                        mercado.crearFactura();
                }
            }

        }

    }

}

