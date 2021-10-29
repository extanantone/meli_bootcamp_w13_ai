package JAVA.C4.P2.EJ1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador = 0;
    private Map<Integer, List<Prenda>> diccionario = new HashMap<Integer, List<Prenda>>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        diccionario.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entrada : diccionario.entrySet()) {
            Integer clave = entrada.getKey();
            List<Prenda> valor = entrada.getValue();
            System.out.println("Clave: " + clave + "; Prenda: " + valor);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> valor = diccionario.get(numero);
        System.out.println(valor);
        return valor;
    }
}
