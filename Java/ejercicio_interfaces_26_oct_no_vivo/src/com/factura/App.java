package com.factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.factura.model.Cliente;
import com.factura.model.Factura;
import com.factura.model.Item;

public class App {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan", 10);
        Cliente cliente2 = new Cliente("David", 220);
        Cliente cliente3 = new Cliente("Jorge", 70);
        Factura f = new Factura();
        f.addItem(new Item("Pasta", 100, 2));
        f.addItem(new Item("Salsa de tomate", 20, 20));
        cliente1.addFactura(f);
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        System.out.println(clientes);
        clientes.remove(cliente1);
        System.out.println();
        System.out.println("Remove list");
        System.out.println(clientes);
        System.out.println("Ingrese dni");

        Scanner s = new Scanner(System.in);
        Cliente c= findClienteByDni(clientes,s.nextInt());
        if(c==null) System.out.println("No existe");
        else System.out.println(c);

    }

    public static Cliente findClienteByDni(List<Cliente> clientes,int dni){
        for(Cliente cliente:clientes){
            if(cliente.getDni()==dni) return cliente;
        }
        return null;
    }
}
