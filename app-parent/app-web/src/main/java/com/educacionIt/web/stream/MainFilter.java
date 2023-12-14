package com.educacionIt.web.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFilter {

	public static void main(String[] args) {
		
		List<Integer> enteros = new ArrayList<>();
		
		enteros.add(-1);
		enteros.add(11);
		enteros.add(16);
		enteros.add(20);
		enteros.add(14);
		
		Integer valor = 15;
		
		List<Integer> enterosMayoresA15 = new ArrayList<>();
		
		for (Integer aux : enteros) {
			if(aux > valor) {
				enterosMayoresA15.add(aux);
			}
		}
		
		System.out.println(enterosMayoresA15);
		System.out.println("-------------------------------");
		
		Stream<Integer> str = enteros.stream(); // transformo el array list en un Stream
		
		str = str.filter(x -> x > 0 && x < 21); //funcion intermedia
		
		str = str.filter(x -> x > valor); //funcion intermedia
		
		//funcion Terminal
		List<Integer> filtrados = str.collect(Collectors.toList());
		System.err.println(filtrados);
		
		System.out.println("-------------------------------");
		
		filtrados = enteros.stream()
				.filter(x -> x > 0 && x < 21)
				.filter(x -> x > valor)
				.collect(Collectors.toList());
		
		System.out.println(filtrados);
	}

}
