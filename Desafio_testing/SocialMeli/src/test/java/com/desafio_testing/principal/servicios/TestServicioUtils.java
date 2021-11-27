package com.desafio_testing.principal.servicios;

import com.desafio_testing.principal.excepciones.NegocioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestServicioUtils {

    @Test
    public void verifyCleanNumericHappy(){

        Double actual1 = Utils.cleanNumeric("1.000.000.000.000");
        Double actual2 = Utils.cleanNumeric("1.000.000,99");
        Double actual3 = Utils.cleanNumeric("999,99");
        Double actual4 = Utils.cleanNumeric("999.999.999.999.999,00");

        Assertions.assertAll(
                ()->Assertions.assertEquals(1000000000000.00,actual1),
                ()->Assertions.assertEquals(1000000.99,actual2),
                ()->Assertions.assertEquals(999.99,actual3),
                ()->Assertions.assertEquals(999999999999999.00,actual4)
        );
    }

    @Test
    public void verifyCleanNumericSad(){

        Assertions.assertAll(
                ()->Assertions.assertThrows(NegocioException.class,()->Utils.cleanNumeric("1.000.00,00")),
                ()->Assertions.assertThrows(NegocioException.class,()->Utils.cleanNumeric("1.000.000.00,99")),
                ()->Assertions.assertThrows(NegocioException.class,()->Utils.cleanNumeric("9999.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000.000,99")),
                ()->Assertions.assertThrows(NegocioException.class,()->Utils.cleanNumeric("9999,99"))
        );
    }

    @Test
    public void verifymaxminhappy(){

        Double dato = Utils.valValorString("1.000.000.000.000","1000000000000.00","0.00");

        Assertions.assertAll(
                ()-> Assertions.assertDoesNotThrow(()->Utils.valValorString("1.000.000.000.000","1000000000000.00","0.00")),
                ()-> Assertions.assertEquals(1000000000000.00,dato)
        );
    }

    @Test
    public void verifymaxminSad(){

        Assertions.assertAll(
                ()->Assertions.assertThrows(NegocioException.class,()->Utils.valValorString("1.000.000.000.000","100000000.00","0.00")),
                ()->Assertions.assertThrows(NegocioException.class,()->Utils.valValorString("-1.000.000.000.000","10000000000.00","0.00"))
        );
    }



}
