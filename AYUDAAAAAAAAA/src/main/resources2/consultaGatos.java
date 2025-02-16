import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class consultaGatos {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Gatos.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
// Realiza la consulta para obtener todos los gatos
			List<Gatos> losGatos = session.createQuery("from Gatos").getResultList();

// Muestra los gatos
			for (Gatos gato : losGatos) {
				System.out.println("ID: " + gato.getId());
				System.out.println("Nombre: " + gato.getNombre());
				System.out.println("Raza: " + gato.getRaza());
				System.out.println("Foto: " + gato.getFoto());
				System.out.println("--------------------");
			}

// Cierra la transacción
			transaction.commit();

			System.out.println("Hecho!");
		} finally {
			session.close();
			factory.close();
		}
	}
}