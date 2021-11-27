package com.desafio_testing.principal.servicios;

import com.desafio_testing.principal.dto.ConteosDTO;
import com.desafio_testing.principal.dto.ListaPublicacionesDTO;
import com.desafio_testing.principal.dto.ListaUsuariosDTO;
import com.desafio_testing.principal.dto.PublicacionesDTO;
import com.desafio_testing.principal.enumerados.EnumErrs;
import com.desafio_testing.principal.enumerados.EnumOrdenes;
import com.desafio_testing.principal.excepciones.NegocioException;
import com.desafio_testing.principal.modelo.Producto;
import com.desafio_testing.principal.modelo.Publicacion;
import com.desafio_testing.principal.modelo.Usuario;
import com.desafio_testing.principal.repositorios.IRepositorios;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ServicioPublicacionesTest {

    private IRepositorios mockRepo = Mockito.mock(IRepositorios.class);

    private ServicioPublicaciones servicioPubs = new ServicioPublicaciones(mockRepo);


    @Test
     void verifyOrderDomainSadT005(){

        String order = "diferente";
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.publicacionesParaSeguidor(user,fechaLimite)).thenReturn(Mockito.anyList());

        NegocioException salida = Assertions.assertThrows(NegocioException.class, () -> servicioPubs.consultarPublicaciones(1, order));
        Assertions.assertEquals(EnumErrs.PARAMETER_NOT_FOUND.getCodigo(),salida.getCodigo());

    }

    @Test
     void verifyOrderDateDomainHappyT005(){

        String order = EnumOrdenes.date_asc.name();
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);
        LocalDate fecha = LocalDate.now();

        List<Publicacion> listaTest = new ArrayList<>(List.of(
                new Publicacion(1,fecha, new Producto(1,"Silla Gamer5","Gamer","Racer","Red & Black","Special Edition"),100,1500.5,user,false,0.0),
                new Publicacion(2,fecha.minusDays(1), new Producto(123,"Silla Gamer4","Gamer2","Racer2","Red & Black2","Special Edition2"),100,1500.5,user,false,0.0),
                new Publicacion(3,fecha, new Producto(12,"Silla Gamer3","Gamer3","Racer3","Red & Black3","Special Edition3"),100,1500.5,user,false,0.0),
                new Publicacion(4,fecha.minusDays(3), new Producto(3,"Silla Gamer2","Gamer4","Racer4","Red & Black4","Special Edition4"),100,1500.5,user,false,0.0)
        ));

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.publicacionesParaSeguidor(user,fechaLimite)).thenReturn(listaTest);

        List<PublicacionesDTO> listaCurrent = servicioPubs.consultarPublicaciones(user.getUserId(),order);

        Assertions.assertEquals(4,listaCurrent.size());

    }

    @Test
     void verifyOrderHappyT006(){

        String orderAsc = EnumOrdenes.date_asc.name();
        String orderDes = EnumOrdenes.date_desc.name();
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fecha = LocalDate.now();
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);


        List<Publicacion> listaTest = new ArrayList<>(List.of(
                new Publicacion(1,fecha, new Producto(1,"Silla Gamer5","Gamer","Racer","Red & Black","Special Edition"),100,1500.5,user,false,0.0),
                new Publicacion(2,fecha.minusDays(1), new Producto(123,"Silla Gamer4","Gamer2","Racer2","Red & Black2","Special Edition2"),100,1500.5,user,false,0.0),
                new Publicacion(3,fecha, new Producto(12,"Silla Gamer3","Gamer3","Racer3","Red & Black3","Special Edition3"),100,1500.5,user,false,0.0),
                new Publicacion(4,fecha.minusDays(3), new Producto(3,"Silla Gamer2","Gamer4","Racer4","Red & Black4","Special Edition4"),100,1500.5,user,false,0.0)
        ));

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.publicacionesParaSeguidor(user,fechaLimite)).thenReturn(listaTest);

        List<PublicacionesDTO> currentAsc = servicioPubs.consultarPublicaciones(user.getUserId(),orderAsc);
        List<PublicacionesDTO> currentDes = servicioPubs.consultarPublicaciones(user.getUserId(),orderDes);

        Assertions.assertAll(
                ()->{
                        for(int i = 0;i<(currentAsc.size()-1);i++)
                        {
                            int fechasComparadas = currentAsc.get(i).getDate().compareTo(currentAsc.get(i+1).getDate());
                            Assertions.assertTrue(0>=fechasComparadas);
                        }
                }
        );

        Assertions.assertAll(
                ()->{
                        for(int i = 0;i<(currentDes.size()-1);i++)
                        {
                            int fechasComparadas = currentDes.get(i).getDate().compareTo(currentDes.get(i+1).getDate());
                            Assertions.assertTrue(0<=fechasComparadas);
                        }
                }
        );

    }

    @Test
     void verifyCorrectDatePublics(){

        String orderAsc = EnumOrdenes.date_asc.name();
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);


        List<Publicacion> listaTest = new ArrayList<>(List.of(
                new Publicacion(4,LocalDate.now(), new Producto(3,"Silla Gamer2","Gamer4","Racer4","Red & Black4","Special Edition4"),100,1500.5,user,false,0.0)
        ));

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.publicacionesParaSeguidor(user,fechaLimite)).thenReturn(listaTest);

        List<PublicacionesDTO> currentAsc = servicioPubs.consultarPublicaciones(user.getUserId(),orderAsc);

        Assertions.assertEquals(1,currentAsc.size());

    }

    @Test
    void verifyPromoPubsHappyTX2(){

        Usuario user = new Usuario(1,"test");
        String orden = EnumOrdenes.date_desc.name();
        LocalDate fecha = LocalDate.now();
        List<Publicacion> listaTest = new ArrayList<>(List.of(
                new Publicacion(1,fecha, new Producto(1,"Silla Gamer5","Gamer","Racer","Red & Black","Special Edition"),100,1500.5,user,true,0.0),
                new Publicacion(2,fecha.minusDays(1), new Producto(123,"Silla Gamer4","Gamer2","Racer2","Red & Black2","Special Edition2"),100,1500.5,user,true,0.0),
                new Publicacion(3,fecha, new Producto(12,"Silla Gamer3","Gamer3","Racer3","Red & Black3","Special Edition3"),100,1500.5,user,true,0.0),
                new Publicacion(4,fecha.minusDays(3), new Producto(3,"Silla Gamer2","Gamer4","Racer4","Red & Black4","Special Edition4"),100,1500.5,user,true,0.0)
        ));

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.obtenerPubsDeVendedor(user.getUserId())).thenReturn(listaTest);

        ListaPublicacionesDTO salidaActual = servicioPubs.obtenerPubsPromocion(1,orden);

        Assertions.assertAll(
                ()->Assertions.assertEquals(listaTest.size(),salidaActual.getPosts().size())
        );
    }

    @Test
    void verifyPromoPubsSadTX2(){

        Usuario user = new Usuario(1,"test");
        String orden = EnumOrdenes.date_desc.name().concat("dadsada");
        LocalDate fecha = LocalDate.now();
        List<Publicacion> listaTest = new ArrayList<>(List.of(
                new Publicacion(1,fecha, new Producto(1,"Silla Gamer5","Gamer","Racer","Red & Black","Special Edition"),100,1500.5,user,true,0.0),
                new Publicacion(2,fecha.minusDays(1), new Producto(123,"Silla Gamer4","Gamer2","Racer2","Red & Black2","Special Edition2"),100,1500.5,user,true,0.0),
                new Publicacion(3,fecha, new Producto(12,"Silla Gamer3","Gamer3","Racer3","Red & Black3","Special Edition3"),100,1500.5,user,true,0.0),
                new Publicacion(4,fecha.minusDays(3), new Producto(3,"Silla Gamer2","Gamer4","Racer4","Red & Black4","Special Edition4"),100,1500.5,user,true,0.0)
        ));

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.obtenerPubsDeVendedor(user.getUserId())).thenReturn(listaTest);

        Assertions.assertAll(
                ()->Assertions.assertThrows(NegocioException.class,()->servicioPubs.obtenerPubsPromocion(user.getUserId(),orden))
        );
    }


}
