package com.company;

import com.company.model.Cliente;
import com.company.repository.ClientImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ClientImp clientManager = new ClientImp();

        Cliente cliente1 = new Cliente(123456L, "Feli", "Prado");
        Cliente cliente2 = new Cliente(123457L, "Isa", "Burbano");
        Cliente cliente3 = new Cliente(123458L, "Feli", "Cubillos");


        clientManager.save(cliente1);
        clientManager.save(cliente2);
        clientManager.save(cliente3);

        clientManager.view();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el DNI a buscar");
        long dniSearchValue = scan.nextLong();
        clientManager.search(dniSearchValue);
        System.out.println("Ingresa el DNI a buscar");
        long dniValue = scan.nextLong();
        clientManager.delete(dniValue);







    }
}
