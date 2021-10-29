package ruiz_facundo.nrosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ruiz_facundo.nrosRomanos.RomanNumber;

@RestController
public class RomanController {
    @GetMapping(path="/roman")
    public String decimalToRoman(@RequestParam("decimal") Integer dec) {
        RomanNumber inRoman = new RomanNumber(dec);
        String outRoman = inRoman.getRoman();
        if (outRoman.length() == 0) {
            return String.format("%d no tiene representación en número romano (para la consigna).", dec);
        } else {
            return String.format("El número decimal %d en romanos es %s", dec, inRoman.getRoman());
        }
    }
}
