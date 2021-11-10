package com.Bootcamp.C4P1EJ1.controller;

import com.Bootcamp.C4P1EJ1.dto.EntradaBlogDTO;
import com.Bootcamp.C4P1EJ1.model.EntradaBlog;
import com.Bootcamp.C4P1EJ1.service.IEntradaBlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class EntradaBlogController {
    private IEntradaBlogService iEntradaBlogService;

    public EntradaBlogController(IEntradaBlogService iEntradaBlogService) {
        this.iEntradaBlogService = iEntradaBlogService;
    }

    @PostMapping("/blog")
    public EntradaBlogDTO nuevaEntradaBlog(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        return iEntradaBlogService.nuevaEntradaBlog(entradaBlogDTO);
    }

    @GetMapping("/blog/{id}")
    public EntradaBlogDTO devolverEntradaBlog(@PathVariable("id") Integer id) {
        return iEntradaBlogService.devolverEntradaBlog(id);
    }

    @GetMapping("/  ")
    public List<EntradaBlogDTO> devolverTodasLasEntradasBlog() {
        return iEntradaBlogService.devolverTodasLasEntradasBlog();
    }
}
