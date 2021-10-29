package ruiz_facundo.Morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {
    @GetMapping("{morse}")
    public String obtenerTextoDeMorse(@PathVariable("morse") String inMorse) {
        return TraductorMorse.traducirMorse(inMorse);
    }
}
