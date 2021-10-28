package supermercadoElEconomico;

import java.util.ArrayList;

public class Factura {
	private Cliente cliente;
	private ArrayList<Item> items;
	private double totalCompra;
	
	public Factura(Cliente cliente, ArrayList<Item> items, double totalCompra) {
		this.cliente = cliente;
		this.items = items;
		this.totalCompra = totalCompra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public double getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}
	
	
	
}
