package com.desafio_testing.principal.servicios;

import com.desafio_testing.principal.dto.ConteosDTO;
import com.desafio_testing.principal.dto.ListaUsuariosDTO;
import com.desafio_testing.principal.dto.PublicacionesDTO;
import com.desafio_testing.principal.enumerados.EnumErrs;
import com.desafio_testing.principal.enumerados.EnumOrdenes;
import com.desafio_testing.principal.excepciones.NegocioException;
import com.desafio_testing.principal.modelo.Producto;
import com.desafio_testing.principal.modelo.Publicacion;
import com.desafio_testing.principal.modelo.Usuario;
import com.desafio_testing.principal.repositorios.IRepositorios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ServicioPublicacionesTest {

    @Mock
    private IRepositorios mockRepo;

    @InjectMocks
    private ServicioPublicaciones servicioPubs;

    @InjectMocks
    private ServicioUsuarios servicioUsers;

    @Test
    public void verifyNameOrderDomainSadT0003(){

        String order = "diferente";
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fecha = LocalDate.now();
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.obtenerSeguidores(user.getUserId())).thenReturn(Mockito.anyList());

        NegocioException salida = Assertions.assertThrows(NegocioException.class, () -> servicioUsers.listaSeguidores(user.getUserId(),order));
        Assertions.assertEquals(EnumErrs.PARAMETER_NOT_FOUND.getCodigo(),salida.getCodigo());


    }

    @Test
    public void verifyNameOrderDomainHappyT0003(){

        String order = EnumOrdenes.name_asc.name();
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fecha = LocalDate.now();
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.obtenerSeguidores(user.getUserId())).thenReturn(Mockito.anyList());

        servicioUsers.listaSeguidores(user.getUserId(),order);

    }

    @Test
    public void verifyOrderNameHappyT004(){

        String orderAsc = EnumOrdenes.name_asc.name();
        String orderDes = EnumOrdenes.name_desc.name();
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fecha = LocalDate.now();
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);

        List<Usuario> listaUsers = new ArrayList<>(List.of(
            new Usuario(1,"Ricardo"),
            new Usuario(1,"Alberto"),
            new Usuario(1,"Zulma")

        ));

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.obtenerSeguidores(user.getUserId())).thenReturn(listaUsers);

        ListaUsuariosDTO currentAsc = servicioUsers.listaSeguidores(user.getUserId(), orderAsc);
        ListaUsuariosDTO currentDes = servicioUsers.listaSeguidores(user.getUserId(), orderDes);

        Assertions.assertAll(
                ()->{
                    for(int i = 0;i<(currentAsc.getFollowers().size()-1);i++)
                    {
                        int nombreComparados = currentAsc.getFollowers().get(i).getUserName().compareTo(currentAsc.getFollowers().get(i+1).getUserName());
                        Assertions.assertTrue(0>=nombreComparados);
                    }
                }
        );

        Assertions.assertAll(
                ()->{
                    for(int i = 0;i<(currentDes.getFollowers().size()-1);i++)
                    {
                        int nombreComparados = currentDes.getFollowers().get(i).getUserName().compareTo(currentDes.getFollowers().get(i+1).getUserName());
                        Assertions.assertTrue(0<=nombreComparados);
                    }
                }
        );

    }

    @Test
    public void verifyOrderDomainSadT005(){

        String order = "diferente";
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fecha = LocalDate.now();
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.publicacionesParaSeguidor(user,fechaLimite)).thenReturn(Mockito.anyList());

        NegocioException salida = Assertions.assertThrows(NegocioException.class, () -> servicioPubs.consultarPublicaciones(1, order));
        Assertions.assertEquals(EnumErrs.PARAMETER_NOT_FOUND.getCodigo(),salida.getCodigo());

    }

    @Test
    public void verifyOrderDateDomainHappyT005(){

        String order = EnumOrdenes.date_asc.name();
        Usuario user = new Usuario(1,"Ricardo");
        LocalDate fecha = LocalDate.now();
        LocalDate fechaLimite =  LocalDate.now().minusDays(14);

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.publicacionesParaSeguidor(user,fechaLimite)).thenReturn(Mockito.anyList());

        servicioPubs.consultarPublicaciones(user.getUserId(),order);
    }

    @Test
    public void verifyOrderHappyT006(){

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
    public void verifyCountFollowers(){

        List<Usuario> listaUsers = new ArrayList<>(List.of(
                new Usuario(1,"Ricardo"),
                new Usuario(1,"Alberto"),
                new Usuario(1,"Zulma")
        ));

        Usuario user = new Usuario(1,"Ricardo");

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.obtenerSeguidores(1)).thenReturn(listaUsers);

        ConteosDTO conteoActual = servicioUsers.conteoSeguidores(1);

        Assertions.assertEquals(listaUsers.size(),conteoActual.getFollowersCount());

    }

    @Test
    public void verifyCorrectDatePublics(){

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

}
