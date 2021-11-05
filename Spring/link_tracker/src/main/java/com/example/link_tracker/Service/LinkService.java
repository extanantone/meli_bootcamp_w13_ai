package com.example.link_tracker.Service;

import com.example.link_tracker.Dto.LinkDto;
import com.example.link_tracker.Dto.ResponeLinkDto;
import com.example.link_tracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    @Autowired
    LinkRepository linkRepository;


    public LinkService() {
    }

    public ResponeLinkDto crearLink(LinkDto link){
        int id = linkRepository.setListaLinks(link);

        ResponeLinkDto responeLinkDto = new ResponeLinkDto(link.getUrl(),id,link.isValido());
        return  responeLinkDto;
    }

    public ResponeLinkDto obtenerDatosEnlace (int linkId){
        LinkDto link = linkRepository.getLink(linkId);
        ResponeLinkDto responeLinkDto = new ResponeLinkDto(link.getUrl(),linkId,link.isValido());
        return responeLinkDto;
    }

    public ResponeLinkDto invalidar (int linkId){
        LinkDto link = linkRepository.invalidar(linkId);
        ResponeLinkDto response = new ResponeLinkDto(link.getUrl(),linkId,link.isValido());
        return response;
    }

}
