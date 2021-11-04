package ruiz_facundo.CalcuCaloRias.service;

import org.springframework.stereotype.Service;
import ruiz_facundo.CalcuCaloRias.dto.InfoPlatoDTO;
import ruiz_facundo.CalcuCaloRias.dto.IngredienteDTO;
import ruiz_facundo.CalcuCaloRias.dto.PlatoDTO;
import ruiz_facundo.CalcuCaloRias.repository.IIngredientesRepository;

import java.util.HashMap;

@Service
public class PlatoService implements IPlatoService {
    IIngredientesRepository ingredientesRepository;

    public PlatoService(IIngredientesRepository inIngredientesRepository) {
        this.ingredientesRepository = inIngredientesRepository;
    }

    @Override
    public InfoPlatoDTO getInfoPlato(PlatoDTO inPlato) {
        HashMap<String, Double> outIngredientCalories = new HashMap<String, Double>();
        double outTotalCalories = 0;
        String outMostCaloricIngredient = "";
        for(IngredienteDTO i : inPlato.getWeights()) {
            Integer caloriesRate = this.ingredientesRepository.getCaloriesByIngredientName(i.getName());
            Double ingredientCalories = (double) caloriesRate * (double) i.getWeight()/100.0;
            outIngredientCalories.put(i.getName(), ingredientCalories);
            outTotalCalories+=ingredientCalories;
            if (outMostCaloricIngredient.isEmpty()) outMostCaloricIngredient = i.getName();
            else if (ingredientCalories > outIngredientCalories.get(outMostCaloricIngredient)) {
                outMostCaloricIngredient = i.getName();
            }
        }

        InfoPlatoDTO outInfoPlato = new InfoPlatoDTO();
        outInfoPlato.setCaloriesByIngredient(outIngredientCalories);
        outInfoPlato.setTotalCalories(outTotalCalories);
        outInfoPlato.setMostCaloricIngredient(outMostCaloricIngredient);

        return outInfoPlato;

    }
}
