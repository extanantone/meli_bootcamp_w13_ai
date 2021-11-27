package com.example.SocialMeli.services.mapper;

import com.example.SocialMeli.dto.DetailDTO;
import com.example.SocialMeli.entities.Detail;

public class DetailMapper {

    public static Detail toEntity(DetailDTO detailDTO) {
        return new Detail(detailDTO.getId(), detailDTO.getProductName(), detailDTO.getType(), detailDTO.getBrand(), detailDTO.getColor(), detailDTO.getNotes());
    }

    public static DetailDTO toDto(Detail detail) {
        return new DetailDTO(detail.getId(), detail.getProductName(), detail.getType(), detail.getBrand(), detail.getColor(), detail.getNotes());
    }
}
