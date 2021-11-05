package com.c4.p2.service;

import com.c4.p2.dto.LinkCreatorDto;
import com.c4.p2.dto.LinkIdDto;
import com.c4.p2.dto.RedireccionesDto;
import com.c4.p2.exceptions.NotFoundException;
import com.c4.p2.model.Link;
import com.c4.p2.repository.ILinkRepository;
import com.c4.p2.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkIdDto nuevoLink(LinkCreatorDto linkCreatorDto) {
        return new LinkIdDto(linkRepository.nuevoLink(new Link(0, linkCreatorDto.getUrl(), false, 0, linkCreatorDto.getPass())));
    }

    @Override
    public String permiteRedireccion(Integer id, String pass) {
        Link link = linkRepository.obtenerLink(id);

        if (link.getPass().equals(pass) && !link.getInvalido()){
            link.sumarRedireccion();
            linkRepository.actualizarLink(link);
            return link.getUrl();
        }

        return null;
    }

    @Override
    public RedireccionesDto obtenerEstadisticas(Integer id) throws NotFoundException {
        Link link = linkRepository.obtenerLink(id);

        if (link == null)
            throw new NotFoundException("No se ha encontrado el link con ese id");

        return new RedireccionesDto(linkRepository.obtenerLink(id).getRedirecciones());
    }

    @Override
    public void invalidarLink(Integer id) throws NotFoundException {
        Link link = linkRepository.obtenerLink(id);

        if (link == null)
            throw new NotFoundException("No se ha encontrado el link con ese id");

        link.setInvalido(true);
        linkRepository.actualizarLink(link);
    }
}
