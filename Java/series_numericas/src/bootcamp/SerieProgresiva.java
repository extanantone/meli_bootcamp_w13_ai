package bootcamp;

public abstract class SerieProgresiva <T extends Number>{

    protected T valorInicial;
    protected T valorActual;

    public SerieProgresiva(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial; //al principio el valor actual es igual al inicial, empieza la cuenta
    }

    public abstract T getValorSiguiente();

    public void reiniciarSerie(){
        this.valorActual = this.valorInicial;
    }

    public void setValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
    }

}
