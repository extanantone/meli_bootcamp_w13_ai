public abstract class Prototipo <T extends Number>{
    protected T valor_inicial;
    protected T valor_serie;
    protected T valor_actual;

    abstract T siguiente();

    abstract void reiniciar();

    abstract void valorInicial(T valor_inicial);
}
