package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.entity.Link;

import java.util.Map;

public interface ILinkReposiroty {

    Long getRedirects(Long linkId);

    Link updateLink(Link link);

    Link createLink(String url);

    Link createLink(String url, String pass);

    Link getLinkbyId(Long linkID);

    Boolean isLinkEnabled(Long idLink);

}
