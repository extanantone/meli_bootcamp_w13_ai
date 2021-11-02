package JAVA.C4.EJIN;

import JAVA.C4.EJIN.Model.Cliente;
import JAVA.C4.EJIN.Model.Factura;
import JAVA.C4.EJIN.Model.Item;
import JAVA.C4.EJIN.Repository.ClienteImplementacion;
import JAVA.C4.EJIN.Repository.ItemImplementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EjercicioINC4 {
    public static void main(String[] args) {
        //Parte 1
        //punto 2
        ClienteImplementacion clienteImp = new ClienteImplementacion();
        Cliente c1, c2, c3;
        c1 = new Cliente(39620502, "Marina", "Santiso");
        c2 = new Cliente(39937696, "Fabrizio", "Nuñez");
        c3 = new Cliente(10904766, "Isabel", "Filippi");

        clienteImp.alta(c1);
        clienteImp.alta(c2);
        clienteImp.alta(c3);
        //punto 3
        clienteImp.consultaGeneral();

        //punto 4
        clienteImp.baja(39937696);
        clienteImp.consultaGeneral();

        //punto 5
        Scanner tecla = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea buscar.");
        int dniBusqueda = tecla.nextInt();
        clienteImp.consultaParticular(dniBusqueda);


        //parte 2
        //punto 1
        Cliente c4;
        c4 = new Cliente(34004713, "Melisa", "Santiso");

        //punto 2
        ItemImplementacion itemImp = new ItemImplementacion();
        Item i1, i2;
        i1 = new Item(1, "Manzana", 2, 400.50);
        i2 = new Item(2, "Ciruela", 5, 100);
        itemImp.alta(i1);
        itemImp.alta(i2);

        //punto 3

        Factura f1;
        f1 = new Factura(c1, itemImp.traerLista(), itemImp.costoTotal(itemImp.traerLista()));
        System.out.println(f1);
    }
}
