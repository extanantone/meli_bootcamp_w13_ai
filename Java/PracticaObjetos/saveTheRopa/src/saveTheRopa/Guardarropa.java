package saveTheRopa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Guardarropa {
	private int contador = 0;
	private Map<Integer,List<Prenda>> prendas;
	
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	public Map<Integer, List<Prenda>> getPrendas() {
		return prendas;
	}
	public void setPrendas(Map<Integer, List<Prenda>> prendas) {
		this.prendas = prendas;
	}
	public Guardarropa() {
		this.prendas = new HashMap<Integer,List<Prenda>>();
	}
	
	public Integer guardarPrendas(List<Prenda> listaDePrenda) {
		prendas.put(++contador, listaDePrenda);
		return contador;
	}
	
	public void mostrarPrendas() {
		for(Integer key : prendas.keySet()) {
			
			List<Prenda> listaPrendas = prendas.get(key);
			listaPrendas.stream()
			.forEach(System.out::println);
		}
	}
	
	public List<Prenda> devolverPrenda(Integer identificador){
		return prendas.remove(identificador);		
	}
	
}
