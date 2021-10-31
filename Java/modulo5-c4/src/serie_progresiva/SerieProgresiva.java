package serie_progresiva;

public abstract class SerieProgresiva<T extends Number> {
    protected T valorInicial;
    protected Integer cantIteraciones;
    protected T valorSerie;

    public SerieProgresiva(T inValorInicial) {
        this.valorInicial = inValorInicial;
        this.valorSerie = inValorInicial;
        this.cantIteraciones = 0;
    }

    public abstract T siguienteValor();
    public abstract void reiniciarSerie();
    public abstract void setValorInicial(T inValorInicial);
}
