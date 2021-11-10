package com.bootcamp.messengers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelegrafoStateDTO {
    private Integer id;
    private boolean enchufado;

    public boolean getEnchufado(){
        return this.enchufado;
    }
}
