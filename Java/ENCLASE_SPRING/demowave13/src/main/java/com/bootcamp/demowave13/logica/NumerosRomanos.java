package com.bootcamp.demowave13.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumerosRomanos {

    private static final Map<Integer,String> romanos = new HashMap<>();
    private static final List<Integer> decimales10 = new ArrayList<>();

    private static final List<String> ordenNumeros = new ArrayList<>();

    static {
        romanos.put(1   ,"I");
        romanos.put(5   ,"V");
        romanos.put(10  ,"X");
        romanos.put(50  ,"L");
        romanos.put(100 ,"C");
        romanos.put(500 ,"D");
        romanos.put(1000,"M");
        romanos.put(5000,"P");
        romanos.put(10000,"Z");

        decimales10.addAll(List.of(1,5,10,50,100,500,1000,5000,10000));

        ordenNumeros.addAll(List.of("I","V","X","L","C","D","M","P","Z","SALIR"));

    }
    public static String decimalARomano(int numeroDecimal){
        StringBuilder salida = new StringBuilder();
        if(numeroDecimal>=10000)
            return "Lo sentimos solo procesamos numeros romanos del 1 al 1499";

        for(int i= decimales10.size()-1;i>=0;i--){
            while(numeroDecimal>=decimales10.get(i)){
                numeroDecimal -=decimales10.get(i);
                salida.append(ordenNumeros.get(i));
            }
        }

        // si encuentro letras que van seguidas 4 veces debo reemplazarlos por su version de resta
        Pattern patron = Pattern.compile("\\w{0,1}(I{4}|V{4}|X{4}|L{4}|C{4}|D{4}|M{4}|P{4}|Z{4})");
        Matcher matcher = patron.matcher(salida.toString());
        while(matcher.find())
        {
            String encontrado = matcher.group();
            String letra = encontrado.split("")[0];
            String letraResta = encontrado.split("")[1];
            String letraMayor;
            boolean nueve = false;

            if(letra.equals("V")||letra.equals("L")||letra.equals("D"))
            {
                letraMayor = ordenNumeros.get(ordenNumeros.indexOf(letra)+1);
                nueve = true;
            }
            else
                letraMayor = ordenNumeros.get(ordenNumeros.indexOf(letraResta)+1);

            if(letraMayor.equals("SALIR"))
                return "Lo sentimos solo procesamos numeros romanos del 1 al 1499";
            else
            {
                String nuevaLetra = letraResta.concat(letraMayor);
                int indiceIni = salida.indexOf(encontrado);
                int indiceFin = indiceIni+encontrado.length();
                if(!nueve)
                    salida.replace(indiceIni+1,indiceFin,nuevaLetra);
                else
                    salida.replace(indiceIni,indiceFin,nuevaLetra);
            }
        }
        return salida.toString();
    }

}
