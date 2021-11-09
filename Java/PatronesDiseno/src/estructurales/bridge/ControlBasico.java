package estructurales.bridge;

/**
 * El control implementado podra estar disponible para cualquier dispositivo
 * y de este control basico pueden heredar muchos mas complejos que usen las actividades basicas de este
 * el control sabe como trabajar con cualquier dispositivo gracias a la interface de dispositivos
 * El puente es segun mi opinion el uso del device en el control implementado, es el que permite usar los emtodos de las implementaciones de las clases en acciones mas completas
 * o agrupadas. EL PUENTE ES LA AGREGACION DEL DISPOSITIVO
 */
public class ControlBasico implements Controles{

    protected Dispositivo device;

    public ControlBasico(Dispositivo device) {
        this.device = device;
    }

    @Override
    public void botonPower() {
        if(device.isEncendido())
            device.desActivar();
        else
            device.activar();
    }

    @Override
    public void subirVolumen() {
        device.setVolumen(device.getVolumen()+1);
    }

    @Override
    public void bajarVolumen() {
        device.setVolumen(device.getVolumen()-1);
    }

    @Override
    public void canalArriba() {
        device.setCanal(device.getCanal()+1);
    }

    @Override
    public void canalAbajo() {
        device.setCanal(device.getCanal()-1);
    }
}
