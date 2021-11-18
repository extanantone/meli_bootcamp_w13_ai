package bootcamp;

public interface Imprimible {
    static void imprimir(Imprimible doc){
        doc.imprimir();
    }

    void imprimir();
}
