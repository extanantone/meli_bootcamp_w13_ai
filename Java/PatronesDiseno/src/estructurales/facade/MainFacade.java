package estructurales.facade;

import java.io.File;

public class MainFacade {
    public static void main(String[] args) {
        VideoConversionFacade convertidorFachada = new VideoConversionFacade();
        File mp4Video = convertidorFachada.convertirVideo("youtube.ogg","mp4");
    }
}
