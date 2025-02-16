package Examen_24_03;

import java.util.Objects;
/*
Escribe un programa que genere una secuencia de 5 cartas de la
baraja francesa de palos (corazones, diamantes, picas y tréboles) y
números (A,K,Q,J,10,9,8,7,6,5,4,3,2) sin que se repita ninguna.*/

public class Carta {

	String [] palo = {"corazones", "diamantes", "picas", "tréboles"};
	String[] numero = {"A","K","Q","J","10","9","8","7","6","5", "4", "3", "2"};
	
	String Numero;
	String Palo;
	public Carta() {
		this.Numero=numero[generaNumero()];
		this.Palo=palo[generaPalo()];
	}
	public int generaNumero(){
		int valor= (int) (Math.random()*13);
	
		return valor;
	}
	public int generaPalo(){
		int valor= (int) (Math.random()*4);
		
		return valor;
	}
	
	
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getPalo() {
		return Palo;
	}
	public void setPalo(String palo) {
		Palo = palo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Numero, Palo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return Objects.equals(Numero, other.Numero) && Objects.equals(Palo, other.Palo);
	}
	@Override
	public String toString() {
		return "Carta Numero=" + Numero
				+ ", Palo=" + Palo + "]";
	}
	
}
