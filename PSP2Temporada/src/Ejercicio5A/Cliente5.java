package Ejercicio5A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente5 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
	String Host = "localhost";
int Puerto = 6000;// puerto remoto
//InetAddress i = InetAddress.getByName("10.101.19.19");
	
	Socket Cliente = new Socket(Host, Puerto);
	
	
	// CREO FLUJO DE SALIDA AL SERVIDOR
	PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(),true );
	
	BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	String ayuda="";
	String cadena, eco="";
	boolean seguir=true;
	do{
		System.out.println("Introduce una frase");
		System.out.println("Para terminar introduce *");
		cadena=in.readLine();
	
		fsalida.println(cadena);
		eco=fentrada.readLine();
		System.out.println("Lo que has enviado en mayúsculas es : "+eco);
	
		if(cadena.equals("*"))seguir=false;

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
	System.exit(0);// fin
}// fin de main

}

