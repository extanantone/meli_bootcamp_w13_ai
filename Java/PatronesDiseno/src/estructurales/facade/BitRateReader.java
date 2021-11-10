package estructurales.facade;

public class BitRateReader {
    public static ArchivoVideo leer(ArchivoVideo file, Codec codec){
        System.out.println("BitRateReader: leyendo archivo...");
        return file;
    }
    public static ArchivoVideo convertir(ArchivoVideo buffer, Codec codec){
        System.out.println("BitRateReader: escribir archivo...");
        return buffer;
    }

}
