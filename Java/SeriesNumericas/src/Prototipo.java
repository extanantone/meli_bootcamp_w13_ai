public abstract class Prototipo {

    protected Double valorSerie;
    protected Double valorInicial;

    public Prototipo(Double valorInicial) {
        this.valorInicial = valorInicial;
        this.valorSerie = 0.0;
    }

    public void reiniciarSerie(){
        this.valorSerie = 0.0;
    }

    public void setearValorInicial(Double valorInicial){
        this.valorInicial = valorInicial;
    }

    public abstract Double devolverValorSerie();

}
