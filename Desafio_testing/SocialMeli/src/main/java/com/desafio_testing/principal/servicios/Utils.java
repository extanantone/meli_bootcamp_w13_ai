package com.desafio_testing.principal.servicios;

import com.desafio_testing.principal.enumerados.EnumErrs;
import com.desafio_testing.principal.excepciones.NegocioException;

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
        if(!dato.matches("-?\\d{1,3}(\\.\\d{3})*(,\\d{1,2})?"))
            throw new NegocioException(EnumErrs.ERROR_PARSER.repMensaje(dato), EnumErrs.ERROR_PARSER.getCodigo());

            String salida = dato.replaceAll("\\.","");
            salida = salida.replaceAll(",","\\.");
            return Double.valueOf(salida);
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
