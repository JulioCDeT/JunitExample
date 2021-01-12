package io.juliocdet.utils;

import org.junit.Assert;
import org.junit.Test;

public class ValidationTest {

    @Test
    public void validarEdad_TestApenasMayor() {
        String result = Validation.validarEdad(18);
        Assert.assertEquals( "Apenas eres mayor de edad", result);
    }

    @Test
    public void validarEdad_TestEresMayor() {
        String result = Validation.validarEdad(30);
        Assert.assertEquals( "Eres mayor de edad", result);
    }

    @Test
    public void validarEdad_TestEresMenor() {
        String result = Validation.validarEdad(2);
        Assert.assertEquals( "Eres menor de edad", result);
    }
}
