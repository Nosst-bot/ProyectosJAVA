package com.nosst;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

	//Ejercicio1: Revertir un String
	private void e1InvertirString(String texto) {
		String textoInvertido = new StringBuilder(texto).reverse().toString();
		System.out.println(textoInvertido);
	}
	
	//Ejercicio2: Verificar numero capicua
	//   Numero capicua: Numero que se puede leer de igual forma de derecha izquierda o viceversa.
	//   Ejemplo: 1234321
	private void e2NumeroCapicua(int numero) {
		String numeroString = String.valueOf(numero);
		String numeroInvertido = new StringBuilder(numeroString).reverse().toString();
		
		if(numeroString.equals(numeroInvertido)) {
			System.out.println("Es capicua");
		} else {
			System.out.println("No es capicua");
		}
	}
	
	//Ejercicio 3: 
	//Contar coincidencias segun caracteres, sin importar orden
	//Ejemplo: kevin salvatierra
	//k=1, e=2, v=2, i=2, n=1, s=1, a=3, l=1, t=1, r=2 
	private void e3ContarCaracteres(String texto) {
		List<String> listaDeCaracteres = Arrays.asList(texto.split(""));
		Map<String, Long> coincidenciasMap = listaDeCaracteres.stream()
				.filter(c -> !c.equals(" "))
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		
		coincidenciasMap.entrySet().stream()
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
		
	}
	
	//Ejercicio 4: Mostrar solo caracteres repetidos en una cadena
	private void e4ContarCaracteresRepetidos(String texto) {
		List<String> listaDeCaracteres = Arrays.asList(texto.split(""));
		Map<String, Long> coincidenciasMap = listaDeCaracteres.stream()
				.filter(c -> !c.equals(" "))
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		
		coincidenciasMap.entrySet().stream()
			.filter(entry -> entry.getValue() > 1)
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
	}
	
	//Ejercicio 5: Verificar si es multiplo de 2
	private void e5EsMultiplo(int numero) {
		if (numero % 2 == 0) {
			System.out.println("Si es multiplo");
		} else {
			System.out.println("No es multiplo");
		}
	}
	
	//Ejercicio 6: Verificar Año Biciesto
	private void e6IsLeapYear(int year) {
		if (LocalDate.of(year, 1, 1).isLeapYear()) {
			System.out.println("Es bisiesto");
		} else {
			System.out.println("No es bisiesto");
		}
	}
	
	//Ejercicio 7: Recibir un texto y desordenarlo aleatoriamente
	private void e7DesordenarCadena(String texto) {
		List<String> caracteres = Arrays.asList(texto.split(""));
		Collections.shuffle(caracteres);
		
		String textoDesordenado = String.join("", caracteres);
		
		System.out.println(textoDesordenado);
	}
	
	//Ejercicio 8: Alamcenar solo los numeros no duplicados
	private void e8OnlyNotDuplicates(List<Integer> list) {
		Set<Integer> listaSinDuplicados = new HashSet<Integer>(list);	
		
//		listaSinDuplicados.forEach(System.out::println);
		System.out.println(listaSinDuplicados);
	}
	
	//Ejercicio 9: Verificar si el texto tiene una vocal
	private void e9CheckIfVowelIsPresent(String text) {
		/*
		List<String> listaDeCaracteres = Arrays.asList(text.split(""));
		
		boolean contiene = listaDeCaracteres
				.stream()
				.anyMatch(l -> l.matches("[a,e,i,o,u,A,E,I,O,U]"));
		
		System.out.println(contiene);
		*/
		System.out.println(text.matches(".*[aeiouAEIOU].*"));
	}
	
	//Ejercicio 10: Palindromo
	private void e10EsPalindromo(String text) {
		/*
		String textoInvertido = new StringBuilder(text).reverse().toString();
		
		if (text.equalsIgnoreCase(textoInvertido)) {
			System.out.println("Es palindromo");
		} else {
			System.out.println("No es palindromo");
		}
		*/
		
		String textoInvertido = "";
		String[] listaDeCaracteres = text.split("");
		
		for (int i = listaDeCaracteres.length - 1; i >= 0 ; i--) {
			textoInvertido += listaDeCaracteres[i];
		}
		
		if (text.equalsIgnoreCase(textoInvertido)) {
			System.out.println("Es palindromo");
		} else {
			System.out.println("No es palindromo");
		}
	}
	
	public static void main(String[] args) {
		
		App app = new App();
		
		app.e1InvertirString("Kevin Salvatierra");
		app.e2NumeroCapicua(1234321);
		app.e3ContarCaracteres("Kevin Salvatierra");
		app.e4ContarCaracteresRepetidos("Kevin Salvatierra");
		app.e5EsMultiplo(9);
		app.e6IsLeapYear(2024);
		app.e7DesordenarCadena("Kevin");
		app.e8OnlyNotDuplicates(Arrays.asList(1,1,1,2,3,4,5,6,6,7,8,9));
		app.e9CheckIfVowelIsPresent("kvn");
		app.e10EsPalindromo("Oso");
	}
}
