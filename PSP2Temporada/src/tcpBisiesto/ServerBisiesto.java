package tcpBisiesto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ServerBisiesto {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket serversocket = new DatagramSocket(9876);
		byte[] recibidos = new byte [1234];
		byte [] enviados = new byte [1234];
		String cadena;
		 while(true) {
			 System.out.println("Arrancando servidor");
			 recibidos = new byte[1234];
			 DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
			 serversocket.receive(paqRecibido);
			 cadena = new String(paqRecibido.getData());
			 InetAddress IPOrigen = paqRecibido.getAddress();
			 int puerto = paqRecibido.getPort();
			 
			 System.out.println("\tOrigen: "+IPOrigen+" : "+puerto);
			 System.out.println("\nMensaje recibido"+cadena.trim());
			 
			 
			 String mayus = Bisiesto(cadena);
			 enviados =mayus.getBytes();
			 DatagramPacket paqEnviado = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
			 serversocket.send(paqEnviado);
			 if (cadena.trim().equals("salir"))break; 
				
			
		 }
		 serversocket.close();
		 System.out.println("Socket cerrado... ");
	}
	
	public static String Bisiesto(String cad) {
		int año = Integer.parseInt(cad.trim());
		System.out.println("Año recibido: "+cad.trim());
		String respuesta;
		if(año%4==0 && año%100!=0) {
			respuesta="Es bisiesto";
		}else {
			if(año%400==0) {
				respuesta="Es bisiesto";
			}else {
				respuesta="No es bisiesto";
			}
		}
		return respuesta;
	}
	public static String respuestaCliente(String cad) {
	Scanner src= new Scanner(System.in);
	 System.out.println("\tMensaje: ");
	 System.out.println("\nMensaje recibido");
		return "a";
	}
}
