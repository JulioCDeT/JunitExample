package io.juliocdet.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest {

    @BeforeClass
    public static void init() {
        System.out.println("Este metodo se ejecuta antes de todo");
    }

    @Before
    public void setup() {
        System.out.println("Este metodo se ejecuta antes de cada test");
    }

    @After
    public void postConfig() {
        System.out.println("Este metodo se ejecuta despues de cada test");
    }

    @AfterClass
    public static void afterAll() {
        System.out.println("Este metodo se ejecuta despues de todos los test");
    }



    @Test
    public void sumar_TestPositivo () {
        Assert.assertEquals("Sumar 2 mas 2 deverias dar 4", 4, Calculadora.suma(2, 2));
    }

    @Test
    public void sumar_TestNegativo () {
        Assert.assertNotEquals( 5, Calculadora.suma(1, 1));
    }

    @Test
    public void resta_TestPositivo () {
        Assert.assertEquals(7, Calculadora.resta(9, 2));
    }

    @Test
    public void resta_TestNegativo () {
        Assert.assertNotEquals(3, Calculadora.resta(12, 4));
    }

    @Test
    public void division_TestPositive() {
        Assert.assertEquals(5, Calculadora.division(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void division_TestDivisionPorCero() {
        Calculadora.division(10, 0);
    }

    @Test
    public void multiplicar_test() {
        Assert.assertEquals(20, Calculadora.multiplicar(4, 5));
    }

}
