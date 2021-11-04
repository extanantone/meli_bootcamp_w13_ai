package ruiz_facundo.CalcuCaloRias.controller;

import org.springframework.web.bind.annotation.*;
import ruiz_facundo.CalcuCaloRias.dto.InfoPlatoDTO;
import ruiz_facundo.CalcuCaloRias.dto.PlatoDTO;
import ruiz_facundo.CalcuCaloRias.service.IPlatoService;

@RestController
@RequestMapping("api/food")
public class CaloriasController {
    final IPlatoService platoService;

    public CaloriasController(IPlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping("/calcularCalorias")
    public InfoPlatoDTO obtenerInfoDePlato(@RequestBody PlatoDTO inPlato) {
        return platoService.getInfoPlato(inPlato);
    }
}
