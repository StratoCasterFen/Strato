package by.academy.hbutil;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.cfg.*;
 

import by.academy.domain.Criminal;
import by.academy.domain.CriminalEvent;
import by.academy.domain.Role;
import by.academy.domain.User;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(HibernateUtil.class.getName());
	
	static{
	    try{
	      AnnotationConfiguration aconf = new AnnotationConfiguration()
	      .addAnnotatedClass(Criminal.class)
	      .addAnnotatedClass(User.class)
	      .addAnnotatedClass(CriminalEvent.class)
	      .addAnnotatedClass(Role.class);
	      logger.info("Create SessionFactory");
	      Configuration conf = aconf.configure();
	      
	      sessionFactory = conf.buildSessionFactory();
	    } catch (Throwable ex) {         
	    	logger.error("Initial SessionFactory creation failed", ex); 
            throw new ExceptionInInitializerError(ex); 
        }
	}

	public static SessionFactory getSessionFactory() throws HibernateException{
		return sessionFactory;
	}

	public static Session getSession() throws HibernateException {
		// Session session = getSessionFactory().openSession();

		return sessionFactory.openSession();
	}
		    
	public static Session getCurrentSession() throws HibernateException { 
		return sessionFactory.getCurrentSession(); }
}
