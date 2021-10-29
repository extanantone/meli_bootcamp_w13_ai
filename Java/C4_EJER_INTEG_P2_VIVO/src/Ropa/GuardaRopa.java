package Ropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GuardaRopa
{
    private int contador;
    private HashMap<Integer, List<Prenda>> prendasDicc;

    public GuardaRopa()
    {
        prendasDicc = new HashMap<>();
    }

    public int getContador()
    {
        return contador;
    }

    public void setContador(int contador)
    {
        this.contador = contador;
    }

    public HashMap<Integer, List<Prenda>> getPrendasDicc()
    {
        return prendasDicc;
    }

    public void setPrendasDicc(HashMap<Integer, List<Prenda>> prendasDicc)
    {
        this.prendasDicc = prendasDicc;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda)
    {
        prendasDicc.put(contador++, listaDePrenda);
        return (contador - 1);
    }

    public void mostrarPrendas()
    {

            prendasDicc.forEach((key, value)->
            {
                System.out.printf("Valor del numero %d\n", key);
                value.forEach(System.out::println);
            });
    }

    public List<Prenda> devolverPrendas(Integer numero)
    {
        return prendasDicc.remove(numero);
    }
}
