package modelo;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import controlador.Coordinador;



public class añadirDao {
	
	Coordinador cor;
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.cor=miCoordinador;
		
	}
	public void registrarPersona(gatos Gatos)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO persona VALUES ('"+Gatos.getId()+"', '"
					+Gatos.getNombre()+"', '"+Gatos.getRaza()+"', '"
					+Gatos.getFoto()+")");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Informaci�n",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
}
