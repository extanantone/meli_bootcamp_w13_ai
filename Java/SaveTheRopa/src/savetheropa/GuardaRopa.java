package savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    Integer contador;
    Map<Integer, List<Prenda>> armario;

    public GuardaRopa() {
        this.contador = 0;
        this.armario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        armario.put(contador, listaDePrendas);
        contador ++;
        return contador-1;
    }

    public void mostrarPrendas() {
        for (int i=0; i<contador; i++) {
            System.out.println(i + ": " + armario.get(i));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return armario.get(numero);
    }

}
