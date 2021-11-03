package SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Integer contador;
    private Map<Integer, List<Prenda>> diccionario;

    public GuardaRopa(){
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }
    public Integer guardarPrendas(List<Prenda> prendasAGuardar){
        Integer sumaPrendas = contador;
        diccionario.put(sumaPrendas, prendasAGuardar);
        contador++;
        return sumaPrendas;
    }

    public List<Prenda> devolverPrendas(Integer numero){

        List<Prenda> prendas = diccionario.remove(numero);
        return prendas;
    }

    public void mostrarPrendas(){
        for (Integer key: diccionario.keySet()){
            List<Prenda> listaDePrendas = diccionario.get(key);
            System.out.println(listaDePrendas);
        }
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }
}
