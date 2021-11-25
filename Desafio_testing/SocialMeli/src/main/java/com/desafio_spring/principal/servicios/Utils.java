package com.desafio_spring.principal.servicios;

import com.desafio_spring.principal.enumerados.EnumErrs;
import com.desafio_spring.principal.excepciones.NegocioException;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * clase par ahacer operaciones trasnversales
 */
public class Utils {

    /**
     * tiene por objetivo dejar el numero limpio
     * @param dato
     * @return
     */
    public static Double cleanNumeric(String dato){
        String salida = dato.replaceAll("\\.","");
        salida = salida.replaceAll(",","\\.");
        try{
            return Double.valueOf(salida);
        } catch(Exception e)
        {
            throw new NegocioException(EnumErrs.ERROR_PARSER.repMensaje(dato), EnumErrs.ERROR_PARSER.getCodigo());
        }
    }

    public static Double valValorString(String numeroFormato,String maxValor, String minValor){
        Double actual = cleanNumeric(numeroFormato);
        if(actual.compareTo(Double.parseDouble(maxValor))==1)
            throw new NegocioException(EnumErrs.VALOR_MAX_EXCEDIDO.repMensaje(maxValor,numeroFormato), EnumErrs.VALOR_MAX_EXCEDIDO.getCodigo());
        if(actual.compareTo(Double.parseDouble(minValor))<0)
            throw new NegocioException(EnumErrs.VALOR_MIN_EXCEDIDO.repMensaje(minValor,numeroFormato), EnumErrs.VALOR_MIN_EXCEDIDO.getCodigo());
        else
            return actual;
    }
}
