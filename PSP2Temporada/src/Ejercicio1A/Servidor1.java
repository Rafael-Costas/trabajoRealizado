package Ejercicio1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

public class Servidor1 {
	
	public static void main(String[] arg) throws IOException {
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		String cad="";
		System.out.println("Esperando Conexion...");
		Socket ClienteConectado=servidor.accept();
		System.out.println("Cliente conectado");
		PrintWriter fsalida= new PrintWriter(ClienteConectado.getOutputStream(), true);
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(ClienteConectado.getInputStream()));
	
		
	
		String [] conjunto1=null;
		
		while ((cad=fentrada.readLine())!=null) {
	
			System.out.println("Recibiendo una frase: "+cad);
			StringUtils.stripAccents(cad);
			conjunto1=cad.split(" ");
			fsalida.print(separador(conjunto1));
			fsalida.println();
			if(cad.equals("quit"))break;
			
		}
	System.out.println("Cerrando conexion... ");
	fentrada.close();
	fsalida.close();
	ClienteConectado.close();
	servidor.close();
	}// main


	
	
	public static String separador(String [] arr) {
		String res="";
		
		for(int i=0; i<arr.length; i++) {
			for(int a=0; a<arr[i].length(); a++) {
				if(arr[i].charAt(a)!='a' && arr[i].charAt(a)!='e' && arr[i].charAt(a)!='i' && arr[i].charAt(a)!='o' && arr[i].charAt(a)!='u') {
					res+=arr[i].charAt(a);
				}
				res+=" ";
				
			}
		}
	return res;
	}

}
//fin de Ejemplo1Ser
