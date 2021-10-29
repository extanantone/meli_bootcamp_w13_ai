import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int id;
    private HashMap<Integer,List<Prenda>> diccionario;

    public GuardaRopa() {
        this.id = 0;
        this.diccionario = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrenda(List<Prenda> listaDePrenda){
        id++;
        this.diccionario.put(id,listaDePrenda);
        return id;
    }

    public void mostrarPrendas(){
        if (diccionario.size() == 0){
            System.out.println("No hay prendas");
        }else {
            for(Map.Entry<Integer,List<Prenda>> p: diccionario.entrySet()){
                Integer key = p.getKey();
                List<Prenda> prenda = p.getValue();
                System.out.println("El identificador es: " + key);
                prenda.stream().forEach(ropa -> System.out.println(ropa.toString()));
                System.out.println('\n');
            }
        }

    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> lista = diccionario.get(numero);
        diccionario.remove(numero);
        return  lista;
    }
}
