package ruiz_facundo.CalcuCaloRias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import ruiz_facundo.CalcuCaloRias.model.Ingrediente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientesRepository implements IIngredientesRepository {
    List<Ingrediente> alacena;

    public IngredientesRepository() {
        this.alacena = abrirIngredientesJSON();
    }

    @Override
    public List<Ingrediente> abrirIngredientesJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    @Override
    public Integer getCaloriesByIngredientName(String name) {
        for (Ingrediente i: this.alacena) {
            if (name.equals(i.getName())) return i.getCalories();
        }
        return 0;
    }
}
