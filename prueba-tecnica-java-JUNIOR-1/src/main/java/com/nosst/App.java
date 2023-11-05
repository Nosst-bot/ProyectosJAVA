package com.nosst;

import java.util.Arrays;

public class App {

    //Ejercicio 1:
    //Invertir un string
    private void invertirString(String text) {
//        String[] array = text.split("");
//        StringBuilder newText = new StringBuilder();
//
//        for (int i = array.length; i > 0; i--) {
//            newText.append(array[i -1]);
//        }
//
//        System.out.println(newText);

        String newText = new StringBuilder(text).reverse().toString();
        System.out.println(newText);
    }


    //Ejercicio 2:
    //Validar si un numero es capicua o no
    private void isCapicua(int numero) {
        String stringNumber = String.valueOf(numero);
        String reverseNumber = new StringBuilder(stringNumber).reverse().toString();

        if (stringNumber.equals(reverseNumber)) {
            System.out.println("Es capicua");
        } else {
            System.out.println("No es capicua");
        }
    }

    //Ejercicio 3:
    //Contar la cantidad de caracteres que tengan coincidencia en un texto.
    private void countCharacterTimes(String text) {

    }



    public static void main(String[] args) {
        App app = new App();
        app.invertirString("Primer ejercicio.");
        app.isCapicua(5251);
    }
}
