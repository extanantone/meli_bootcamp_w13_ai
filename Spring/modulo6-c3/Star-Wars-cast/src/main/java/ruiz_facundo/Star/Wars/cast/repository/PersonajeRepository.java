package ruiz_facundo.Star.Wars.cast.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import ruiz_facundo.Star.Wars.cast.dto.PersonajeDTO;
import ruiz_facundo.Star.Wars.cast.model.Personaje;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository {

    List<Personaje> repertorio;

    PersonajeRepository() {
        this.repertorio = abrirPersonajesJSON();
    }

    protected List<Personaje> abrirPersonajesJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public List<Personaje> buscarPersonajes(String inNombre) {
        return this.repertorio.stream().filter(p -> p.getName().
                toLowerCase().contains(inNombre.toLowerCase())).
                collect(Collectors.toList());
    }


}
