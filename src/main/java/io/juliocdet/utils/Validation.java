package io.juliocdet.utils;

public class Validation {
    public static String validarEdad(int edad) {
        if (edad == 18) {
            return "Apenas eres mayor de edad";
        } else if (edad > 18) {
            return "Eres mayor de edad";
        } else {
            return "Eres menor de edad";
        }
    }
}
