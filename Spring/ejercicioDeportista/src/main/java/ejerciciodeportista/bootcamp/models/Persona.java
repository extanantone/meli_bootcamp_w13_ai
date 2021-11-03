package ejerciciodeportista.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Persona {
    private String name;
    private String lastname;
    private Number edad;
    Deporte deporte;
}
