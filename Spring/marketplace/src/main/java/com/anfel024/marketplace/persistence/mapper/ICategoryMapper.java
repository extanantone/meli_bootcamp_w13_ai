package com.anfel024.marketplace.persistence.mapper;

import com.anfel024.marketplace.domain.Category;
import com.anfel024.marketplace.persistence.entity.CategoriasEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(CategoriasEntity categoriasEntity);

    @InheritInverseConfiguration
    @Mapping(target = "mListaProductos", ignore = true)
    CategoriasEntity toCategoriasEntity(Category mCategory);
}
