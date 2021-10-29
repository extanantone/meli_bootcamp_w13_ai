package com.sprindemo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
public class HelloWorldController {
    @RequestMapping
    public String helloWorld(){
        return "Hello world from springboot";
    }

    @RequestMapping("/goodbye")
    public String goodbye(){
        return "Goodbye budy";
    }

    @GetMapping("hola/{parametro}")
    public String goodbyeParametro( @PathVariable("parametro") String parametro){
        String morse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
                "|",".---","..---","...--","....-",".....","-....","--...","---..","----.","-----"};
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";

        String parametrow = parametro.replaceAll("\\s{2,}", " * ");

        String arrayParametros[] = parametrow.split(" ");

        String word = "";


        for ( String x : arrayParametros) {

            if ( !x.contains("*")){
                int index = Arrays.asList(morse).indexOf(x);
                word = word + alphabet.charAt(index) + "";
            }else {
                word += " ";
            }
        }

        return word;
    }

}
