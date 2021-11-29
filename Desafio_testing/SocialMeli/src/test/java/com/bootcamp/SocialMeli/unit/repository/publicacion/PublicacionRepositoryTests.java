package com.bootcamp.SocialMeli.unit.repository.publicacion;

import com.bootcamp.SocialMeli.model.Producto;
import com.bootcamp.SocialMeli.model.Publicacion;
import com.bootcamp.SocialMeli.repository.publicacion.IPublicacionRepository;
import com.bootcamp.SocialMeli.repository.publicacion.PublicacionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class PublicacionRepositoryTests {
    IPublicacionRepository repository = new PublicacionRepository();

    @Test
    public void testGivenValidPostIdReturnPublication() {
        int idPost = 10;
        Producto productoSilla = new Producto(22, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada");
        Publicacion expected = new Publicacion(8, idPost, LocalDate.now().minusDays(5), productoSilla, 122, 3000.0, false, 0.00);

        repository.insertarPublicacion(expected);

        Publicacion actual = repository.devolverPublicacion(idPost);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGivenValidPostIdReturnPublicationList() {
        int idPost = 10;
        int idUser = 8;
        Producto productoSilla = new Producto(22, "Silla", "Mueble", "Ekko", "Marrón", "Extra reforzada");
        Publicacion publicacion = new Publicacion(idUser, idPost, LocalDate.now().minusDays(5), productoSilla, 122, 3000.0, false, 0.00);

        List<Publicacion> expected = List.of(publicacion);

        repository.insertarPublicacion(publicacion);

        List<Publicacion> actual = repository.devolverPublicaciones(idUser);
        Assertions.assertEquals(expected, actual);
    }
}
