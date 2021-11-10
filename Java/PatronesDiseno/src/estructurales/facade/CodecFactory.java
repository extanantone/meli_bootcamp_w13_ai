package estructurales.facade;

public class CodecFactory {

    public static Codec extraer(ArchivoVideo file){
        String tipo = file.getTipoCodec();
        if(tipo.equals("mp4"))
        {
            System.out.println("CodecFactory: extrayendo mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else
        {
            System.out.println("CodecFactory: extrayendo OGG audio...");
            return new OggCompresionCodec();
        }
    }
}
