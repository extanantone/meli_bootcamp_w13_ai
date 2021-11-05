package com.linkTracker.ejercicioIntegrador.controller;
import com.linkTracker.ejercicioIntegrador.dto.LinkDto;
import com.linkTracker.ejercicioIntegrador.service.LinkServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LinkController {
    LinkServicio linkServicio;
    public LinkController(LinkServicio linkServicio) {
        this.linkServicio = linkServicio;
    }
    @PostMapping("/createLink")
    public LinkDto recibir(@RequestBody LinkDto link){
        return linkServicio.crearLink(link);
    }
}
