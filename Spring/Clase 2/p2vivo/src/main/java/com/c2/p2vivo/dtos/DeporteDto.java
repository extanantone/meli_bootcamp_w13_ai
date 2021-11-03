package com.c2.p2vivo.dtos;

import com.c2.p2vivo.models.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DeporteDto implements Serializable {
    String nombre;
    String nivel;
}
