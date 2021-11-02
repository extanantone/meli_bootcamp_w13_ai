package ejericiciopractico.integrador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RepoFacturas repoFacturas = new RepoFacturas();
        RepoClientes repoClientes = new RepoClientes();
        RepoItems repoItems = new RepoItems();

        Cliente uno = new Cliente("12345","Jose","Sanchez");
        Cliente dos = new Cliente("12346","Pedro","Sanchez");
        Cliente tres = new Cliente("12347","Ricardo","Sanchez");

        repoClientes.crear(uno);
        repoClientes.crear(dos);
        repoClientes.crear(tres);

        // crear factura integrador parte 2

        Item cosa1 = new Item("1","panelas",2,200.0);

        repoItems.crear(cosa1);

        Factura fact1 = new Factura((long)2021001,uno, List.of(cosa1));

        repoFacturas.crear(fact1);
        repoFacturas.delete(fact1);
        repoClientes.delete(uno);
        repoItems.delete(cosa1);

        repoClientes.consultaGeneral();

        repoFacturas.consultaGeneral();

        repoItems.consultaGeneral();

    }

}
