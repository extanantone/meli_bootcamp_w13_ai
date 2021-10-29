package savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> casillero;
    private Integer contador;

    public GuardaRopa() {
        this.casillero = new HashMap<Integer, List<Prenda>>();
        this.contador = 0;
    }

    public Map<Integer, List<Prenda>> getCasillero() {
        return casillero;
    }

    public Integer getContador() {
        return contador;
    }

    public void setCasillero(Map<Integer, List<Prenda>> casillero) {
        this.casillero = casillero;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        this.contador++;
        this.casillero.put(this.contador, listaDePrendas);
        return this.contador;
    }

    public void mostrarPrendas(){
        for(Integer key : this.casillero.keySet()) {
            System.out.println("Para el identificador " + String.valueOf(key) + " existen las prendas:");
            this.casillero.get(key).stream().forEach(System.out::println);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.casillero.remove(numero);
    }
}
