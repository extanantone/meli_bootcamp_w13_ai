package supermercado;

import java.util.HashMap;

public class Factura {
    Cliente sujeto;
    HashMap<Item,Integer> items;

    public Factura(Cliente inSujeto) {
        this.sujeto = inSujeto;
    }
}
