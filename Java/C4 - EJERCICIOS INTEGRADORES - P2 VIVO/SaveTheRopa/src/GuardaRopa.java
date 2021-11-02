import java.util.*;
import java.util.logging.Level;

public class GuardaRopa {
    private Integer contador;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.contador = 0;
        this.prendas = new HashMap<>();
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        Integer contadorActual = this.contador;
        this.contador++;
        this.prendas.put(contadorActual, listaDePrenda);
        return contadorActual;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> listaPrendas : this.prendas.entrySet()) {
            System.out.println("Id: "+listaPrendas.getKey());
            System.out.println("Prendas: ");
            listaPrendas.getValue().forEach(System.out::println);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendas = this.prendas.remove(numero);
        return prendas;
    }
}
