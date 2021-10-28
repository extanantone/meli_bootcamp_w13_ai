package src.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

private HashMap <Integer, List<Prenda>> ropero;
private static Integer contador=0;
private Integer id;

      public GuardaRopa(){
          this.ropero = new HashMap <Integer, List<Prenda>>();
      }


    public HashMap<Integer, List<Prenda>> getRopero() {
        return ropero;
    }

    public void setRopero(HashMap<Integer, List<Prenda>> ropero) {
        this.ropero = ropero;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer guardarPrendas(List<Prenda> listaDePrenda){

          setContador(++contador);
          ropero.put(getContador(),listaDePrenda);
          return getContador();
      }


    @Override
    public String toString() {
        return "GuardaRopa{" +
                "ropero=" + ropero +
                ", id=" + id +
                '}';
    }

    public void mostrarPrendas(){

        for (Map.Entry<Integer, List<Prenda>> entry : ropero.entrySet() ) {

            System.out.println("El valor de la clave es: " + entry.getKey());
            System.out.println("Las prendas que posee son: ");
            entry.getValue().stream().forEach(System.out::println);
            System.out.println("--------------------------");

        }

    }

    public List<Prenda> devolverPrendas(Integer numero){

          List <Prenda> miPrenda = ropero.get(numero);
          ropero.remove(numero);

          return miPrenda;
    }


}
