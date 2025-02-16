package tcpBisiesto;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class clientBisiesto {
	 public static void main(String[] args) throws Exception {
	        Scanner src = new Scanner(System.in);
	        boolean corta = false;
	        DatagramSocket clienteSocket = new DatagramSocket();
	        byte[] enviados = new byte[1024];
	        byte[] recibidos = new byte[1024];
	        InetAddress ipServido = InetAddress.getLocalHost();
	        int puerto = 9876;

	        while (!corta) {
	            System.out.println("introdyce un Año (Escribe 'salir' para terminar)");
	            String cadena = src.nextLine();
	            if (cadena.equalsIgnoreCase("salir")) {
	                corta = true; // si el usuario escribe "salir", terminamos el bucle
	            } else {
	                enviados = new byte[1024];
	                enviados = cadena.getBytes();
	                System.out.println("Enviando " + enviados.length + " bytes al servidor ");
	                DatagramPacket envio = new DatagramPacket(enviados, enviados.length, ipServido, puerto);
	                clienteSocket.send(envio);
	                DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
	                System.out.println("Esperando al datagrama");
	                clienteSocket.receive(recibo);
	                System.out.println("Mensaje recibido del servidor: " + new String(recibo.getData(), 0, recibo.getLength()));
	            }
	        }
	        clienteSocket.close();
	        src.close();
	    }
	}