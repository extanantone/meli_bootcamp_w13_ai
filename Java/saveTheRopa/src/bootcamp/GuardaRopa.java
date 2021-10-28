package bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaropa;
    private Integer contadorId;

    public GuardaRopa(Map<Integer, List<Prenda>> guardaropa, Integer contadorId) {
        this.guardaropa = guardaropa;
        this.contadorId = contadorId;
    }

    public GuardaRopa() {
        this.guardaropa = new HashMap<>();
        this.contadorId = 0;
    }

    public Map<Integer, List<Prenda>> getGuardaropa() {
        return guardaropa;
    }

    public void setGuardaropa(Map<Integer, List<Prenda>> guardaropa) {
        this.guardaropa = guardaropa;
    }

    public Integer getContador() {
        return contadorId;
    }

    public void setContador(Integer contadorId) {
        this.contadorId = contadorId;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.contadorId += 1;
        this.guardaropa.put(this.contadorId, listaDePrenda);
        return this.contadorId;
    }

    public void mostrarPrendas(){
        for (Map.Entry prendas : this.guardaropa.entrySet()) {
            List<Prenda> ropa = (List<Prenda>) prendas.getValue();
            String salida = "Id: " + prendas.getKey() + " | Prendas: " + ropa.stream().map(x -> x.toString()).collect(Collectors.joining(","));
            System.out.println(salida);
        }
    }

    //retorna la lista de prendas asociada a tal clave o id, o null si no hay
    public List<Prenda> devolverPrendas(Integer numero){
        return this.guardaropa.remove(numero);
    }
}
