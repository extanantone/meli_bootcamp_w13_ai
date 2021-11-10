package com.example.linktracker.service;

import com.example.linktracker.exceptions.NotFoundException;
import com.example.linktracker.model.Link;
import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.exceptions.BadRequestException;
import com.example.linktracker.repository.IlinkTrackerRepository;
import org.springframework.stereotype.Service;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LinkTrackerService implements IlinkTrackerService{

    private IlinkTrackerRepository linkTrackerRepository;




    public LinkTrackerService(IlinkTrackerRepository linkTrackerRepository) {
        this.linkTrackerRepository = linkTrackerRepository;
    }

    public static boolean urlValidator(String url)
    {
        /*validación de url*/
        try {
            new URL(url).toURI();
            return true;
        }
        catch (URISyntaxException exception) {
            return false;
        }

        catch (MalformedURLException exception) {
            return false;
        }
    }




    @Override
    public LinkDTO createLink(Link link) {

        // validar url
        if(!urlValidator(link.getUrl())) {
            throw new BadRequestException("Link "+link.getUrl()+" es invalido");
        }

        if(link.getPassword() == null) {
            throw new BadRequestException("Agregue un password");
        }
        LinkDTO linkDto = new LinkDTO(linkTrackerRepository.createUrl(link));
        return linkDto;
    }

    @Override
    public String getLink(Integer id, String password) throws NotFoundException {

        return linkTrackerRepository.getlink(id,password).getUrl();
    }

    @Override
    public List<LinkDTO> linkList() {
        Map<Integer,Link> links = linkTrackerRepository.linkList();
        List<LinkDTO> linksDto = new ArrayList<>();

        for(Map.Entry<Integer,Link> link : links.entrySet()){
            linksDto.add(new LinkDTO(link.getValue()));
        }

        return linksDto;

    }

    @Override
    public LinkDTO invalidate(Integer id) throws NotFoundException{
        LinkDTO linkDTO = new LinkDTO(linkTrackerRepository.validateLink(id));
        return linkDTO;
    }
}
