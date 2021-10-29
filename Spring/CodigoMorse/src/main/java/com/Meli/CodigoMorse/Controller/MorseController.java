package com.Meli.CodigoMorse.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.Meli.CodigoMorse.Service.MorseService;

@RestController
public class MorseController {

        @GetMapping("/{palabras}")
        public String convertirMorse(@PathVariable("palabras") String palabras) {
            return MorseService.getTexto(palabras);
        }
}
