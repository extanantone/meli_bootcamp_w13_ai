package com.w13.ejercicioDeportista.dto;

import com.w13.ejercicioDeportista.entity.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class PersonaDto implements Serializable {



    private String nombre;
    private String apellido;
    private List<Deporte> deporteList = new ArrayList<Deporte>();
    public void cargaDeporteList(Deporte deporte) {
        this.deporteList.add(deporte);
    }
}
