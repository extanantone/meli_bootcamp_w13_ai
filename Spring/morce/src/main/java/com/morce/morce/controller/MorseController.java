package com.morce.morce.controller;

import com.morce.morce.TraductorMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseController {

    //-- . .-. -.-. .- -.. --- .-.. .. -... .-. .

    @Autowired
    private TraductorMorse traductor;


    @GetMapping("/{morse}")
    public String getTraduccion(@PathVariable String morse){
        return traductor.traduccion(morse);
    }

}
