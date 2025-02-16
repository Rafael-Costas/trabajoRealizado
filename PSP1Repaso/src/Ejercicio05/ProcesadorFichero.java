package Ejercicio05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class ProcesadorFichero {
	public static void hacerRecuento(String fichEntrada, String letra,
			String fichSalida) throws FileNotFoundException, IOException {
	BufferedReader br;
	
	br = UitlidadesFicheros.getBufferedReader(fichEntrada);
	PrintWriter pw;
	pw = UitlidadesFicheros.getPrintWriter(fichSalida);
	String lineaLeida;
	lineaLeida = br.readLine();
	int totalVocales = 0;
	//Mientras no queden líneas....
	while (lineaLeida != null) {
	//...recorremos la linea...
	for (int i = 0; i < lineaLeida.length(); i++) {
	char letraLeida = lineaLeida.charAt(i);
	char letraPasada = letra.charAt(0);
	// incrementamos el contador
	if (letraLeida == letraPasada) {
	totalVocales++;
	}
	//fin del if

	}
	//fin del for
	// Pasamos a la siguiente linea
	lineaLeida = br.readLine();
	}
	//Escribimos el total de vocales
	//en el fichero de salida
	pw.println(totalVocales);
	pw.flush();
	//Y cerramos los ficheros
	pw.close();
	br.close();
	//fin del método hacerRecuento
	
}}
