package com.messenger.messenger.controller;

import com.messenger.messenger.service.MessengerService;
import com.messenger.messenger.service.MessengerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessengerController implements MessengerControllerI{
    @Autowired
    MessengerServiceI messengerService;

    @Override
    public ResponseEntity<?> newMessage(String message) {
        return new ResponseEntity(messengerService.showMessengers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> showMessages() {
        return new ResponseEntity(messengerService.showMessengers(), HttpStatus.OK);
    }
}
