import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.util.ArrayList;
import java.util.List;

public class mainGuarda {
    public static void main(String[] args){
        GuardaRopa gr = new GuardaRopa();
        List<Prenda> prendas = new ArrayList<>();
        Prenda camiseta = new Prenda("koaj", "spring");
        Prenda chaqueta = new Prenda("cosmos", "rider");
        prendas.add(camiseta);
        prendas.add(chaqueta);
        int codigo = gr.guardarPredas(prendas);
        gr.mostrarPrendas();
        System.out.println("Acabo de reclamar mis prendas guardadas y me devolvieron:");
        System.out.println(gr.devolverPrendas(codigo));
    }
}
