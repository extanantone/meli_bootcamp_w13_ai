public abstract class Prototipo {
    private Integer valorInicial;

    public abstract void reiniciar();

    public abstract Integer siguienteValor();

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Integer getValorInicial() {
        return valorInicial;
    }

}
