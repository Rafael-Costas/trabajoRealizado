package Departamentos;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JLabel;

public class HiloServidor extends Thread {

	Socket socket;
	int identificador;
	static JLabel texto = new JLabel();
	ObjectOutputStream outObjeto;
	DataInputStream entrada;

	public HiloServidor(Socket s, int idCliente) throws IOException {
		socket = s;
		identificador = idCliente;
		entrada = new DataInputStream(socket.getInputStream());
		outObjeto = new ObjectOutputStream(socket.getOutputStream());
	}

	public void run() {
		try {
			AccesoDatos adat = new AccesoDatos();

			while (true) {
				String depar = entrada.readUTF();

				Departamentos dep = adat.procesarCadena(depar.trim());
				outObjeto.writeObject(dep);
			}
		} catch (IOException e) {
			Servidor.conexiones--;
			Servidor.numconex.setText(Servidor.conexiones.toString());
			texto.setText("<<LIBERADA LA CONEXION: " + identificador + " >>\n");
			texto.setForeground(Color.red);
			Servidor.area.append(texto.getText());

			try {
				entrada.close();
				outObjeto.close();
				socket.close();
			} catch (IOException ee) {
				ee.printStackTrace();
			}
		}
	}
}
