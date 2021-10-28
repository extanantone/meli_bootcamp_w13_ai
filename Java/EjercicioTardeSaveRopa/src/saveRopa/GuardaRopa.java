package saveRopa;

import java.util.List;
import java.util.HashMap;

public class GuardaRopa {
    private int contador = 0;
    private HashMap<Integer, List<Prenda>> dicPrendas = new HashMap<>();



    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public HashMap<Integer, List<Prenda>> getListPrendas() {
        return dicPrendas;
    }

    public void setListPrendas(HashMap<Integer, List<Prenda>> listPrendas) {
        this.dicPrendas = listPrendas;
    }

    public int guardarPrendas(List<Prenda> ListPrenda){
       dicPrendas.put(++contador, ListPrenda);
       return contador;
    }

    public void mostrarPrendas(){
        dicPrendas.forEach((k,v) -> System.out.println(k+ "" + v));
    }

    public List<Prenda> devolverPrendas(int numero){
       return dicPrendas.get(numero);
    }
}
