package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkDTO;
import com.bootcamp.link_tracker.excepciones.LinkInexistenteException;
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

    @Autowired
    public LinkTrackerService(ILinkTrackerRepository linkTrackerRepository) {
        this.linkTrackerRepository = linkTrackerRepository;
        this.contadorId = 0;
    }

    @Override
    public Integer crearLink(String url, String password){
        if(validarLink(url)){
            contadorId++;
            this.linkTrackerRepository.guardarLink(new Link(contadorId, url, 0, password));
            return contadorId;
        }else{
            throw new LinkInvalidoException();
        }

    }

    //true si el link es valido, false caso contrario
    private boolean validarLink(String link) {
       /* String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        return urlValidator.isValid(link.getUrl());//FIXME

        */
        return true;
    }

    @Override
    //primero chequea si esta el link y luego elimina de la lista
    public void eliminarLink(Integer id){
        Link linkEliminar = this.linkTrackerRepository.buscarLink(id);
        if(linkEliminar == null){
            throw new LinkInexistenteException();
        }
        this.linkTrackerRepository.eliminarLink(linkEliminar);
    }

    @Override
    public Integer getEstadisticas(Integer id) {
        Link linkEstadisticas = this.linkTrackerRepository.buscarLink(id);
        if(linkEstadisticas == null){
            throw new LinkInexistenteException();
        }
        return linkEstadisticas.getCantRedirecciones();
    }
}
