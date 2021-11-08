package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkReqDTO;
import com.bootcamp.link_tracker.excepciones.LinkInexistenteException;
import com.bootcamp.link_tracker.excepciones.LinkInvalidoException;
import com.bootcamp.link_tracker.excepciones.PasswordIncorrectException;
import com.bootcamp.link_tracker.model.Link;
import com.bootcamp.link_tracker.repository.ILinkTrackerRepository;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerService implements ILinkTrackerService{

    private ILinkTrackerRepository linkTrackerRepository;
    private Integer contadorId;

    @Autowired
    public LinkTrackerService(ILinkTrackerRepository linkTrackerRepository) {
        this.linkTrackerRepository = linkTrackerRepository;
        this.contadorId = 0;
    }

    @Override
    public Integer crearLink(LinkReqDTO link){
        if(validarUrl(link.getUrl())){
            contadorId++;
            //al crear el link se setea como valido
            this.linkTrackerRepository.guardarLink(new Link(contadorId, link.getUrl(), 0, link.getPassword(), true));
            return contadorId;
        }else{
            throw new LinkInvalidoException("El link no es valido");
        }
    }

    //true si la url del link es valida, false caso contrario
    private boolean validarUrl(String url) {
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        return urlValidator.isValid(url);
    }

    @Override
    //primero chequea si esta el link y luego lo invalida, NO elimina
    public void invalidarLink(Integer id){
        Link linkInvalidar = this.linkTrackerRepository.buscarLink(id);
        if(linkInvalidar == null){
            throw new LinkInexistenteException("No existe el link");
        }
        linkInvalidar.setValid(false);
    }

    @Override
    public Integer getEstadisticas(Integer id) {
        Link linkEstadisticas = this.linkTrackerRepository.buscarLink(id);
        if(linkEstadisticas == null){
            throw new LinkInexistenteException("No existe el link");
        }
        return linkEstadisticas.getCantRedirecciones();
    }

    @Override
    public String redireccionar(Integer id, String password) {
        Link link = this.linkTrackerRepository.buscarLink(id);
        if(link == null){
            throw new LinkInexistenteException("No existe el link");
        }else if(!link.getPassword().equals(password)){ //se chequea que coincidan las contraseñas
            throw new PasswordIncorrectException("La password es incorrecta");
        } else if(!link.isValid()){
            throw new LinkInvalidoException("El link no es valido");
        }
        link.incrementarRedirecciones();
        return link.getUrl();
    }
}
