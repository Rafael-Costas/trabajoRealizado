package Ejercicio2A;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente2 {
	public static void main(String[] args) throws IOException {
		DatagramPacket envio;
		DatagramSocket socket = null;
		boolean seguir=true;
		InetAddress destino = InetAddress.getLocalHost();
		int port = 12345; // puerto al que envio el datagrama
		byte[] mensaje;
		Scanner src= new Scanner(System.in);
		do {
			System.out.println("Introduce dos números separados por espacio");
			System.out.println("Introduce quit para salir");
			
	String saludo = src.nextLine();
	if(saludo.equals("quit")) {
		System.out.println("Me las piro vampiro");
		mensaje="final".getBytes();
		 envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
		 socket = new DatagramSocket();
		socket.send(envio);
		seguir=false;
	}else {
	if(saludo.split(" ").length!=2) {
		System.out.println("Has introducio más de dos números o menos de dos números");
	}else {
		
		mensaje = saludo.getBytes(); 
		// CONSTRUYO EL DATAGRAMA A ENVIAR
		 envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
		 socket = new DatagramSocket();
		socket.send(envio);
		
	}
	}
		}while(seguir);
		socket.close(); // cierro el socket
		}
}
