package Repository;

import Factura.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FacturaRepository implements ICrudRepository <Factura>
{
    List<Factura> facturaList;
    ClienteRepository clienteRepository = new ClienteRepository();

    public FacturaRepository()
    {
        this.facturaList = new LinkedList<>();
    }

    @Override
    public List<Factura> readAll()
    {
        System.out.println("------------TODAS LAS FACTURAS-------------");
        facturaList.forEach(System.out::println);
        return facturaList;
    }

    @Override
    public boolean create(Factura factura)
    {
        System.out.println("------------CREANDO-------------");
        System.out.println(factura);
        if (!clienteRepository.readAll().contains(factura.getCliente()))
        {
            System.out.println("Agregando cliente");
            clienteRepository.create(factura.getCliente());
        }
        facturaList.add(factura);
        return true;
    }

    @Override
    public Factura read(Long codigo)
    {
        System.out.println("-----------FACTURAS-------------");
        return facturaList.stream().filter((x) -> Objects.equals(x.getCodigo(), codigo)).findFirst().orElse(null);
    }

    @Override
    public boolean update(Long codigo, Factura factura)
    {
        int index;

        System.out.println("----------ACTUALIZANDO-----------");
        Factura found_factura = read(codigo);
        System.out.printf("De %s\n", found_factura);
        System.out.printf("A %s\n", factura);
        index = facturaList.indexOf(found_factura);
        facturaList.add(index, factura);
        return true;
    }

    @Override
    public boolean delete(Long codigo)
    {
        System.out.println("------------BORRANDO-------------");
        Factura factura = read(codigo);
        System.out.println(factura);
        return facturaList.remove(factura);
    }
}
