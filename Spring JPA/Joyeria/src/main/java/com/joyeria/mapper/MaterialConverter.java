package com.joyeria.mapper;

import com.joyeria.dto.MaterialDto;
import com.joyeria.model.Material;
import org.modelmapper.AbstractConverter;

public class MaterialConverter extends AbstractConverter<MaterialDto, Material> {
    @Override
    protected Material convert(MaterialDto materialDto) {
        Material material =null;
        switch (materialDto) {
            case Oro:
                material = Material.Oro;
                break;
            case Plata:
                material = Material.Plata;
                break;
            default:
                break;
        }
        return material;
    }
}
