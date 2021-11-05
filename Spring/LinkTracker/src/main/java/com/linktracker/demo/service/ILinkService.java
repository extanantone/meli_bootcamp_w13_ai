package com.linktracker.demo.service;

import com.linktracker.demo.DTO.LinkDTO;
import com.linktracker.demo.DTO.LinkInfoDTO;

public interface ILinkService {

    public LinkInfoDTO crearLinkInfo(LinkDTO linkDTO);

    public String verificarExistenciaLink(int idLink, String password);

    Object getCantRedirecciones(int linkID);


    Object invalidarLinkService(int linkId);
}
