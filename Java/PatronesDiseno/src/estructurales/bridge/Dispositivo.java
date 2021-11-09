package estructurales.bridge;

public interface Dispositivo {

    public boolean isEncendido();
    public void activar();
    public void desActivar();
    public int getVolumen();
    public void setVolumen(int valor);
    public int getCanal();
    public void setCanal(int canal);
    public void printStatus();

}
