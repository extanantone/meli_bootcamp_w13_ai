package ruiz_facundo.CalcuCaloRias.repository;

import ruiz_facundo.CalcuCaloRias.model.Ingrediente;

import java.util.List;

public interface IIngredientesRepository {
    public List<Ingrediente> abrirIngredientesJSON();
    public Integer getCaloriesByIngredientName(String name);
}
