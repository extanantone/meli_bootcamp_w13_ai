package estructurales.bridge;

import javax.naming.ldap.Control;

public class MainBridge {

    public static void main(String[] args) {
        // creo dispositivos y sus controles

        Radio radio = new Radio();
        Television tv = new Television();
        ControlBasico radioController = new ControlBasico(radio);
        ControlAvanzado tvController = new ControlAvanzado(tv);

        // puedo usar las abstraciones de la jerarquia adyacente para ejecutar las acciones y modificar el estado de los dispostivos

        radio.printStatus();
        radioController.botonPower();
        radioController.canalArriba();
        radio.printStatus();

        tv.printStatus();
        tvController.botonPower();
        tvController.subirVolumen();
        tvController.mute();
        tv.printStatus();

    }
}
