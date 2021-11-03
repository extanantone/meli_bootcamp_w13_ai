import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    HashMap<Integer, List<Prenda>> diccionario = new HashMap<>();
    int contador = 0;



    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(contador,listaDePrenda);
        contador += 1;
        return contador;
    }
    public void mostrarPrendas(){
        System.out.println(Arrays.asList(diccionario));
    }


    public GuardaRopa() {

    }


    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


}
