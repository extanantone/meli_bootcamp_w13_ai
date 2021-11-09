package estructurales.bridge;

public class Radio implements Dispositivo{

    private boolean encendido;
    private int volumen = 0;
    private int emisora = 0;

    @Override
    public boolean isEncendido() {
        return encendido;
    }

    @Override
    public void activar() {
        encendido = true;
    }

    @Override
    public void desActivar() {
        encendido = false;
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public void setVolumen(int valor) {
        volumen = valor;

    }

    @Override
    public int getCanal() {
        return emisora;
    }

    @Override
    public void setCanal(int canal) {
        emisora = canal;
    }

    @Override
    public void printStatus() {
        System.out.printf("estado de la radio: %s, volumen; %d, emisora: %d. \n",encendido,volumen,emisora);

    }
}
