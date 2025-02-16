package Ejercicio1Examen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora2 {


	public static ArrayList<String> getLineasFichero(String nombreFichero) throws IOException {
		ArrayList<String> lineas = new ArrayList<String>();
		BufferedReader bfr = getBufferedReader(nombreFichero);
		// Leemos líneas del fichero...
		String linea = bfr.readLine();
		while (linea != null) {
			// Y las añadimos al array
			lineas.add(linea);
			linea = bfr.readLine();
		}
		// Fin del bucle que lee líneas
		return lineas;
	}
	public static BufferedReader getBufferedReader(String nombreFichero) throws FileNotFoundException {
		FileReader lector = new FileReader(nombreFichero);
		BufferedReader bufferedReader = new BufferedReader(lector);
		return bufferedReader;
	}
//Para escrribir en un fichero
	public static PrintWriter getPrintWriter(String nombreFichero) throws IOException {
		PrintWriter printWriter;
		FileWriter fileWriter;
	
		fileWriter = new FileWriter(nombreFichero);
		printWriter = new PrintWriter(fileWriter);
		return printWriter;
	}

	public static void hacerCalculosCondiciones(String fichEntrada, String fichSalida, int maximo) throws IOException {
		
		//1 abrir el fichero infomatica.txt
			ArrayList<String> cantidades = getLineasFichero(fichEntrada);
	int res =0;
	//2 sumar las cantidades de dicho fichero
		for(String s : cantidades) {
		if(Integer.parseInt(s)>maximo)
			res+= Integer.parseInt(s);
		
		}
		//3 guardar el resultado numerico en un fichero llamado
		//totalinformatica.txt
		PrintWriter pw = getPrintWriter(fichSalida);;
		pw.println(res);
		pw.close();
		System.out.println("El total de "+fichEntrada+" es: "+res+" $");
	}


	public static void main(String[] args) {
	
	//	File file = new File("C:\\Users\\rafae\\eclipse-workspace\\PsP\\informatica.txt");
		System.out.println("Fichero de entrada"); //args[0]
		String fichEntrada=args[0]; //src.nextLine();
		
		System.out.println("Fichero de salida");// args[1]
		String fichSal= args[1];//src.nextLine();
		
		System.out.println("Cantidad de corte");
		int rico = Integer.parseInt(args[2]);//src.nextInt();
		try {
			hacerCalculosCondiciones(fichEntrada, fichSal,rico);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		

	
	}
}


