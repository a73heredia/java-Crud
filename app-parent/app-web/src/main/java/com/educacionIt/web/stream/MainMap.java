package com.educacionIt.web.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMap {

	public static void main(String[] args) {
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(11);
		enteros.add(16);
		enteros.add(20);
		enteros.add(14);
	
		
		Integer valor = 18;
		
		//filtrados
		List<Integer> mayores = new ArrayList<>();
		for (Integer aux :  enteros) {
			if(aux > valor) {
				mayores.add(aux);
			}
		}
		
		System.out.println(mayores);
		
		// Transformar a un string
		
		List<String> enterosAString = new ArrayList<>();
		
		for (Integer aux : mayores) {
			enterosAString.add("Edad " + aux);
		}
		
		System.out.println(enterosAString);
		
		System.out.println("--------------------------------------");
		System.out.println("-----------Con Streams----------------");
		System.out.println("--------------------------------------");
		
		//filtro 
		List<Integer> mayores1 = enteros.stream()
				.filter(aux -> aux > valor)
				.collect(Collectors.toList());
		
		System.out.println(mayores1);
		
		List<String> enterosAString2 = mayores.stream()
				.map(valorEntrante -> new String("Edad " + valorEntrante))
				.collect(Collectors.toList());
		
		
		System.out.println(enterosAString2);
		
		System.out.println("--------------------------------------");
		System.out.println("-----------Con Streams(1 paso--------");
		System.out.println("--------------------------------------");
		
		
		List<String> mayoresAString = enteros.stream()
				.filter(aux -> aux > valor) // funcion intermedia
				.map(valorEntrante -> new String("Edad " + valorEntrante)) // funcion intermedia
				.collect(Collectors.toList()); //funcion terminal
		
		System.out.println(mayoresAString);
		
	}

}
