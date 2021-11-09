import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        this.contador = 1;
        this.prendas = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {

        this.prendas = prendas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){

        this.prendas.put(this.contador, listaDePrenda);
        this.contador = this.contador + 1;

        return this.contador;
    }

    public void mostrarPrendas(){

        for ( Integer id : this.prendas.keySet()){
            System.out.println("Identificador: " + id);
            this.prendas.get(id).stream().forEach(System.out::println);
        }

    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.prendas.get(numero);
    }

}
