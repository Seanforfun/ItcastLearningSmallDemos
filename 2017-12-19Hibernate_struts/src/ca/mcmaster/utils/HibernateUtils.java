package ca.mcmaster.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration cfg;
	private static SessionFactory factory;
	
	static{
		cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory();
	}
	
	public static Session openSession(){
		return factory.openSession();
	}
	
	public static Session getCurrentSession(){
		return factory.getCurrentSession();
	}
}
