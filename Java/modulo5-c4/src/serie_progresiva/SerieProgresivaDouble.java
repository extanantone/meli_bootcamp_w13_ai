package serie_progresiva;

public class SerieProgresivaDouble extends SerieProgresiva<Double>{
    public SerieProgresivaDouble(Double inValorInicial) {
        super(inValorInicial);
    }

    @Override
    public Double siguienteValor() {
        Double siguiente = this.valorInicial + this.valorSerie*this.cantIteraciones;
        this.cantIteraciones++;
        return siguiente;
    }

    @Override
    public void reiniciarSerie() {
        this.cantIteraciones = 0;
    }

    @Override
    public void setValorInicial(Double inValorInicial) {
        this.valorInicial = inValorInicial;
        this.cantIteraciones = 1;
    }
}
