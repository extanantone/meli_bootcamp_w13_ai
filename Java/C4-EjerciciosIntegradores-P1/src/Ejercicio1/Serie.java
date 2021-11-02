package Ejercicio1;

public class Serie extends Prototipo{
    private int valor;

    public Serie(int valor) {
        super();
        this.valor= valor;
    }

    @Override
    public int getValor() {
        return valor;
    }

    @Override
    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public void establecerValor() {
        this.valor+= super.getValor();
    }

    @Override
    public void valorInicial() {
        super.setValor(valor);
    }

    @Override
    public void reiniciarSerie() {
        this.valor= super.getValor();
    }
}
