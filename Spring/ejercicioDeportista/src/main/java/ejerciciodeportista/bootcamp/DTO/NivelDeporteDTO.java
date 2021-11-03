package ejerciciodeportista.bootcamp.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class NivelDeporteDTO implements Serializable {
    String nivel;
}
