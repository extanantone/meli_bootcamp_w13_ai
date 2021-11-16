package com.messenger.messenger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/messenger")
public interface MessengerControllerI {

    @PostMapping("/{message}")
    ResponseEntity<?> newMessage(@PathVariable String message);

    @GetMapping("/showMessages")
    ResponseEntity<?> showMessages();
}
