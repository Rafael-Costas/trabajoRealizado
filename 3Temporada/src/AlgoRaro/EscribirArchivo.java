package AlgoRaro;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirArchivo {

	public static void main(String[] args) {
		FileWriter archivo= null;
		PrintWriter impresor= null;
		
		try{
			archivo = new FileWriter("C:\\Users\\rafae\\eclipse-workspace\\3Temporada\\src\\AlgoRaro\\prueba2.txt");
			impresor = new PrintWriter(archivo);
			for(int i=0; i<10; i++) 
				impresor.println("abc "+i);
			}catch ( Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(archivo !=null) 
						archivo.close();
					}catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			
		}
	}
