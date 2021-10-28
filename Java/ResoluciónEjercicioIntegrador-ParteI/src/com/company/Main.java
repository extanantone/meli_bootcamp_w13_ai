package com.company;

import com.company.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cliente cliente1 = new Cliente(123456L, "Feli", "Prado");
        Cliente cliente2 = new Cliente(123457L, "Isa", "Burbano");
        Cliente cliente3 = new Cliente(123458L, "Feli", "Cubillos");

        List<Cliente> listClientes = new ArrayList<Cliente>();
        listClientes.add(cliente1);
        listClientes.add(cliente2);
        listClientes.add(cliente3);

        for (Cliente c: listClientes){
            System.out.println("Dni "+ c.getDni() + " Nombre: " + c.getNombre() + " Apellido: " + c.getApellido());
        }

        // borrar
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el DNI a borrar");
        long dniValue = scan.nextLong();
        boolean flag = false;

        for (Cliente c: listClientes){
            if (c.getDni().equals(dniValue)){
                listClientes.remove(c);
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("DNI borrado");
        } else System.out.println("DNI incorrecto");

        for (Cliente c: listClientes){
            System.out.println("Dni "+ c.getDni() + " Nombre: " + c.getNombre() + " Apellido: " + c.getApellido());
        }


        System.out.println("Ingresa el dni que quieras buscar");
        Scanner scanTwo = new Scanner(System.in);

        long dniSearchValue =scanTwo.nextLong();;
        for (Cliente c: listClientes){
            if (c.getDni().equals(dniSearchValue)){
                System.out.println("Cliente encontrado");
                System.out.println("Dni "+c.getDni() + " Nombre:" + c.getNombre() + "Apellido" + c.getApellido());
                break;
            }
        }

        for (Cliente c: listClientes){
            System.out.println("Dni "+ c.getDni() + " Nombre: " + c.getNombre() + " Apellido: " + c.getApellido());
        }



    }
}
