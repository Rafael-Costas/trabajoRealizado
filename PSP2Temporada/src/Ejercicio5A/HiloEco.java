package Ejercicio5A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloEco extends Thread {

	BufferedReader fentrada;
	PrintWriter fsalida;
	Socket socket = null;

	public HiloEco(Socket s) {// Constructor
		socket = s;
		// se crean flujos de entrada y salida
		try {
			fsalida = new PrintWriter(socket.getOutputStream(), true);
			fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {// tarea a realizar con el cliente
		String cadena = "";
		while (!cadena.trim().equals("*")) {
			System.out.println("COMUNICO CON: " + socket.toString());
			try {
				cadena = fentrada.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // obtener cadena
			
			fsalida.println(cadena.trim().toUpperCase());
			
			} // fin while
		System.out.println("FIN CON: " + socket.toString());
		fsalida.close();
		try {
			fentrada.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
