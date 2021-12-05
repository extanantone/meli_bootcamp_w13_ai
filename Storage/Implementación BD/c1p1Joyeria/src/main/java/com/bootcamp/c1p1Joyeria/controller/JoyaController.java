package com.bootcamp.c1p1Joyeria.controller;

import com.bootcamp.c1p1Joyeria.dto.JoyaDTO;
import com.bootcamp.c1p1Joyeria.service.IJoyaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private IJoyaService iJoyaService;

    public JoyaController(IJoyaService iJoyaService) {
        this.iJoyaService = iJoyaService;
    }

    @PostMapping("/new")
    public Long saveJoya(@RequestBody JoyaDTO joyaDTO) {
        return iJoyaService.saveJoya(joyaDTO);
    }

    @GetMapping("/")
    public List<JoyaDTO> getAllJoyas() {
        return iJoyaService.getAllJoyas();
    }

    @PutMapping("/delete")
    public void deleteJoya(@RequestParam Long id_number) {
        iJoyaService.deleteJoya(id_number);
    }

    @PutMapping("/update")
    public JoyaDTO updateJoya(@RequestBody JoyaDTO joyaDTO, @RequestParam Long id_number) {
        return iJoyaService.updateJoya(joyaDTO, id_number);
    }
}
