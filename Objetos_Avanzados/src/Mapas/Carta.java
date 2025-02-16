package Mapas;

import java.util.Arrays;
import java.util.Objects;

public class Carta {

	String [] palo = {"Espada", "Moneda", "Copa", "Palo"};
	String[] numero = {"1","2","3","4","5","6","7","Sota","Caballo","Rey"};
	
	String Numero;
	String Palo;
	public Carta() {
		this.Numero=numero[generaNumero()];
		this.Palo=palo[generaPalo()];
	}
	public int generaNumero(){
		int valor= (int) (Math.random()*10);
	
		return valor;
	}
	public int generaPalo(){
		int valor= (int) (Math.random()*4);
		
		return valor;
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
