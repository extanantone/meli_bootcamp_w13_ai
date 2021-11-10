package estructurales.facade;

import java.io.File;

public class VideoConversionFacade {

    public File convertirVideo(String fileName, String format){
        System.out.println("VideoConversionFacade: inicia la conversion");
        ArchivoVideo archivo = new ArchivoVideo(fileName,format);
        Codec fuenteCodec = CodecFactory.extraer(archivo);
        Codec destino;

        if(format.equals("mp4"))
            destino = new MPEG4CompressionCodec();
        else
            destino = new OggCompresionCodec();

        ArchivoVideo buffer = BitRateReader.leer(archivo,fuenteCodec);
        ArchivoVideo resultadointer = BitRateReader.convertir(buffer,destino);
        File resultado = (new AudioMixer()).fix(resultadointer);
        System.out.println("VideoConversionFacade: conversion finalizada");
        return resultado;
    }


}
