package Ejercicio4A;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente4 {
public static void main(String[] args) throws IOException {
	

	// Se crea el socket multicast
	int Puerto = 12345;// Puerto multicast
	MulticastSocket ms = new MulticastSocket(Puerto);
	InetAddress grupo = InetAddress.getByName("225.0.0.1");// Grupo
	// Nos unimos al grupo
	ms.joinGroup(grupo);
	String msg = "";
	while (!msg.trim().equals("*")) {
		// Recibe el paquete del servidor multicast
		byte[] buf = new byte[1000]; // Genero dentro el

		DatagramPacket paquete = new DatagramPacket(buf, buf.length);
		ms.receive(paquete);
		msg = new String(paquete.getData());
		System.out.println("Recibo: " + msg.trim());
	} // Fin de while
	ms.leaveGroup(grupo); // abandonamos grupo
	// cierra socket
	ms.close();
	System.out.println("Socket cerrado...");
}// Fin de main
}// Fin de ClienteMC

