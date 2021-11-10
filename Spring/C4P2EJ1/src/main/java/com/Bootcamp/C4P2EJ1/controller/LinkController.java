package com.Bootcamp.C4P2EJ1.controller;

import com.Bootcamp.C4P2EJ1.dto.LinkDTO;
import com.Bootcamp.C4P2EJ1.service.ILinkService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/link")
public class LinkController {
    ILinkService iLinkService;

    public LinkController(ILinkService iLinkService) {
        this.iLinkService = iLinkService;
    }

    @PostMapping("/crear")
    public LinkDTO nuevoLink(@RequestBody LinkDTO linkDTO) {
        return iLinkService.nuevoLink(linkDTO);
    }

    @GetMapping("/redireccion/{password}")
    public LinkDTO redireccionarLink(@PathVariable("password") String password, LinkDTO linkDTO) {
        return iLinkService.redireccionarLink(password, linkDTO);
    }

    @GetMapping("/estadistica")
    public int estadisticaLink(LinkDTO linkDTO) {
        return iLinkService.estadisticaLink(linkDTO);
    }

    @PostMapping("/eliminar")
    public boolean eliminarLink(LinkDTO linkDTO) {
        return iLinkService.eliminarLink(linkDTO);
    }

}
