package ruiz_facundo.Star.Wars.cast.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import ruiz_facundo.Star.Wars.cast.model.Personaje;

import java.io.Serializable;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PersonajeDTO implements Serializable {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO() {}

    public PersonajeDTO(Personaje inP) {
        this.name = inP.getName();
        this.height = inP.getHeight();
        this.mass = inP.getMass();
        this.gender = inP.getGender();
        this.homeworld = inP.getHomeworld();
        this.species = inP.getSpecies();
    }

}
