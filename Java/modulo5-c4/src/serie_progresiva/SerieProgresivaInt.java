package serie_progresiva;

public class SerieProgresivaInt extends SerieProgresiva<Integer>{
    public SerieProgresivaInt(Integer inValorInicial) {
        super(inValorInicial);
    }

    @Override
    public Integer siguienteValor() {
        Integer siguiente = this.valorInicial + this.valorSerie*this.cantIteraciones;
        this.cantIteraciones++;
        return siguiente;
    }

    @Override
    public void reiniciarSerie() {
        this.cantIteraciones = 0;
    }

    @Override
    public void setValorInicial(Integer inValorInicial) {
        this.valorInicial = inValorInicial;
        this.cantIteraciones = 1;
    }
}
