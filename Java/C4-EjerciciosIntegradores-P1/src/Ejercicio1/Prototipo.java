package Ejercicio1;

public abstract class Prototipo {
    private int valor;

    public Prototipo() {

    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public abstract void establecerValor();
    public abstract void valorInicial();
    public abstract void reiniciarSerie();

}
