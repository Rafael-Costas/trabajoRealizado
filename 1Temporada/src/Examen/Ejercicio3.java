package Examen;

import java.util.Scanner;

public class Ejercicio3 {

	
	public static double KiloALibras(double kilos) {
		double Libras = (kilos*1)/0.453;
		return Libras;
	}
	public static double KiloAStones(double kilos) {
		double Libras = (kilos*14)/6.35;
		return (Libras*1)/14;
	}
	
	public static double LibrasAKilos(double libras) {
		
		return (libras *0.453)/1;
	}
	public static double StonesAKilos(double stones) {
		
		return (stones*6.35)/1; 
	}
	
	public static void main(String[] args) {
		/*
		 * Método que introduzca el peso en Kg de una persona y lo convierta a su
		 * cantidad equivalente en stones y libras. 1 stone (st) = 14 lb = 6,35 kg 1
		 * libra (lb) = 0,453 g Método que introduzca el peso en stones y libras y
		 * devuelva su cantidad equivalente en kilos.
		 */
		Scanner src= new Scanner(System.in);
		
		System.out.println("Si quieres pasar de kg a libras y stones pulse 1");
		System.out.println("Si quieres pasar de libras  a kg pulse 2");
		System.out.println("Si quieres pasar de Stones  a kg pulse 3");
		int opc=src.nextInt();
		
		
		switch (opc) {
		case 1: 
			System.out.println("Introduce los kg");
			double kg=src.nextDouble();
			System.out.println("El peso en libras es "+ KiloALibras(kg));
			System.out.println("El peso en Stones es "+ KiloAStones(kg));
			break;
		
		case 2:
			System.out.println("introduce las libras");
			double Libras=src.nextDouble();
			System.out.println("El peso en kh es "+ LibrasAKilos(Libras));
			break;
			
		case 3:
			System.out.println("Introduce los stones");
			double Stones =src.nextDouble();
			System.out.println("El peso en kg es "+StonesAKilos(Stones));
			
		break;
		}
		
		
		
	
	}
}
