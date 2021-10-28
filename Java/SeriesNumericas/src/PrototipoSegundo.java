public class PrototipoSegundo extends Prototipo{

    public static final Double VALOR_1 = 3.0;
    public static final Double VALOR_INCREMENTO = 2.0;

    public PrototipoSegundo(Double valorInicial) {
        super(valorInicial);
    }

    @Override
    public Double devolverValorSerie() {
        if(valorSerie == 0.0)
            return valorSerie = VALOR_1;
        else
            return valorSerie += VALOR_INCREMENTO;
    }
}
