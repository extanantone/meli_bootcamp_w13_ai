package saveTheRopa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        prendas.put(contador, listaDePrenda);
        Integer clave = contador;
        contador++;
        return clave;
    }

    public void mostrarPrendas() {
        prendas.forEach((id, listaDePrendas) -> {
            String s = "En el lugar " + id +
                    " hay guardadas las siguientes prendas: \n\n";
            for (Prenda p : listaDePrendas) {
                s += p.toString();
            }
        System.out.println(s);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.get(numero);
    }
}
