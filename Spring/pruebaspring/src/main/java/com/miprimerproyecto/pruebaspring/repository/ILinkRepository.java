package com.miprimerproyecto.pruebaspring.repository;

import com.miprimerproyecto.pruebaspring.model.Link;

public interface ILinkRepository {


    Link setLink(Link link);
    Link getLink(long id);

}
