package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.request.PublicacionDTO;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.NamingConventions;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

/* En general usamos el paquete config para guardar esta clase*/

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        return modelMapper;
    }

    public Publicacion publicacionDTOToPublicacion(PublicacionDTO publicacionDTO){
        // setup
        TypeMap<Publicacion, PublicacionDTO> propertyMapper = getModelMapper().createTypeMap(Publicacion.class, PublicacionDTO.class);
        propertyMapper.addMappings(mapper -> mapper.skip(PublicacionDTO::setUserId));
       // propertyMapper.addMappings(PublicacionDTO::se)
        return null;
    }

    public Producto detallePublicacionDTOToProducto(DetalleProductoDTO detalleDTO){
        return getModelMapper().map(detalleDTO, Producto.class);
    }
}
 /*PublicacionDTO {
    private int userId;
    private int idPost;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private DetalleProductoDTO detail;
    private int category;
    private double price;
}
    private int idPost;
    private LocalDate date;
    private Producto producto;
    private double price;
    private int category;

detalle producto

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public class Producto {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
  */