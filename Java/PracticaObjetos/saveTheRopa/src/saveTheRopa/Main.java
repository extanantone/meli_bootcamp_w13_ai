package saveTheRopa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {		
		List<Prenda> prendas = new ArrayList<Prenda>
		(Arrays.asList(new Prenda("Marca excesivamente cara", "Modelo generico 1"),
		new Prenda("Marca normal", "Modelo generico 2")));
		
		Guardarropa guardarropa = new Guardarropa();
		int miIdentificador = guardarropa.guardarPrendas(prendas);
		
		guardarropa.mostrarPrendas();
		
		guardarropa.devolverPrenda(miIdentificador);
		
		guardarropa.mostrarPrendas();
		
	}

}
