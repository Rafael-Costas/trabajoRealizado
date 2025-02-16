package Examen_24_03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Ejercicio6B {

	public static void main(String[] args) {
		/*
		 * Escribe un programa que genere una secuencia de 5 cartas de la baraja
		 * francesa de palos (corazones, diamantes, picas y tréboles) y números
		 * (A,K,Q,J,10,9,8,7,6,5,4,3,2) sin que se repita ninguna. El valor de las
		 * cartas se debe guardar en una estructura HashMap que debe contener parejas
		 * (número, valor). El valor de las cartas es el siguiente: as → 20, K,Q,J → 15,
		 * el resto de cartas su número. La secuencia de cartas debe ser una estructura
		 * de la clase ArrayList que contiene objetos de la clase Carta. Se deberá
		 * listar la mano de cinco cartas ordenadas por PALO y NÚMERO SEGÚN EL ENUNCIADO
		 * y a continuación el total de puntos de la mano
		 */
		HashMap<String, Integer> resultado = new HashMap<>();

		resultado.put("A", 20);
		resultado.put("K", 15);
		resultado.put("Q", 15);
		resultado.put("J", 15);
		resultado.put("10", 10);
		resultado.put("9", 9);
		resultado.put("8", 8);
		resultado.put("7", 7);
		resultado.put("6", 6);
		resultado.put("5", 5);
		resultado.put("4", 4);
		resultado.put("3", 3);
		resultado.put("2", 2);
		
		ArrayList<Carta> cartas = new ArrayList();
		Carta c = new Carta();

		cartas.add(c);
		do {
			Carta m = new Carta();
			if (cartas.contains(m)) {
				System.out.println("Repetida");
			} else {
				cartas.add(m);

			}

		} while (cartas.size() < 5);
		Integer num=0;
		
		for (Carta carta : cartas) {
			num+=resultado.get(carta.getNumero());
			
				
			}
		for (Carta carta : cartas) {
			System.out.println(carta);	
			}
	
		System.out.println("El resultado es " +num);
		
		

	}

}
