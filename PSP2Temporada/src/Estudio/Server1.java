package Estudio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server1 {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket;
		byte[] bufer = new byte[1024];
		 socket = new DatagramSocket(12345);
		 boolean conf=true;
		 int num=1;
		while(conf) {
		System.out.println("Esperando al datagrama.... ");
		DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
		socket.receive(recibo);
		int byteRec = recibo.getLength();
		String paquete = new String(recibo.getData(), 0, recibo.getLength());
	
		if(paquete.trim().contains("*")) {
			socket.close();
			conf=false;
		}else {
		System.out.println(paquete.trim());
			String respuesta= Bisiesto(paquete.trim());
		
	
		
		System.out.println("Año introducido: "+paquete.trim());
		System.out.println("El año "+respuesta);
		}
		
		}
		
		
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
}
