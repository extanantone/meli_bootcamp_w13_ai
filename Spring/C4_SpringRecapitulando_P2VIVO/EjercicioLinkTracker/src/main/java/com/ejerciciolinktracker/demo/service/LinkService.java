package com.ejerciciolinktracker.demo.service;

import com.ejerciciolinktracker.demo.dto.LinkDTO;
import com.ejerciciolinktracker.demo.exception.LinkInvalidatedException;
import com.ejerciciolinktracker.demo.exception.NotFoundException;
import com.ejerciciolinktracker.demo.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;

@Service
public class LinkService implements LinkServiceI {
    @Autowired
    LinkRepository linkRepository;

    @Override
    public Integer guardarLink(LinkDTO linkDTO) {
        return linkRepository.guardarLink(linkDTO);
    }

    @Override
    public String mostrarLink(Integer id,String password) {
        String valido = linkRepository.idValido(id,password);
        switch(valido) {
            case "true":
                return linkRepository.obtenerLink(id).getUrl();
            case "invalidated":
                throw new LinkInvalidatedException(id);
            case "notExist":
                return "f";
            default:
                return "fs";
        }
    }

    @Override
    public Integer cantUsosLink(Integer id) {
        return linkRepository.obtenerLink(id).getCantUsos();
    }


}
