package com.bootcamp.SocialMeli.integration;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import com.bootcamp.SocialMeli.dto.request.PromocionDTO;
import com.bootcamp.SocialMeli.dto.response.*;
import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Promocion;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsSMControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JSR310Module())
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    void testCreateAValidPostForAnExistingUser() throws Exception {
        //Arrange
        String successJson = writer.writeValueAsString(new SuccessDTO("Publicacion creada correctamente."));

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(successJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setUserId(1);
        publicacionDTO.setIdPost(15);
        publicacionDTO.setDate(LocalDate.of(2021,11,10));
        publicacionDTO.setCategory(102);
        publicacionDTO.setPrice(550.0);
        publicacionDTO.setDetail(new DetalleProductoDTO(6, "Teclado inalámbrico para PC", "normal","Genius","Black","Último en stock"));

        String payloadJson = writer.writeValueAsString(publicacionDTO);

        //Act and Assert
        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }

    @Test
    void testCreateAPostWithAFutureDateThenFutureDateException() throws Exception{
        //Arrange
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTipo("FutureDateException");
        errorDTO.setMensaje("La fecha 2030-12-12 es posterior al dia de hoy");
        String errorJson = writer.writeValueAsString(errorDTO);

        ResultMatcher expectedStatus = status().isBadRequest();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = content().json(errorJson);

        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setUserId(1);
        publicacionDTO.setIdPost(25);
        publicacionDTO.setDate(LocalDate.of(2030,12,12));
        publicacionDTO.setCategory(102);
        publicacionDTO.setPrice(220.0);
        publicacionDTO.setDetail(new DetalleProductoDTO(6, "Teclado inalámbrico para PC", "normal","Genius","Black","Último en stock"));

        String payloadJson = writer.writeValueAsString(publicacionDTO);

        //Act and Assert
        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }

    @Test
    void testCreateAValidPromoForAnExistingUser() throws Exception {
        //Arrange
        String successJson = writer.writeValueAsString(new SuccessDTO("Promocion creada correctamente."));

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = content().json(successJson);

        PromocionDTO promocionDTO = new PromocionDTO();
        promocionDTO.setUserId(1);
        promocionDTO.setIdPost(17);
        promocionDTO.setDate(LocalDate.of(2021,11,8));
        promocionDTO.setCategory(112);
        promocionDTO.setPrice(330.0);
        promocionDTO.setDetail(new DetalleProductoDTO(6, "Teclado RGB Gamer", "Gamer","Logitech","Grey","Último en stock"));
        promocionDTO.setHasPromo(true);
        promocionDTO.setDiscount(0.20);

        String payloadJson = writer.writeValueAsString(promocionDTO);

        //Act and Assert
        this.mockMvc.perform(post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }

    @Test
    void testGetCantPromocionesFromASellerWithPromociones() throws Exception{
        //Arrange
        CantPromocionesDTO cantPromocionesDTOExpected = new CantPromocionesDTO();
        cantPromocionesDTOExpected.setUserId(4);
        cantPromocionesDTOExpected.setUserName("Lautaro Martinez");
        cantPromocionesDTOExpected.setPromoProductsCount(2);
        String cantPromoJson = writer.writeValueAsString(cantPromocionesDTOExpected);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = content().json(cantPromoJson);

        //Act and Assert
        this.mockMvc.perform(get("/products/{user_id}/promo-post/count", 4))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }

    @Test
    void testGetPromocionesFromASellerWithPromociones() throws Exception{
        //Arrange
        DetalleProductoDTO sbSamsung = new DetalleProductoDTO(4,"Samsung Galaxy Fit 2","Smartbands and Smartwatches","Samsung", "Black or Grey", "con Bluetooth, pantalla AMOLED, bateria 15 dias de duracion");
        InfoPromoDTO promoSbSamsung = new InfoPromoDTO(42, LocalDate.of(2021,11,6), sbSamsung, 120, 80.5, true, 0.25);
        DetalleProductoDTO camisetaBoca = new DetalleProductoDTO(2, "Camiseta Boca Juniors", "Camiseta deportiva", "Adidas", "Blue and Yellow", "Camiseta jugador oficial, talle XL");
        InfoPromoDTO promoCamisetaBoca = new InfoPromoDTO(41, LocalDate.of(2021, 11, 7), camisetaBoca, 115, 500.1, true, 0.5);

        PromocionesDTO promocionesDTO = new PromocionesDTO();
        promocionesDTO.setUserId(4);
        promocionesDTO.setUserName("Lautaro Martinez");
        promocionesDTO.setPosts(List.of(promoCamisetaBoca, promoSbSamsung));

        String promocionesJson = writer.writeValueAsString(promocionesDTO);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = content().json(promocionesJson);

        //Act and Assert
        this.mockMvc.perform(get("/products/{user_id}/list?order=name_asc", 4))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedJson);
    }
}
