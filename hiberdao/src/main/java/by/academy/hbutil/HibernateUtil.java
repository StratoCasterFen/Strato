package by.academy.hbutil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.ejb.Ejb3Configuration;

import by.academy.pojos.Criminal;

public class HibernateUtil {
	private static Logger logger = LogManager.getLogger(HibernateUtil.class.getName());

	private static final SessionFactory sessionFactory;
	private static final Ejb3Configuration ejb3Configuration;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			ejb3Configuration = new Ejb3Configuration().configure("/hibernate.cfg.xml");
		} catch (Throwable ex) {
			logger.error("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	public static Ejb3Configuration getEjb3Configuration() {
		return ejb3Configuration;
	}
}