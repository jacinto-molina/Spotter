package NJO.NJO.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionHib = buildFactory();
	
	private static SessionFactory buildFactory() {
		try {
			Configuration config = new Configuration();
			return config.configure().buildSessionFactory();
			 
		}catch(Throwable err) {
			throw new ExceptionInInitializerError(err);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionHib;
	}
	
	public static void shutdownl() {
		sessionHib.close();
	}
	

}
