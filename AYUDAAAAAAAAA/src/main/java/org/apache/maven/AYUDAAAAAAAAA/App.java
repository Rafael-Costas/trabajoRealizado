package org.apache.maven.AYUDAAAAAAAAA;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml") .addAnnotatedClass(gatos.class) .buildSessionFactory();
     //   SessionFactory sf = new Configuration().configure().buildSessionFactory();
        org.hibernate.Session session= sf.openSession();
        
        session.getTransaction().begin();
        
        gatos coso= new gatos();
        coso.setId(10);
        coso.setNombre("Si");
        coso.setRaza("No importa");
        coso.setFoto("pereza");
      //  session.persist(coso);
        session.merge(coso);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
