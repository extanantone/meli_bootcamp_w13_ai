package com.messenger.messenger.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessengerPigeon implements Courier{
    private final int messengerType = 1;
    private final String messengerName = "Pidgeon";

    @Override
    public String showMessage(String message) {
        return "Grru Rru Gu (Me agarran a mi patita un papelito) <<"+message+">>\n";
    }
}
