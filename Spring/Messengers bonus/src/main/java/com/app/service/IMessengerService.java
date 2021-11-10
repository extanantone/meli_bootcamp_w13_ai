package com.app.service;


import com.app.dto.*;

import java.util.List;

public interface IMessengerService {
    List<MessengerDto> getMessegers();

    MessageDto getMessageDto(int id, String ms);

    void updatePalomaDto(int id, PalomaDto paloma);

    void updateTelefono(int id, CellDto dto);

    void updateTelegrafo(int id,TelegrafoDto dto);
}
