package com.socialMeli.socialMeli.dto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
public class ConteoDeSeguidoresDTO extends UsuarioDto implements Serializable {
    private int followersCount;
    public ConteoDeSeguidoresDTO(int id, String name, int followersCount){
        super(id,name);
        this.followersCount = followersCount;
    }
}
