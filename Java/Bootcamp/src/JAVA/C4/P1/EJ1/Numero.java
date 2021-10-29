package JAVA.C4.P1.EJ1;

public class Numero extends Prototipo{
    private int numero;

    public void verValorSiguiente(){
        System.out.println(this.valorSiguiente(numero));
    }

    public Numero(int numero) {
        this.valorInicial(numero);
        this.numero=numero;
    }
}
