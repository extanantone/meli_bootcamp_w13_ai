package distribuidoraDeProductos;

import java.util.ArrayList;

public class Distribuidora {

	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<>();
		productos.add(new NoPerecedero("Horno",350000,"ElectroDomestico"));
		productos.add(new NoPerecedero("Television",250000,"ElectroDomestico"));
		productos.add(new NoPerecedero("Sofa",15000,"Mueble"));
		productos.add(new NoPerecedero("Mesa",17000,"Mueble"));
		productos.add(new NoPerecedero("Silla",32000,"Mueble"));
		
		productos.add(new Perecedero("Yogurt",350000,2));
		productos.add(new Perecedero("Yogurt 2",350000,4));
		productos.add(new Perecedero("Pan",350000,1));
		productos.add(new Perecedero("Leche",350000,5));
		productos.add(new Perecedero("Leche 2",350000,3));
		
		double sumaProductosNoPerecederos = productos.stream()
				.filter(producto -> producto.getClass() == NoPerecedero.class )
				.mapToDouble(Producto::getPrecio).sum();
        double sumaProductosPerecederos = productos.stream()
        		.filter(producto -> producto.getClass() == Perecedero.class )
        		.mapToDouble(Producto::getPrecio).sum();

	}

}
