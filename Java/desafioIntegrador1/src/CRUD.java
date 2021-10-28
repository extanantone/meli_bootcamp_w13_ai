import java.util.List;

public interface CRUD {
    void consultarFacturas();
    void agregarFacturas(Factura factura);
    void eliminarFactura(int idFactura);
    void modificarClienteFactura(int idFactura, Cliente cliente);
    void modificarItemsFactura(int idFactura, List<Item> items);
    void consultarClientes();
    void agregarCLiente(Cliente cLiente);
    void eliminarCliente(int dni);
    void modificarNombreCliente(int dni,String nombre );
    void modificarApellidoCliente(int dni,String nombre );
    void mostrarItemsDeUnaFactura(int codFactura);
    void agregarItemsAUnaFactura(int codFactura, Item item);
    void modificarNombreItemDentroDeUnaFactura(int codFactura, int codItem, String nombre);
    void modificarCantidadItemDentroDeUnaFactura(int codFactura, int codItem, int cantidad);
    void modificarCostoItemDentroDeUnaFactura(int codFactura, int codItem, double costo);
    void eliminarItemDentroDeUnaFactura(int codFactura, int codItem);

}
