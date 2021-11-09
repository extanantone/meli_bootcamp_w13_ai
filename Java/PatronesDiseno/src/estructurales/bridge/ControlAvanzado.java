package estructurales.bridge;

/**
 * como el control avanzado tiene la opcion de mute, sabe que el control basico tiene un device, por lo cual añadir funcionalidades es facil
 *
 */
public class ControlAvanzado extends ControlBasico{

    public ControlAvanzado(Dispositivo device) {
        super(device);
    }

    public void mute(){
        device.setVolumen(0);
    }

}
