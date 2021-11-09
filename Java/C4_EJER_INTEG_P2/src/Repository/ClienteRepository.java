package Repository;

import Factura.Cliente;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ClienteRepository implements ICrudRepository <Cliente>
{
    private List<Cliente> clienteList;

   public ClienteRepository()
   {
       this.clienteList = new LinkedList<>();
   }
    @Override
    public List<Cliente> readAll()
    {
        return clienteList;
    }

    @Override
    public boolean create(Cliente cliente)
    {
        System.out.println("------------CREANDO-------------");
        System.out.println(cliente);
        clienteList.add(cliente);
        return true;
    }

    @Override
    public Cliente read(Long codigo)
    {
        System.out.println("-----------FACTURAS-------------");
        clienteList.forEach(System.out::println);
        return clienteList.stream().filter((x) -> Objects.equals(x.getDni(), codigo)).findFirst().orElse(null);
    }

    @Override
    public boolean update(Long codigo, Cliente cliente)
    {
        int index;

        System.out.println("----------ACTUALIZANDO-----------");
        Cliente found_cliente = read(codigo);
        System.out.printf("De %s\n", found_cliente);
        System.out.printf("A %s\n", cliente);
        index = clienteList.indexOf(found_cliente);
        clienteList.add(index, cliente);
        return true;
    }

    @Override
    public boolean delete(Long codigo)
    {
        System.out.println("------------BORRANDO-------------");
        Cliente cliente = read(codigo);
        System.out.println(cliente);
        return clienteList.remove(cliente);
    }
}
