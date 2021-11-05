package com.ftbr.calculadoradecalorias.service;

import com.ftbr.calculadoradecalorias.dto.IngredienteDTO;
import com.ftbr.calculadoradecalorias.dto.IngredienteRequestDTO;
import com.ftbr.calculadoradecalorias.dto.PlatoDTO;
import com.ftbr.calculadoradecalorias.dto.PlatoRequestDTO;
import com.ftbr.calculadoradecalorias.repository.IPlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService implements IPlatoService{
    IPlatoRepository platoRepository;

    public PlatoService(IPlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public PlatoDTO calcuarCalorias(PlatoRequestDTO platoRequest) {
        int sumaCalorias = 0;
        String ingredienteConMaxCalorias = "";
        int caloriasMax = 0;
        ArrayList<IngredienteDTO> ingredientesDTOList = new ArrayList<>();
        for(IngredienteRequestDTO ingredienteReqDTO : platoRequest.getIngredientes()){
            int calorias = this.platoRepository.getCalorias(
                    ingredienteReqDTO.getNombre())
                    * ingredienteReqDTO.getGramos() / 100;
            ingredientesDTOList.add(new IngredienteDTO(ingredienteReqDTO.getNombre(),calorias));
            if(calorias > caloriasMax){
                ingredienteConMaxCalorias = ingredienteReqDTO.getNombre();
                caloriasMax = calorias;
            }
        }
        return new PlatoDTO(platoRequest.getNombre(), caloriasMax ,ingredientesDTOList,ingredienteConMaxCalorias);
    }

    @Override
    public List<PlatoDTO> calcuarCaloriasLista(List<PlatoRequestDTO> platosRequest) {
        return platosRequest.stream().map(p -> calcuarCalorias(p)).collect(Collectors.toList());
    }
}
