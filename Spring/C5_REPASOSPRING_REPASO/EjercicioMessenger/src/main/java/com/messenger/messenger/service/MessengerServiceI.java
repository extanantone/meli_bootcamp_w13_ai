package com.messenger.messenger.service;

import com.messenger.messenger.dtos.MessengerDTO;

import java.util.List;

public interface MessengerServiceI {
    List<MessengerDTO> showMessengers();
}
