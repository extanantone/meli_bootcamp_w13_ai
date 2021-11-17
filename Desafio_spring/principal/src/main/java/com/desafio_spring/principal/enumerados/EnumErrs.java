package com.desafio_spring.principal.enumerados;

import com.desafio_spring.principal.excepciones.NegocioException;

public enum EnumErrs {

        /**El id: {}, no existe en la API, registralo por favor.*/
        NOT_FOUND(101,"El id: {}, no existe en la API, registralo por favor."),
        /**El id: {}, ya existe en la API, no se puede registrar.*/
        DUPLICATED(102,"El id: {}, ya existe en la API, no se puede registrar."),
        /**"Imposible entregar el mensaje de salida del error, error interno 104"*/
        ERROR_CASTEO(104,"Imposible entregar el mensaje de salida del error, error interno 104"),
        /**"ya sigues al id: {}."*/
        ALREADY_FOLLOWED(105,"ya sigues al id: {}."),
        /**"No se reconoce el valor {} del campo order"*/
        PARAMETER_NOT_FOUND(106,"No se reconoce el valor {} del campo order"),

    ;


    private Integer codigo;
    private String mensaje;

    EnumErrs(Integer codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }


    public String repMensaje(Object...mensajes){
        String salida = this.mensaje;
        try{
            for(Object mensaje:mensajes)
            {
                salida = salida.replaceFirst("\\{\\}",String.valueOf(mensaje));
            }
            return salida;
        }catch(Exception e)
        {
            throw new NegocioException(EnumErrs.ERROR_CASTEO.getMensaje(), EnumErrs.ERROR_CASTEO.getCodigo());
        }
    }
}
