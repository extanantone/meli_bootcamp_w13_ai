package com.ejerciciolinktracker.demo.service;

import com.ejerciciolinktracker.demo.dto.LinkDTO;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;

public interface LinkServiceI {
    Integer guardarLink(LinkDTO linkDTO);

    String mostrarLink(Integer link,String password);

    Integer cantUsosLink(Integer id);
}
