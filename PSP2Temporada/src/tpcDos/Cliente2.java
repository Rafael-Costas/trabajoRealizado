package tpcDos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente2 {
	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000;// puerto remoto
//	InetAddress i = InetAddress.getByName("10.101.19.19");
		
		Socket Cliente = new Socket(Host, Puerto);
		
		
		// CREO FLUJO DE SALIDA AL SERVIDOR
		PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(),true );
		
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String ayuda="";
		String cadena, eco="";
		System.out.println("Introdyce una cadena");
		cadena=in.readLine();
		while(cadena!=null) {
			
		
			fsalida.println(cadena);
			eco=fentrada.readLine();
			System.out.println(" =>ECO: "+eco);
			System.out.println("Introduce una cadena: ");
			cadena = in.readLine();

		}
	/*	DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
		// ENVIO UN SALUDO AL SERVIDOR
		flujoSalida.writeUTF("SaludOS al SERVIDOR DESDE EL Lord Paco");
		// CREO FLUJO DE ENTRADA AL SERVIDOR
		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
		// EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());
		*/// CERRAR STREAMS Y SOCKETS
		fsalida.close();
		fentrada.close();
		System.out.println("Fin del envio... ");
		in.close();
		Cliente.close();
	}// fin de main

}
