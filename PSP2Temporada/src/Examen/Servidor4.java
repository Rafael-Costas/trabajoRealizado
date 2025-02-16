package Examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class Servidor4 {
public static void main(String[] args) throws InterruptedException, IOException {
	

	
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	MulticastSocket ms = new MulticastSocket();
	int Puerto = 12345;
	InetAddress grupo = InetAddress.getByName("225.0.0.1");// Grupo
	String cadena = "";
	while (!cadena.trim().equals("*")) {
		
		cadena = mostrarTiempo();
		Thread.sleep(10000);

		DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, Puerto);
		ms.send(paquete);
	} 
	ms.close();
	System.out.println("Socket cerrado...");

}
public static String mostrarTiempo() {
	Date date = new Date();
   int res=0;
	String horaAct=date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	
	String hora="La hora actual es "+horaAct;
	hora+="\n";
	
	String horas=date.getHours()+"";
	int intHoras=Integer.parseInt(horas);
	String minutos=date.getMinutes()+"";
	int intMinutos=Integer.parseInt(minutos);
	String segundos=date.getSeconds()+"";
	int intSegundos=Integer.parseInt(segundos);

	
	intSegundos+=intMinutos*60;
	intSegundos+=intHoras*3600;
	res=86400-intSegundos;
	hora+="Quedan "+res+" para las 10pm";
	System.out.println(hora);
	
	/*
	 * 1min = 60s
	 * 1hora = 60 minutos
	 * 1 hora = 3600 segundos
	 * 86400
	 * 
	 */
	return hora;

}

}
