package ejerciciodeportista.bootcamp.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class DeporteDTO implements Serializable {
    String nombre;
    String nivel;


}
