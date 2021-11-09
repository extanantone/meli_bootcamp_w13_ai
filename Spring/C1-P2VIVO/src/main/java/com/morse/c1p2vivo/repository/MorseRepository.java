package com.morse.c1p2vivo.repository;

import com.morse.c1p2vivo.model.Transcription;
import org.springframework.stereotype.Repository;

@Repository
public class MorseRepository {

    Transcription dbMorse = new Transcription();

    public String getAlfanumericFromMorse(String morseCode){
        String alphanumericResult = dbMorse.getMorseCode().get(morseCode);
        if (alphanumericResult == null){
            return "";
        }
        return alphanumericResult;
    }
}
