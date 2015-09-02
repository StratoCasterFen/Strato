package by.academy.hbutil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.cfg.Configuration;

import by.academy.pojos.Criminal;

@SuppressWarnings("deprecation")
public class HibernateUtilbak {
	private static Logger logger = LogManager.getLogger(HibernateUtilbak.class.getName());

//	private static final SessionFactory sessionFactory;
//	private static final Ejb3Configuration ejb3Configuration;
//
//	static {
//		try {
//		//	sessionFactory = new Configuration().configure().buildSessionFactory();
//			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//			ejb3Configuration = new Ejb3Configuration().configure("/hibernate.cfg.xml");
//		} catch (Throwable ex) {
//			logger.error("Initial SessionFactory creation failed." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
//
//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//	public static Session getSession() throws HibernateException {
//		return sessionFactory.openSession();
//	}
//
//	public static Ejb3Configuration getEjb3Configuration() {
//		return ejb3Configuration;
//	}
	//**********
	private static final SessionFactory concreteSessionFactory;
	static {
		try {

			concreteSessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			logger.error("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return concreteSessionFactory.openSession();
	}

	
	
}