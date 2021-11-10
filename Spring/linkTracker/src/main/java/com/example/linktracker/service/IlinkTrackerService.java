package com.example.linktracker.service;

import com.example.linktracker.exceptions.NotFoundException;
import com.example.linktracker.model.Link;
import com.example.linktracker.dto.LinkDTO;

import java.util.List;
import java.util.Map;

public interface IlinkTrackerService {

    public LinkDTO createLink(Link link);

    public String getLink(Integer id,String password) throws NotFoundException;

    public List<LinkDTO> linkList();

    public LinkDTO invalidate(Integer id) throws NotFoundException;

}
