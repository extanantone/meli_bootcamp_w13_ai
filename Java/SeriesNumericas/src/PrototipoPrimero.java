public class PrototipoPrimero extends Prototipo{


    public PrototipoPrimero(Double valorInicial) {
        super(valorInicial);
    }

    @Override
    public Double devolverValorSerie(){
        return valorSerie += valorInicial;
    }
}
