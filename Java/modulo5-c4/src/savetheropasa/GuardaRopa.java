package savetheropasa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    HashMap<Integer, List<Prenda>> prendas;
    Integer contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.contador++;
        prendas.put(this.contador, listaDePrenda);
        return this.contador;
    }

    public void mostrarPrendas() {
        for (Integer id: this.prendas.keySet()) {
            System.out.println(String.format("Lista: %d", id));
            for (Prenda p : this.prendas.get(id)) System.out.println(p);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.prendas.remove(numero);
    }
}
