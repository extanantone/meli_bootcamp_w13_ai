import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    private HashMap<Integer, List<Prenda>> lista;

    public GuardaRopa() {
        this.lista = new HashMap<>();
    }

    public GuardaRopa(int contador, HashMap<Integer, List<Prenda>> lista) {
        this.contador = contador;
        this.lista = lista;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public HashMap<Integer, List<Prenda>> getLista() {
        return lista;
    }

    public void setLista(HashMap<Integer, List<Prenda>> lista) {
        this.lista = lista;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        Integer numero = lista.size();
        lista.put(numero + 1, listaDePrendas);
        return numero + 1;
    }

    public void mostrarPrendas(){

        for(Map.Entry<Integer,List<Prenda>> l : lista.entrySet()){
            System.out.printf("Identificador: %d\n", l.getKey());
            l.getValue()
                    .forEach(p -> System.out.printf("Marca: %s, Modelo: %s.\n", p.getMarca(),p.getModelo()));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return lista.get(numero);
    }
}
