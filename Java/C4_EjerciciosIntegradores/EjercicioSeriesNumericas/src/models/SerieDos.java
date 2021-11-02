package models;

public class SerieDos extends Prototipo{
    static Integer aSumar = 2;

    public SerieDos(Integer valorInicio) {
        this.valorInicio = valorInicio;
        valorSerie = valorInicio;
    }

    @Override
    public void valorSiguiente() {
        valorSerie = valorSerie + 2;
    }

}
