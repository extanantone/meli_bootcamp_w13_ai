package com.bootcamp.Deportistas.DTO;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class DeporteDTO implements Serializable {
    private String nombre;
    private Integer nivel;
}
