package C4_P2_Vivo_SaveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private int id = 0;
    private Map<Integer, List<Prenda>> map = new HashMap<Integer, List<Prenda>>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        map.put(id, listaDePrenda);
        id++;
        return id - 1;
    }

    public void MostrarPrenda() {
        for (Map.Entry<Integer, List<Prenda>> entry : map.entrySet()) {
            System.out.println("Tú identificador es:");
            System.out.println(entry.getKey());
            System.out.println("Las prendas con ese identificador son: ");
            List<Prenda> prendas = entry.getValue();
            for (Prenda p : prendas) {
                System.out.println(p.toString());
            }
        }
    }
    public List<Prenda> devolverPrendas(int num){
        return this.map.get(num);
    }
}
