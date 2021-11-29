package com.bootcamp.SocialMeli.unit.mapper;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.response.InfoPromoDTO;
import com.bootcamp.SocialMeli.dto.response.PublicacionesDTO;
import com.bootcamp.SocialMeli.mapper.Mapper;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Promocion;
import com.bootcamp.SocialMeli.model.Publicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class MapperTest {

    private Mapper mapper;

    private static Publicacion pubCamisetaBoca, pubSamsungFit2, pubNoteDell, pubZapasNike, pubNoteLenovo, pubSanDisk;

    @BeforeEach
    void setup(){
        this.mapper = new Mapper();
        //publicaciones
        pubCamisetaBoca = new Publicacion(5, LocalDate.now(), 1234.0, new Producto(), 111);
        pubSamsungFit2 = new Publicacion(7, LocalDate.of(2021, 11,20), 444.0, new Producto(), 132);
        pubNoteDell = new Publicacion(9, LocalDate.of(2021, 11, 15), 599.5, new Producto(), 101);
        pubZapasNike = new Publicacion(11, LocalDate.of(2021,11,12), 255.5, new Producto(), 112);
        pubNoteLenovo = new Publicacion(15, LocalDate.of(2021,11,13),780.2, new Producto(),101);
        pubSanDisk = new Publicacion(6, LocalDate.of(2021, 10, 5), 100.2, new Producto(), 99);
    }

    @Test
    void convertFromPublicacionDTOToPublicacionWithValidArguments(){
        //Arrange
        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setIdPost(2);
        publicacionDTO.setCategory(111);
        publicacionDTO.setDate(LocalDate.now());
        publicacionDTO.setPrice(250.5);
        publicacionDTO.setDetail(new DetalleProductoDTO());

        //Act
        Publicacion publicacionCurrent = mapper.publicacionDTOToPublicacion(publicacionDTO);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(publicacionDTO.getIdPost(), publicacionCurrent.getIdPost()),
                () -> Assertions.assertEquals(publicacionDTO.getPrice(), publicacionCurrent.getPrice()),
                () -> Assertions.assertEquals(publicacionDTO.getCategory(), publicacionCurrent.getCategory()),
                () -> Assertions.assertEquals(publicacionDTO.getDate(), publicacionCurrent.getDate())
                //no se chequea el detail-producto (miembro a miembro) ya que se hace con ModelMapper
        );
    }

    @Test
    void convertionFromListPublicacionToPublicacionesDTOWithValidArguments(){
        //Arrange
        Integer userId = 44;

        List<Publicacion> listaPublicaciones = List.of(pubZapasNike, pubNoteLenovo, pubNoteDell, pubCamisetaBoca, pubSanDisk, pubSamsungFit2);

        //Act
        PublicacionesDTO publicacionesDTO = mapper.listPublicacionToPublicacionesDTO(userId, listaPublicaciones);

        //Assert
        Assertions.assertAll(
            () -> Assertions.assertEquals(userId, publicacionesDTO.getUserId()),
            () -> {for (int i = 0; i < listaPublicaciones.size(); i++) {
                    Assertions.assertEquals(listaPublicaciones.get(i).getIdPost(), publicacionesDTO.getPosts().get(i).getIdPost());
                    Assertions.assertEquals(listaPublicaciones.get(i).getDate(), publicacionesDTO.getPosts().get(i).getDate());
                    Assertions.assertEquals(listaPublicaciones.get(i).getCategory(), publicacionesDTO.getPosts().get(i).getCategory());
                    Assertions.assertEquals(listaPublicaciones.get(i).getPrice(), publicacionesDTO.getPosts().get(i).getPrice());
            }}
                //no se chequea el detail-producto ya que se hace con ModelMapper
        );
    }

    @Test
    void convertionFromPublicacionToInfoPromoDTOWithValidArguments(){
        //Arrange
        Promocion promocion = new Promocion(15, LocalDate.now(), 1234.0, new Producto(), 111, true, 0.20);

        //Act
        InfoPromoDTO infoPromoDTOCurrent = mapper.publicacionToInfoPromoDTO(promocion);

        //Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(promocion.getIdPost(), infoPromoDTOCurrent.getIdPost()),
                () -> Assertions.assertEquals(promocion.getDate(), infoPromoDTOCurrent.getDate()),
                () -> Assertions.assertEquals(promocion.getPrice(), infoPromoDTOCurrent.getPrice()),
                () -> Assertions.assertEquals(promocion.getCategory(), infoPromoDTOCurrent.getCategory()),
                () -> Assertions.assertEquals(promocion.getHasPromo(), infoPromoDTOCurrent.getHasPromo()),
                () -> Assertions.assertEquals(promocion.getDiscount(), infoPromoDTOCurrent.getDiscount())
                //no se chequea el detail-producto (miembro a miembro) ya que se hace con ModelMapper
        );
    }
}
