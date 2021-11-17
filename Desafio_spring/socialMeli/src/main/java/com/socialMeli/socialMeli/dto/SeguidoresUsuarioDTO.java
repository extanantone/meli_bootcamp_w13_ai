package com.socialMeli.socialMeli.dto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import java.io.Serializable;
import java.util.List;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class SeguidoresUsuarioDTO extends UsuarioDto implements Serializable {
    private List<UsuarioDto> followers;
    public SeguidoresUsuarioDTO(int user_id, String user_name, List<UsuarioDto> followers){
        super(user_id,user_name);
        this.followers = followers;
    }
}
