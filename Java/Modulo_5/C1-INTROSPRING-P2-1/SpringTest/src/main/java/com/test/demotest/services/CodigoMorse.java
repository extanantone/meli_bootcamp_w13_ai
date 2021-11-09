package com.test.demotest.services;

import java.util.HashMap;

public class CodigoMorse {

    private HashMap<String, String> morseHMap;

    public CodigoMorse() {
        this.morseHMap = new HashMap<>();

        this.morseHMap.put(".-","A");
        this.morseHMap.put("-...", "B");
        this.morseHMap.put("-.-.","C");
        this.morseHMap.put("-..","D");
        this.morseHMap.put(".","E");
        this.morseHMap.put("..-.","F");
        this.morseHMap.put("--.","G");
        this.morseHMap.put("....","H");
        this.morseHMap.put("..","I");
        this.morseHMap.put(".---","J");
        this.morseHMap.put( "-.-","K");
        this.morseHMap.put( ".-..","L");
        this.morseHMap.put( "--","M");
        this.morseHMap.put( "-.","N");
        this.morseHMap.put( "---","O");
    }

    public HashMap<String, String> getMorseHMap() {
        return morseHMap;
    }

    public void setMorseHMap(HashMap<String, String> morseHMap) {
        this.morseHMap = morseHMap;
    }

    public String convertMorse(String palabra){

        String[] letras = palabra.split(" ");

        String res = "";

        for(String letra : letras){
            if(this.morseHMap.get(letra) == null){
                res += " ";
            }else{
                res += this.morseHMap.get(letra);
            }
        }
        return res;
    }
}
