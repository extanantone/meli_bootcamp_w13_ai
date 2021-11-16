package com.messenger.messenger.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Phone implements Courier{
    private final int messengerType = 1;
    private final String messengerName = "Phone";

    @Override
    public String showMessage(String message) {
        return "Enviando por WhatsApp <<"+message+"!>>\n";
    }
}
