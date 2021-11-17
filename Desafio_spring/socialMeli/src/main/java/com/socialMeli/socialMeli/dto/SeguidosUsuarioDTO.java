package com.socialMeli.socialMeli.dto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import java.util.List;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class SeguidosUsuarioDTO extends UsuarioDto {
    private List<UsuarioDto> followed;
    public SeguidosUsuarioDTO(int user_id,String user_name,List<UsuarioDto>followed){
        super(user_id,user_name);
        this.followed = followed;
    }
}
