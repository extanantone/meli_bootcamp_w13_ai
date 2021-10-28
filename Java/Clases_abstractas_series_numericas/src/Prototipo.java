public abstract class Prototipo {
    private int incremento;
    private int val;
    private int init = 0;

    public int siguiente(){
        val = val + incremento;
        return val;
    }
    public void resetear(){
        this.val = this.init;
    }
    public void iniciarEn(int val){
        this.init = val;
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }
}
