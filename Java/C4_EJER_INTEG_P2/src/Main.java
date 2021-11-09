import Factura.*;
import Repository.FacturaRepository;
import Repository.ICrudRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static java.util.List.*;

public class Main
{
    public static void main(String[] args)
    {
       FacturaRepository facturaRepository = new FacturaRepository();

       Cliente david = new Cliente(1122121L, "david", "orejuela");

       Item martillo = new Item(1, "Martillo", 2, 100);
       Item taladro = new Item(2, "Taladro", 2, 500);
       Item destornillador = new Item(3, "Destornillador", 1, 50);

       Factura factura = new Factura(1L, david, List.of(martillo, taladro));
       facturaRepository.create(factura);
       factura = new Factura(2L, david, List.of(destornillador));
       facturaRepository.create(factura);

       facturaRepository.readAll();

    }
}
