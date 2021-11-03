package morse.morse;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
public class ControllerMorse {

    @GetMapping("/{mensaje}")
        public String convertirMorse(@PathVariable("mensaje") String m){

        Map<String, String> referencia = Map.ofEntries(Entry("..-","A"));


        StringBuilder decodificado = new StringBuilder();



        String[] morse = m.split(" ");

        for (String entrada: morse
             ) {
            decodificado.append(referencia.get())

        }

        return "Hello " + referencia.get(m);
        }

    private Object Entry(String s, String a) {
    }

}
