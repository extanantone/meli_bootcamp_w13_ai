package com.morse.c1p2vivo.service;

import com.morse.c1p2vivo.repository.MorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MorseService {

    @Autowired
    MorseRepository morseRepository;

    public String getAlfanumericFromMorse(String morseCode){
        String alphanumericTranscription = "";
        String[] m = morseCode.split("   ");
        for (String word : m){
            String[] letter = word.split(" ");
            for (String l : letter){
                alphanumericTranscription += morseRepository.getAlfanumericFromMorse(l).toUpperCase();
            }
            alphanumericTranscription += " ";
        }
        return alphanumericTranscription;
    }
}
