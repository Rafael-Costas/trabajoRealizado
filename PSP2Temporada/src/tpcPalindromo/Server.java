package tpcPalindromo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;






public class Server {

	public static void main(String[] arg) throws IOException {
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		String cad="";
		System.out.println("Esperando Conexion...");
		Socket ClienteConectado=servidor.accept();
		System.out.println("Cliente conectado");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter fsalida= new PrintWriter(ClienteConectado.getOutputStream(), true);
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(ClienteConectado.getInputStream()));
		String cadena, eco="";
		
		Calendar calendar;
		
		String ayuda="";
		while ((cad=fentrada.readLine())!=null) {
		ayuda="";
			System.out.println("Recibiendo una palbra: "+cad);
			cad=cad.replace(" ", "");
			cad=cad.replace(",", "");
			StringBuilder sb= new StringBuilder(cad);
			ayuda=sb.reverse().toString();
			
			 StringUtils.stripAccents(cad);
			ayuda=ayuda.toLowerCase();
			cad=cad.toLowerCase();
			System.out.println(cad.trim());
			System.out.println(StringUtils.stripAccents(ayuda));
			System.out.println(cad);
			if(StringUtils.stripAccents(ayuda).compareTo(StringUtils.stripAccents(cad))==0) {
				fsalida.print("Es palindromo");
			}else {
				fsalida.print("No es palindromo");
			}
			
		
			fsalida.println();
			if(cad.equals("quit"))break;
			
		}
	System.out.println("Cerrando conexion... ");
	fentrada.close();
	fsalida.close();
	ClienteConectado.close();
	servidor.close();
	}// main



}
//fin de Ejemplo1Servidor

