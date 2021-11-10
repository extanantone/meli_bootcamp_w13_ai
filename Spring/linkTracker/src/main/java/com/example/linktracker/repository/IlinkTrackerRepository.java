package com.example.linktracker.repository;

import com.example.linktracker.exceptions.NotFoundException;
import com.example.linktracker.model.Link;
import com.example.linktracker.dto.LinkDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IlinkTrackerRepository {

    public Link createUrl (Link link);
    public Link getlink(Integer id,String password) throws NotFoundException;
    public Map<Integer,Link> linkList();
    public Link validateLink(Integer id) throws NotFoundException;

}
