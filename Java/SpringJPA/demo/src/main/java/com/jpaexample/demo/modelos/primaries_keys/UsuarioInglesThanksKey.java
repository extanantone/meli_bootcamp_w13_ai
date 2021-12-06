package com.jpaexample.demo.modelos.primaries_keys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Data
@Embeddable
public class UsuarioInglesThanksKey implements Serializable {

    @Column(name = "usuario_ingles_id")
    private Long usuarioInglesId;
    @Column(name = "thanks_id")
    private Long thanksId;
}
