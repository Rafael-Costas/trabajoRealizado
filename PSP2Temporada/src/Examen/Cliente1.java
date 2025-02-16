package Examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente1 {

	/*
	 * Prepare un Servidor TCP que reciba como datos UNA CADENA de caracteres, de al
	 * menos 5 palabras, enviadas desde un cliente y prepare la devolución de UNA
	 * CADENA que tenga las mismas palabras pero solamente con las letras
	 * consonantes. Separe métodos de filtro y de servicio. Indica claramente la
	 * forma de desconectar el cliente comprobando que se cierra el servicio.
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
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
		String [] conjunto1=null;
		boolean seguir=true;
		do{
			System.out.println("Introduce una frase de mínimo 5 palabras");
			System.out.println("Introduce quit para que todo termine");
			
			cadena=in.readLine();
			
			if(cadena.split(" ").length>=5) {
			fsalida.println(cadena);
			eco=fentrada.readLine();
			System.out.println(" =>ECO: "+eco);
			}else {
				System.out.println("Introduce una frase más larga");
			}
			if(cadena.equals("quit"))seguir=false;

		}while(seguir); 
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

