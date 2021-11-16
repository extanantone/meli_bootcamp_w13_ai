package com.mercadolibre.coderesponse.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/linkTracer")
public class ResponseController {

    /**
     * Toca generar los endpoints, van a ser de naturaleza GET o POST
     *
     * */

    @PostMapping("/api")
    public String createPOST(){
        return "";
    }
}
