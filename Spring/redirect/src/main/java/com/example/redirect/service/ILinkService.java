package com.example.redirect.service;

import com.example.redirect.dto.LinkDTO;

public interface ILinkService {

    public Integer createLink(LinkDTO link);

    public String getRedirection(Integer linkid, String pass);

    public Integer  getMetrics(Integer linkid);

    public String invalideteLink(Integer linkid);
}