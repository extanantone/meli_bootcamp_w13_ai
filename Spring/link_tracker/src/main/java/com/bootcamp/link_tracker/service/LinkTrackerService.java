package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkDTO;
import com.bootcamp.link_tracker.excepciones.LinkInvalidoException;
import com.bootcamp.link_tracker.model.Link;
import com.bootcamp.link_tracker.repository.ILinkTrackerRepository;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerService implements ILinkTrackerService{

    private ILinkTrackerRepository linkTrackerRepository;
    private Integer contadorId;

    public LinkTrackerService(ILinkTrackerRepository linkTrackerRepository) {
        this.linkTrackerRepository = linkTrackerRepository;
        this.contadorId = 0;
    }

    @Override
    public Integer crearLink(LinkDTO link, String password){
        if(validarLink(link)){
            contadorId++;
            this.linkTrackerRepository.guardarLink(new Link(contadorId, link.getUrl(), 0, password));
            return contadorId;
        }else{
            throw new LinkInvalidoException();
        }

    }

    @Override
    private boolean validarLink(LinkDTO link) {
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        return urlValidator.isValid(link.getUrl());
    }

    @Override
    public void invalidarLink() {

    }
}
