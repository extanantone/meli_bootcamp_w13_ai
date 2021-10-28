package Java_IV_b.GuardaRopa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> diccionario = new HashMap<>();
    private int contador = -1;

    public int guardarPrenda(List<Prenda> listaDePrenda){
        contador++;
        diccionario.put(contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        System.out.println(diccionario);
    }

    public List devolverPrendas(int index){
        return diccionario.remove(index);
    }

    }
