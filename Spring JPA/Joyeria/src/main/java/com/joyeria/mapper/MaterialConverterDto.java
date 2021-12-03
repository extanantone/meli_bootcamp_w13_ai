package com.joyeria.mapper;

import com.joyeria.dto.MaterialDto;
import com.joyeria.model.Material;
import org.modelmapper.AbstractConverter;

public class MaterialConverterDto extends AbstractConverter<Material, MaterialDto> {
    @Override
    protected MaterialDto convert(Material material) {
        MaterialDto materialDto =null;
        switch (material) {
            case Oro:
                materialDto = MaterialDto.Oro;
                break;
            case Plata:
                materialDto = MaterialDto.Plata;
                break;
            default:
                break;
        }
        return materialDto;
    }
}
