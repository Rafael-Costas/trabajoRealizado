package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Coordinador;
import ModeloConexion.ConexionBd;
import modelo.dao.Metodos;
import modelo.vo.cuentaVo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import java.awt.event.ActionEvent;

public class Base extends JFrame {

	private JPanel contentPane;

	private JTextField txtCuenta;
	private JTextField Fecha;
	private JTextField Saldo;
	private Connection con;
	private ConexionBd bd;
	private Coordinador miCoordinador;
	JButton Nuevo;
	JComboBox Sucursal;
	Metodos met= new Metodos();
	ConexionBd conex= new ConexionBd();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	/**
	 * Create the frame.
	 */
	public Base() {
	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de Cuenta");
		lblNewLabel.setBounds(10, 31, 112, 13);
		contentPane.add(lblNewLabel);
		
		txtCuenta = new JTextField();
		txtCuenta.setText("Cuenta");
		txtCuenta.setBounds(132, 28, 266, 19);
		contentPane.add(txtCuenta);
		txtCuenta.setColumns(10);
		
		Fecha = new JTextField();
		Fecha.setColumns(10);
		Fecha.setBounds(132, 170, 82, 19);
		contentPane.add(Fecha);
		
		Saldo = new JTextField();
		Saldo.setColumns(10);
		Saldo.setBounds(321, 170, 77, 19);
		contentPane.add(Saldo);
		
		JComboBox Cliente = new JComboBox();
		Cliente.setBounds(132, 74, 266, 21);
		contentPane.add(Cliente);
		Statement s;
		 try {
			con= conex.getConexion();
			 s=con.createStatement();
			 s.execute("use bancovigo");
			
			ResultSet rs =  s.executeQuery("Select clNombre, clApellido from cliente");
				
				
				ResultSetMetaData metaData = rs.getMetaData(); 
				 while(rs.next()) {
					  String nombre = rs.getString("clNombre");
					    String apellido = rs.getString("clApellido");
					    
					 String nombreCompleto = nombre + " " + apellido;
					    
					    // Agregar el nombre completo al JComboBox
					    Cliente.addItem(nombreCompleto);
						
					}
				 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		 Sucursal = new JComboBox();
		Sucursal.setBounds(132, 113, 266, 21);
		contentPane.add(Sucursal);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente\r\n");
		lblNewLabel_1.setBounds(10, 78, 77, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sucursal");
		lblNewLabel_1_1.setBounds(10, 117, 77, 13);
		contentPane.add(lblNewLabel_1_1);
		
		 try {
			con= conex.getConexion();
			 s=con.createStatement();
			 s.execute("use bancovigo");
			
			ResultSet rs =  s.executeQuery("Select suCiudad from sucursales");
				
				
				ResultSetMetaData metaData = rs.getMetaData(); 
				 while(rs.next()) {
					  String nombre = rs.getString("suCiudad");
					
					    
					 String nombreCompleto = nombre;
					    
					    // Agregar el nombre completo al JComboBox
					    Sucursal.addItem(nombreCompleto);
						
					}
				 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha\r\n");
		lblNewLabel_1_1_1.setBounds(10, 173, 77, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Saldo: ");
		lblNewLabel_1_1_1_1.setBounds(236, 173, 77, 13);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		 Nuevo = new JButton("Nuevo");
		Nuevo.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
			int cuenta= Integer.parseInt(txtCuenta.getText()) ;
			int sucursal =Sucursal.getComponentCount();
		
			
			String fecha = Fecha.getText();
			
		
			

			Date fechaHora = Date.valueOf(fecha);
			//fecha = formatoFecha.parse(fechita);
			int saldo = Integer.parseInt(Saldo.getText());
			cuentaVo cuentaPersona = new cuentaVo() ;
			cuentaPersona.setCuCodCuenta(cuenta);
			cuentaPersona.setCuCodSucursal(sucursal);
			cuentaPersona.setCuFechaCreacion(fechaHora);
			cuentaPersona.setCuSaldo(saldo);
		met.insertarPersona(cuentaPersona);
		
		
			}
		});
		Nuevo.setBounds(480, 27, 85, 21);
		contentPane.add(Nuevo);
		
		JButton Actualizar = new JButton("Actualizar");
		Actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					int cuenta= Integer.parseInt(txtCuenta.getText()) ;
					int sucursal =Sucursal.getComponentCount();
					String fecha = Fecha.getText();
					Date fechaHora = Date.valueOf(fecha);
					//fecha = formatoFecha.parse(fechita);
					int saldo = Integer.parseInt(Saldo.getText());
				
				
				cuentaVo cuentaPersona = new cuentaVo();
				cuentaPersona.setCuCodCuenta(cuenta);
				cuentaPersona.setCuCodSucursal(sucursal);
				cuentaPersona.setCuFechaCreacion(fechaHora);
				cuentaPersona.setCuSaldo(saldo);
				/*try {
					met.Actualizar(cuentaPersona);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		Actualizar.setBounds(480, 74, 85, 21);
		contentPane.add(Actualizar);
		
		JButton Eliminar = new JButton("Eliminar");
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cuenta= Integer.parseInt(txtCuenta.getText()) ;
				
				cuentaVo cuentaPersona = new cuentaVo();
				cuentaPersona.setCuCodCuenta(cuenta);
				//met.Delete(cuentaPersona);
			}
		});
		
		Eliminar.setBounds(480, 113, 85, 21);
		contentPane.add(Eliminar);
		
		JButton Listado = new JButton("Listado\r\n");
		
		Listado.setBounds(480, 169, 85, 21);
		contentPane.add(Listado);
		Listado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			miCoordinador.mostrarVentanaTransacciones();
			}
		});
		JButton Ok = new JButton("Ok\r\n");
		Ok.setBounds(453, 363, 64, 21);
		contentPane.add(Ok);
		
		JButton btnCancel = new JButton("Cancel\r\n");
		btnCancel.setBounds(554, 363, 82, 21);
		contentPane.add(btnCancel);
	}

	

		
	
	
	
}
