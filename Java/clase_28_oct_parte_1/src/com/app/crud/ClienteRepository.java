package com.app.crud;

import java.util.List;
import java.util.Map;
import com.app.model.Cliente;
import com.app.model.Localizador;

public interface ClienteRepository {
    public void addCliente(Cliente cliente);
    public List<Cliente> getClientes();
    public Cliente getClienteByDni(String dni);
    public void deleteCliente(String dni);
    public List<Localizador> getLocalizadoresByCliente(String dni);
    public int getNumberBoletosVendidos();
    public double getAverageSellers();
    public int getTotalPrice();
    public Map<String,Long> getClasificationByHotelName();
    public Map<String,Long> getClasificationByComida();
    public Map<String,Long> getClasificationByAerolinea();

}
