package com.link.link.service;

import com.link.link.dto.LinkDTO;
import com.link.link.repositories.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImp implements  LinkService{

    private final LinkRepository linkRepository;

    public LinkServiceImp(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDTO create(LinkDTO link) {
        return linkRepository.save(link);
    }

    @Override
    public LinkDTO redirect(Integer linkId) {
        Optional<LinkDTO> link = linkRepository.findLinkById(linkId);
        link.ifPresent(this::sumMetric);
        return link.orElse(null);
    }

    private void sumMetric(LinkDTO linkDTO) {
        linkDTO.sumCount();
        linkRepository.save(linkDTO);
    }

    @Override
    public LinkDTO redirect(Integer linkId, String password) {
        Optional<LinkDTO> link = linkRepository.findLinkById(linkId);
        LinkDTO result=null;
        if(link.isPresent()){
            result = checkListAndPassword(password,link.get());
        }
        return result;
    }

    private LinkDTO checkListAndPassword(String password, LinkDTO linkDTO) {
        LinkDTO result=null;
        if(linkDTO.getPassword()!= null && linkDTO.getPassword().equals(password)){
            result=linkDTO;
        }
        return  result;
    }

    @Override
    public Integer metrics(Integer linkId) {
        Optional<LinkDTO> link= linkRepository.findLinkById(linkId);
        return link.get().getCount();
    }

    @Override
    public void invalidate(Integer linkId) {
        Optional<LinkDTO> link=linkRepository.findLinkById(linkId);
        link.ifPresent(linkRepository::delete);
    }
}
