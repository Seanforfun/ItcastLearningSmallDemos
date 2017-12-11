package ca.mcmaster.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtils {
	public static Session getSession(){
		Configuration configure = new Configuration().configure();
		SessionFactory factory = configure.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
}
