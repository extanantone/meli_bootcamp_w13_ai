package com.app.service;

import com.app.dto.MenssageDto;
import com.app.dto.MessengerDto;

import java.util.List;

public interface IMessengerService {
    List<MessengerDto> getAllMessengers();
    MenssageDto getMensageById(int id,String message);
}
