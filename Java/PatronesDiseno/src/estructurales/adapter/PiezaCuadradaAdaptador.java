package estructurales.adapter;

public class PiezaCuadradaAdaptador extends PiezaRedonda{

    private PiezaCuadrada pieza;

    public PiezaCuadradaAdaptador(PiezaCuadrada pieza) {
        super(-1);
        this.pieza = pieza;
    }

    // calculo el circulo minimo en el cual el cuadrado podria caber en un hueco
    // retorna un radio equivalente en una peiza redonda
    @Override
    public double getRadio(){
        return Math.sqrt(Math.pow(pieza.getAlto(),2) + Math.pow(pieza.getAlto(),2));
    }


}
