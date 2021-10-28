package com.company;

import com.company.Modelo.Cliente;
import com.company.Modelo.Factura;
import com.company.Modelo.Item;
import com.company.Repositorio.ClienteImp;
import com.company.Repositorio.FacturaImp;
import com.company.Repositorio.ItemImp;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClienteImp cliImp = new ClienteImp();
        FacturaImp factImp = new FacturaImp();
        ItemImp itImp = new ItemImp();

        //creamos 3 clientes
        Cliente cli1 = new Cliente(12345678L, "Paula", "Mora");
        Cliente cli2 = new Cliente(87654321L, "Francisco", "Ruiz");
        Cliente cli3 = new Cliente(43215678L, "Eugenia", "Lopez");

        //Creamos 3 Item
        Item item1 = new Item(01L,"Pollo", 2,1500.00);
        Item item2 = new Item(02L,"Carne de Res", 2,2350.00);
        Item item3 = new Item(03L,"Carne de cerdo", 2,3000.00);

        //guardar un cliente
        cliImp.save(cli1);
        cliImp.save(cli2);
        cliImp.save(cli3);
        System.out.println("           Listado de clientes         ");
        cliImp.mostrarPantalla();

        //guardar los item
        itImp.save(item1);
        itImp.save(item2);
        itImp.save(item3);
        System.out.println("           Listado de Items         ");
        itImp.mostrarPantalla();


        //creamos factura para un cliente
        Factura fac1=new Factura(1L,cli1, Collections.singletonList(item1), item1.getCostoUnitario()*item1.getCant());
        Factura fac2=new Factura(2L,cli2, Collections.singletonList(item2), item1.getCostoUnitario()*item1.getCant());
        factImp.save(fac1);
        factImp.save(fac2);
        System.out.println("           Listado de Facturas generadas         ");
        factImp.mostrarPantalla();


        //búsqueda del cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);

        //borrado del cliente
        System.out.println("Ingrese el dni a buscar para eliminar");
        Long dniBorrado = teclado.nextLong();
        cliImp.eliminar(dniBorrado);
    }
}
