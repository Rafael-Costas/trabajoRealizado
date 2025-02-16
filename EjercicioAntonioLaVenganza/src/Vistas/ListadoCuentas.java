package Vistas;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Coordinador;

import ModeloConexion.ConexionBd;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoCuentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Coordinador miCoordinador;
	private Connection con;
	private DefaultTableModel model;
	private ConexionBd bd;
	private JTable table;
	ConexionBd conex= new ConexionBd();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoCuentas frame = new ListadoCuentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListadoCuentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTADO DE CUENTAS");
		lblNewLabel.setBounds(312, 10, 145, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione Cliente\r\n");
		lblNewLabel_1.setBounds(10, 51, 131, 13);
		contentPane.add(lblNewLabel_1);
		JTable table = new JTable(); // Inicializa la tabla

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 565, 150);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		model=new DefaultTableModel();
		model.setColumnCount(0);
		model.setRowCount(0);
		table.setModel(model);
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement s;
				 try {
					 s=con.createStatement();
					 String clienteSeleccionado = (String) comboBox.getSelectedItem();
					 String [ ] coso = clienteSeleccionado.split(" ");
					 System.out.println(clienteSeleccionado);
					ResultSet rs =  s.executeQuery("Select cuCodCuenta, cuCodSucursal, cuSaldo from cliente as c join cuentasCliente"
							+ " as cC on (clDni = ccDni) join cuenta as cu on (cuCodCuenta=ccCodCuenta) where clNombre = \""+coso[0]+"\"");
						
						
						ResultSetMetaData metaData = rs.getMetaData();
						model.setColumnCount(0); // Limpia las columnas existentes

						model.setRowCount(0);
						 
						  for(int i=1;i<=metaData.getColumnCount();i++) {
								model.addColumn(metaData.getColumnName(i));
								
							}
						  Object [] row2 = new Object[metaData.getColumnCount()];
							while(rs.next()) {
							for(int i=1;i<=metaData.getColumnCount();i++) {
								//System.out.println(rsmd.getColumnType(i));
								try {
							
									    row2[i - 1] = rs.getObject(i);
									
								} catch (Exception e1) {
									// TODO Auto-generated catch block
								}
							}
							model.addRow(row2);
								
								
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				
			}
		});
		
		comboBox.setBounds(151, 47, 364, 21);
		contentPane.add(comboBox);
		
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
					    comboBox.addItem(nombreCompleto);
						
					}
				 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
	
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(463, 335, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel\r\n");
		btnNewButton_1.setBounds(630, 335, 85, 21);
		contentPane.add(btnNewButton_1);
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
