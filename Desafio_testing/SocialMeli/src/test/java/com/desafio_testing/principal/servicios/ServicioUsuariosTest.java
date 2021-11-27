package com.desafio_testing.principal.servicios;

import com.desafio_testing.principal.dto.ConteosDTO;
import com.desafio_testing.principal.dto.ListaUsuariosDTO;
import com.desafio_testing.principal.enumerados.EnumErrs;
import com.desafio_testing.principal.enumerados.EnumOrdenes;
import com.desafio_testing.principal.excepciones.NegocioException;
import com.desafio_testing.principal.modelo.Usuario;
import com.desafio_testing.principal.repositorios.IRepositorios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ServicioUsuariosTest {

    private final IRepositorios mockRepo = Mockito.mock(IRepositorios.class);

    private final ServicioUsuarios servicioUsers = new ServicioUsuarios(mockRepo);

    @Test
    void verifyNameOrderDomainSadT0003(){

        String order = "diferente";
        Usuario user = new Usuario(1,"Ricardo");
        Integer userID = user.getUserId();

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.obtenerSeguidores(user.getUserId())).thenReturn(Mockito.anyList());

        NegocioException salida = Assertions.assertThrows(NegocioException.class, () -> servicioUsers.listaSeguidores(userID,order));
        Assertions.assertEquals(EnumErrs.PARAMETER_NOT_FOUND.getCodigo(),salida.getCodigo());

    }

    @Test
    void verifyNameOrderDomainHappyT0003(){

        String order = EnumOrdenes.name_asc.name();
        Usuario user = new Usuario(1,"Ricardo");

        List<Usuario> listaUsers = new ArrayList<>(List.of(
                new Usuario(1,"Ricardo"),
                new Usuario(1,"Alberto"),
                new Usuario(1,"Zulma")
        ));

        Mockito.when(mockRepo.findUserById(1)).thenReturn(user);
        Mockito.when(mockRepo.obtenerSeguidores(user.getUserId())).thenReturn(listaUsers);

        ListaUsuariosDTO usersCurrent = servicioUsers.listaSeguidores(user.getUserId(),order);

        Assertions.assertFalse(usersCurrent.getFollowers().isEmpty());

    }

    @Test
    void verifyOrderNameHappyT004(){

        String orderAsc = EnumOrdenes.name_asc.name();
        String orderDes = EnumOrdenes.name_desc.name();
        Usuario user = new Usuario(1,"Ricardo");

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
    void verifyCountFollowers(){

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

}
