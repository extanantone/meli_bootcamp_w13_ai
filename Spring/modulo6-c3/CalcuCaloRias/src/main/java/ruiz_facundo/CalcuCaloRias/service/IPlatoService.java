package ruiz_facundo.CalcuCaloRias.service;

import ruiz_facundo.CalcuCaloRias.dto.InfoPlatoDTO;
import ruiz_facundo.CalcuCaloRias.dto.PlatoDTO;

public interface IPlatoService {
    public InfoPlatoDTO getInfoPlato(PlatoDTO inPlato);
}
