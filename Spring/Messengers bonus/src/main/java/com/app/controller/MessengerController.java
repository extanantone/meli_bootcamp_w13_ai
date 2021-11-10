package com.app.controller;

import com.app.dto.*;
import com.app.service.IMessengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessengerController {

    private IMessengerService iMessengerService;

    public MessengerController(IMessengerService iMessengerService){
        this.iMessengerService=iMessengerService;
    }



    @GetMapping("/messengers")
    public List<MessengerDto> getMessengers(){
        return iMessengerService.getMessegers();
    }

    @GetMapping("/messengers/{id}/message/{ms}")
    public MessageDto getMessageDto(@PathVariable int id,@PathVariable String ms){
        return iMessengerService.getMessageDto(id,ms);
    }

    @PutMapping("/palomas/{id}")
    public void updatePaloma(@RequestBody PalomaDto paloma,@PathVariable int id){
        iMessengerService.updatePalomaDto(id,paloma);
    }

    @PutMapping("/celulares/{id}")
    public void updateCell(@PathVariable int id,@RequestBody CellDto dto){
        iMessengerService.updateTelefono(id,dto);
    }

    @PutMapping("/telegrafos/{id}")
    public void updateTelegrafo(@PathVariable int id,@RequestBody TelegrafoDto dto){
        iMessengerService.updateTelegrafo(id,dto);
    }
}
