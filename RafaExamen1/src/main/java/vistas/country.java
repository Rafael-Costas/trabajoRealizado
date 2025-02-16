package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Coordinador;
import modelo.Country;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class country extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pais;
	private Coordinador cor;
	public void setCoordinador(Coordinador miCoordinador) {
		this.cor=miCoordinador;
		
	}
	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	public country() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduzca el país\r\n");
		lblNewLabel.setBounds(196, 25, 113, 13);
		contentPane.add(lblNewLabel);
		
		pais = new JTextField();
		pais.setBounds(187, 61, 96, 19);
		contentPane.add(pais);
		pais.setColumns(10);
		
		JButton subir = new JButton("Aceptar\r\n");
		subir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String res= pais.getText();
			System.out.println(res);
			if(pais.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Tienes que introducir un pais","Informaci�n",JOptionPane.INFORMATION_MESSAGE);
			}else {
			Country pais = new Country();
			/*
			 * El id no es autoincremental
			 */
			
			pais.setId(0);
			pais.setPais(res);
			pais.setFecha("2006-02-15 04:44:00");
			cor.subir(pais);
			}
			
			}
		});
		subir.setBounds(196, 130, 85, 21);
		contentPane.add(subir);
	}
}
