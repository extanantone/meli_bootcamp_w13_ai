package com.joyeria.controller;

import com.joyeria.dto.JoyaDto;
import com.joyeria.dto.JoyaIdDto;
import com.joyeria.service.IJoyaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joyas")
public class JoyaController {

    private IJoyaService iJoyaService;

    public JoyaController(IJoyaService iJoyaService){
        this.iJoyaService = iJoyaService;
    }

    @PostMapping
    public JoyaIdDto addJoya(@RequestBody JoyaDto dto){
        return iJoyaService.addJoya(dto);
    }

    @GetMapping
    public List<JoyaIdDto> getJoyas(){
        return iJoyaService.getAllJoyas();
    }




}
