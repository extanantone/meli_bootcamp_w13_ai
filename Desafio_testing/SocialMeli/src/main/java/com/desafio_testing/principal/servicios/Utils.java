package com.desafio_testing.principal.servicios;

import com.desafio_testing.principal.enumerados.EnumErrs;
import com.desafio_testing.principal.excepciones.NegocioException;

/**
 * Clase para hacer operaciones transversales
 */
public class Utils {

    private Utils() {
    }

    /**
     * Tiene por objetivo dejar el número limpio, para poder realizar operaciones matemáticas con él, convirtiendo el dato de String a Double
     * @param dato : numero en String que tiene formato -###.###.###,##
     * @return : retorna el número en Double
     */
    public static Double cleanNumeric(String dato){
        if(!dato.matches("-?\\d{1,3}(\\.\\d{3})*(,\\d{1,2})?"))
            throw new NegocioException(EnumErrs.ERROR_PARSER.repMensaje(dato), EnumErrs.ERROR_PARSER.getCodigo());

            String salida = dato.replace("\\.","");
            salida = salida.replace(",","\\.");
            return Double.valueOf(salida);
    }

    /**
     * Convierte un número en String a Double y verifica los maximo y minimos ingresados
     * @param numeroFormato numero en String que tiene formato -###.###.###,##
     * @param maxValor valor Máximo válido para el número ingresado
     * @param minValor valor Mínimo válido para el número ingresado
     * @return Retorna el valor en Double
     */
    public static Double valValorString(String numeroFormato,String maxValor, String minValor){
        Double actual = cleanNumeric(numeroFormato);
        if(actual.compareTo(Double.parseDouble(maxValor))>0)
            throw new NegocioException(EnumErrs.VALOR_MAX_EXCEDIDO.repMensaje(maxValor,numeroFormato), EnumErrs.VALOR_MAX_EXCEDIDO.getCodigo());
        if(actual.compareTo(Double.parseDouble(minValor))<0)
            throw new NegocioException(EnumErrs.VALOR_MIN_EXCEDIDO.repMensaje(minValor,numeroFormato), EnumErrs.VALOR_MIN_EXCEDIDO.getCodigo());
        else
            return actual;
    }
}
