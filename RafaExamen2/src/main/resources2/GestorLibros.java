import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GestorLibros {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Libro.class)
                .buildSessionFactory();
        Session session = factory.openSession();
        
        try {
            // Inicia la transacción
            Transaction transaction = session.beginTransaction();
            
            // Realiza la consulta para obtener todos los empleados
            List<Libro> libro = session.createQuery("from Libro").getResultList();
            
            // Muestra los empleados
            for (Libro libros : libro) {
                System.out.println(libros.getId()+ ", " + libros.getTitulo() + ", " + libros.getAutor()+", "+libros.getAñoPublicacion());
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
