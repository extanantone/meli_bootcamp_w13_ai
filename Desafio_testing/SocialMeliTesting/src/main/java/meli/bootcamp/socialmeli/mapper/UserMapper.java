package meli.bootcamp.socialmeli.mapper;

import meli.bootcamp.socialmeli.dto.NewUserDTO;
import meli.bootcamp.socialmeli.dto.ProductsPostByUserDTO;
import meli.bootcamp.socialmeli.dto.ProductsPostDTO;
import meli.bootcamp.socialmeli.dto.UserDTO;
import meli.bootcamp.socialmeli.model.Post;
import meli.bootcamp.socialmeli.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Clase para mapear entre el modelo y los DTOs los post que ingresan o salen del sistema.
 * @author andrmorales
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source= "userId", target = "userId"),
            @Mapping(source= "userName", target = "userName"),
            @Mapping(source= "firstName", target = "firstName"),
            @Mapping(source= "lastName", target = "lastName"),
            @Mapping(source= "age", target = "age")
    })
    User newUserDTOtoUser(NewUserDTO newUserDTO);

    @InheritInverseConfiguration
    NewUserDTO userToNewUserDTO(User user);


    @Mappings({
            @Mapping(source= "userId", target = "userID"),
            @Mapping(source= "userName", target = "userName")
    })
    UserDTO userToUserDTO(User user);
}
