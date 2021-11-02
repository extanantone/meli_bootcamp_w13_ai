package models;

public abstract class Prototipo {
    Integer valorSerie = -1;
    Integer valorInicio = -1;
    public abstract void valorSiguiente();

    public void reiniciarSerie(){
        valorSerie = valorInicio;
    }
    public void establecerInicio(Integer valorInicial){
        valorInicio = valorInicial;
        valorSerie = valorInicial;
    }

    public Integer mostrarValor(){
        return valorSerie;
    }


}
