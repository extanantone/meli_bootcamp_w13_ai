package com.linktracker.service;

import com.linktracker.dto.LinkDTO;
import com.linktracker.dto.LinkInfoDTO;
import com.linktracker.model.Link;
import com.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    ILinkRepository iLinkRepository;

    public LinkService(ILinkRepository iLinkRepository) {
        this.iLinkRepository = iLinkRepository;
    }

    @Override
    public LinkInfoDTO createLinkInfo(LinkDTO linkDTO) {

        Link link = new Link(linkDTO.getLink(), true, linkDTO.getPassword(), 0);

        LinkInfoDTO res = new LinkInfoDTO();
        res.setLink(linkDTO.getLink());
        res.setId(iLinkRepository.addLink(link));

        return res;

    }

    @Override
    public String verifyLinkExistence(int linkId, String password) throws RuntimeException {

        Link link = iLinkRepository.findById(linkId);

        if (link.getPassword().equals(password) && link.getIsValid()) {
            link.setRedirectsCounter(link.getRedirectsCounter() + 1);
            return link.getLink();
        }

        throw new RuntimeException("El link ingresado no existe o esta fuera de servicio");
    }

    @Override
    public Object getAmountRedirects(int linkID) {

        Link link = iLinkRepository.findById(linkID);

        return link.getRedirectsCounter();

    }

    @Override
    public ResponseEntity<String> invalidateLink(int linkId) {

        Link link = iLinkRepository.findById(linkId);

        link.setIsValid(false);

        return new ResponseEntity(HttpStatus.OK);

    }

}
