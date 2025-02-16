package org.apache.maven.EstudioConAntonio;

import org.apache.maven.EstudioConAntonio.Customers;

import java.util.List;

import  org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConsultaProducto {
	 public static void main(String[] args) {
	        // Configura la sesión de Hibernate
	        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customers.class)
	                .buildSessionFactory();
	        Session session = factory.openSession();
	        
	        try {
	            // Inicia la transacción
	            Transaction transaction = session.beginTransaction();
	            
	            // Realiza la consulta para obtener todos los clientes
	            List<Customers> losClientes = session.createQuery("from Customers").getResultList();
	            
	            // Muestra los clientes
	            for (Customers cliente : losClientes) {
	                System.out.println(cliente.getCompanyName() + " - " + cliente.getContactName());
	            }
	            
	            // Commit de la transacción
	            transaction.commit();
	            
	            System.out.println("Consulta realizada con éxito!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Cierra la sesión de Hibernate
	            session.close();
	            factory.close();
	        }
	    }
	}