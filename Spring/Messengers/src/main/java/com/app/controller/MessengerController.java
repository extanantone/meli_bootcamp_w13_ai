package com.app.controller;

import com.app.dto.MenssageDto;
import com.app.dto.MessengerDto;
import com.app.service.IMessengerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messengers")
public class MessengerController {

    private IMessengerService iMessengerService;

    public MessengerController(IMessengerService iMessengerService){
        this.iMessengerService = iMessengerService;
    }

    @GetMapping
    public List<MessengerDto> getMessengers(){
        return iMessengerService.getAllMessengers();
    }

    @GetMapping("/{id}/message/{ms}")
    public MenssageDto getMenssage(@PathVariable int id,@PathVariable String ms){
        return  iMessengerService.getMensageById(id,ms);
    }

}
