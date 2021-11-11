package com.bootcamp.apimessengers.controller;

import com.bootcamp.apimessengers.dto.MessageDTO;
import com.bootcamp.apimessengers.dto.MessengerInfoDTO;
import com.bootcamp.apimessengers.dto.MessengerTypeDTO;
import com.bootcamp.apimessengers.service.IMessengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messengers")
public class MessengerController {

    private IMessengerService messengerService;

    public MessengerController(IMessengerService messengerService) {
        this.messengerService = messengerService;
    }

    @GetMapping("/{id}/{message}")
    public ResponseEntity<MessageDTO> showMessage(@PathVariable Long id,
                                                  @PathVariable String message){
        return ResponseEntity.ok(messengerService.showMessage(id, message));
    }

    @GetMapping()
    public ResponseEntity<List<MessengerTypeDTO>> showMessengers(){
        return ResponseEntity.ok(messengerService.getMessengers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessengerInfoDTO> showMessengerInf(@PathVariable Long id){
        return ResponseEntity.ok(messengerService.getMessengerInfo(id));
    }


}
