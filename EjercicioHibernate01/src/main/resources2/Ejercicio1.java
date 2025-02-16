import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField Nombre;
	private JTextField Descripcion;
	private JButton ConImagen;
	private JTextField Imagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
/**/
	 }
	
	

	/**
	 * Create the frame.
	 */
	public Ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce los datos ");
		lblNewLabel.setBounds(10, 25, 105, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblCategoryId = new JLabel("Category id\r\n");
		lblCategoryId.setBounds(10, 74, 105, 28);
		contentPane.add(lblCategoryId);
		
		JLabel lblCategoryNombre = new JLabel("Category Nombre\r\n");
		lblCategoryNombre.setBounds(10, 126, 105, 28);
		contentPane.add(lblCategoryNombre);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 178, 105, 28);
		contentPane.add(lblDescription);
		
		id = new JTextField();
		id.setBounds(123, 79, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(125, 131, 96, 19);
		contentPane.add(Nombre);
		
		Descripcion = new JTextField();
		Descripcion.setColumns(10);
		Descripcion.setBounds(125, 183, 96, 19);
		contentPane.add(Descripcion);
		
		JButton btnNewButton = new JButton("Subir sencillo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Image a;
				
				 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			     Session session = sessionFactory.openSession();

			     Transaction transaction = null;
			     try {
			         // Inicia una transacción
			         transaction = session.beginTransaction();

			         // Crea y configura una entidad Clientes
			         Categories cliente = new Categories();
			         cliente.setCategoryId(1);
			         cliente.setCategoryName(Nombre.getText());
			         cliente.setDescription(Descripcion.getText());
			      
			         
			       

			         // Guarda la entidad en la base de datos
			        session.save(cliente);
			         
			         session.persist(cliente);

			         // Compromete la transacción
			         transaction.commit();
			     } catch (RuntimeException q) {
			         if (transaction != null) transaction.rollback();
			         q.printStackTrace();
			     } finally {
			         // Cierra la sesión
			         session.close();
			     }
			
			
			}
		});
		btnNewButton.setBounds(10, 312, 105, 21);
		contentPane.add(btnNewButton);
		
		ConImagen = new JButton("Subir complejo");
		ConImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			     Session session = sessionFactory.openSession();

			     Transaction transaction = null;
			     try {
			         // Inicia una transacción
			         transaction = session.beginTransaction();

			         // Crea y configura una entidad Clientes
			         Categories cliente = new Categories();
			         cliente.setCategoryId(1);
			         cliente.setCategoryName(Nombre.getText());
			         cliente.setDescription(Descripcion.getText());
			      cliente.setPicture(Imagen.getText().getBytes());
			    
			    
			       

			         // Guarda la entidad en la base de datos
			        session.save(cliente);
			         
			         session.persist(cliente);

			         // Compromete la transacción
			         transaction.commit();
			     } catch (RuntimeException a) {
			         if (transaction != null) transaction.rollback();
			         a.printStackTrace();
			     } finally {
			         // Cierra la sesión
			         session.close();
			     }
			
			
			}
		});
		ConImagen.setBounds(153, 312, 105, 21);
		contentPane.add(ConImagen);
		
		JLabel lblNewLabel_1 = new JLabel("Imagen");
		lblNewLabel_1.setBounds(10, 236, 69, 13);
		contentPane.add(lblNewLabel_1);
		
		Imagen = new JTextField();
		Imagen.setBounds(123, 233, 96, 19);
		contentPane.add(Imagen);
		Imagen.setColumns(10);
	}
}
