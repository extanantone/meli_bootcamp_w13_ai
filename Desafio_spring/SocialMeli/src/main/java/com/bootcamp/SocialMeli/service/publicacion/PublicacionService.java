package com.bootcamp.SocialMeli.service.publicacion;

import com.bootcamp.SocialMeli.dto.publicacion.*;
import com.bootcamp.SocialMeli.exception.BadRequestException;
import com.bootcamp.SocialMeli.mapper.PublicacionMapper;
import com.bootcamp.SocialMeli.repository.publicacion.IPublicacionRepository;
import com.bootcamp.SocialMeli.repository.usuario.IUsuarioRepository;
import com.bootcamp.SocialMeli.service.usuario.IUsuarioService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionService implements IPublicacionService {

    IPublicacionRepository iPublicacionRepository;
    IUsuarioRepository iUsuarioRepository;
    IUsuarioService iUsuarioService;
    PublicacionMapper publicacionMapper;

    public PublicacionService(IPublicacionRepository iPublicacionRepository, IUsuarioRepository iUsuarioRepository, IUsuarioService iUsuarioService, PublicacionMapper publicacionMapper) {
        this.iPublicacionRepository = iPublicacionRepository;
        this.iUsuarioRepository = iUsuarioRepository;
        this.iUsuarioService = iUsuarioService;
        this.publicacionMapper = publicacionMapper;
    }

    public void controlExistenciaUsuario(Integer userId) {
        if (!iUsuarioRepository.encontrarUsuario(userId)) {
            throw new BadRequestException("El usuario con ID " + userId + " no existe.");
        }
    }

    @Override
    public void realizarPublicacion(PublicacionDTO publicacionDTO) throws BadRequestException {
        controlExistenciaUsuario(publicacionDTO.getUserId());
        if (iPublicacionRepository.devolverPublicacion(publicacionDTO.getIdPost()) != null) {
            throw new BadRequestException("La publicación con ID " + publicacionDTO.getIdPost() + " ya existe. ");
        }
        iPublicacionRepository.insertarPublicacion(publicacionMapper.publicacionDTOAPublicacion(publicacionDTO));
    }

    @Override
    public PublicacionFollowedDTO listaPublicacionesFollowed(Integer userId) {
        controlExistenciaUsuario(userId);
        PublicacionFollowedDTO publicacionFollowedDTO;
        List<PublicacionDTO> listaPublicacionDTO = iUsuarioService
                .listaFollowed(userId)
                .getFollowed()
                .stream()
                .map(followed -> iPublicacionRepository.devolverPublicaciones(followed.getUserId()))
                .flatMap(Collection::stream)
                .map(publicacion -> publicacionMapper.publicacionAPublicacionDTO(publicacion))
                .collect(Collectors.toList());
        if (listaPublicacionDTO.size() == 0) {
            throw new BadRequestException("Followed/s sin publicaciones.");
        }
        LocalDate fechaActual = LocalDate.now();
        listaPublicacionDTO = listaPublicacionDTO.stream()
                .filter(publicacion -> publicacion.getDate()
                        .isAfter(fechaActual.minusDays(14)))
                .collect(Collectors.toList());
        listaPublicacionDTO = listaPublicacionDTO
                .stream()
                .sorted(Comparator.comparing(PublicacionDTO::getDate)
                        .reversed())
                .collect(Collectors.toList());
        if (listaPublicacionDTO.size() == 0) {
            throw new BadRequestException("Followed/s con publicaciones más antiguas a 2 semanas.");
        }
        publicacionFollowedDTO = new PublicacionFollowedDTO(userId, listaPublicacionDTO);
        return publicacionFollowedDTO;
    }

    @Override
    public PublicacionFollowedDTO listaPublicacionesFollowedAsc(Integer userId) {
        PublicacionFollowedDTO listaPublicacionesFollowed = listaPublicacionesFollowed(userId);
        listaPublicacionesFollowed
                .setPosts(listaPublicacionesFollowed
                        .getPosts()
                        .stream()
                        .sorted(Comparator.comparing(PublicacionDTO::getDate))
                        .collect(Collectors.toList()));
        return listaPublicacionesFollowed;
    }

    @Override
    public PublicacionFollowedDTO listaPublicacionesFollowedDesc(Integer userId) {
        PublicacionFollowedDTO listaPublicacionesFollowed = listaPublicacionesFollowed(userId);
        listaPublicacionesFollowed
                .setPosts(listaPublicacionesFollowed
                        .getPosts()
                        .stream()
                        .sorted(Comparator.comparing(PublicacionDTO::getDate)
                                .reversed())
                        .collect(Collectors.toList()));
        return listaPublicacionesFollowed;
    }

    @Override
    public void realizarPublicacionPromo(PublicacionPromoDTO publicacionPromoDTO) throws BadRequestException {
        controlExistenciaUsuario(publicacionPromoDTO.getUserId());
        if (iPublicacionRepository.devolverPublicacion(publicacionPromoDTO.getIdPost()) != null) {
            throw new BadRequestException("La publicación con ID " + publicacionPromoDTO.getIdPost() + " ya existe. ");
        }
        if (!publicacionPromoDTO.getHasPromo()) {
            throw new BadRequestException("La publicación con ID " + publicacionPromoDTO.getIdPost() + " no está siendo asignada con promoción.");
        }
        if (publicacionPromoDTO.getDiscount() <= 0) {
            throw new BadRequestException("La publicación con ID " + publicacionPromoDTO.getIdPost() + " no está siendo asignada con promoción, inserte un valor mayor a 0 en el descuento.");
        }
        iPublicacionRepository.insertarPublicacionPromo(publicacionMapper.publicacionPromoDTOAPublicacion(publicacionPromoDTO));
    }

    @Override
    public PublicacionPromoCountDTO cantidadPublicacionPromo(Integer userId) {
        controlExistenciaUsuario(userId);
        Long contadorPublicacionPromo = iPublicacionRepository
                .devolverPublicaciones(userId)
                .stream()
                .filter(publicacion -> (publicacion.getHasPromo() && publicacion.getDiscount() > 0))
                .count();
        if (contadorPublicacionPromo == 0) {
            throw new BadRequestException("El usuario con ID " + userId + " no tiene ninguna publicación con productos en promoción.");
        }
        return new PublicacionPromoCountDTO(userId, iUsuarioRepository.devolverUsuario(userId).getUserName(), contadorPublicacionPromo.intValue());
    }

    @Override
    public PublicacionPromoListDTO listaPublicacionesPromo(Integer userId) {
        controlExistenciaUsuario(userId);
        String userName = iUsuarioRepository.devolverUsuario(userId).getUserName();
        List<PublicacionPromoDTO> publicacionPromoDTOLista = iPublicacionRepository
                .devolverPublicaciones(userId)
                .stream()
                .map(publicacion -> publicacionMapper.publicacionAPublicacionPromoDTO(publicacion))
                .filter(publicacionPromoDTO -> publicacionPromoDTO.getHasPromo() && publicacionPromoDTO.getDiscount() > 0)
                .collect(Collectors.toList());
        if (publicacionPromoDTOLista.size() == 0) {
            throw new BadRequestException("El usuario con ID " + userId + " no tiene ninguna publicación con productos en promoción.");
        }
        return new PublicacionPromoListDTO(userId, userName, publicacionPromoDTOLista);
    }
}