package PM.SaveTheRopa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        prendas.put(contador, listaDePrendas);
        Integer numeroID = contador;
        contador++;
        return numeroID;
    }

    public void mostrarPrendas() {
        for (Integer i : prendas.keySet()) {
            System.out.println("Guardarropa Nº" + i);
            System.out.println("Prendas que Contiene: ");
            for (Prenda p : prendas.get(i)) {
                System.out.println("• " + p.getMarca() + " - " + p.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendasDevueltas = prendas.get(numero);
        prendas.remove(numero);
        return prendasDevueltas;
    }
}