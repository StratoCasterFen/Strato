package by.academy.hbutil;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.cfg.*;

import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.Role;
import by.academy.pojos.User;
 
public class HibernateUtilOld {
	
	private static final SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(HibernateUtilOld.class.getName());
	
	static{
	    try{
	      AnnotationConfiguration aconf = new AnnotationConfiguration()
	      .addAnnotatedClass(CriminalEvent.class)
	      .addAnnotatedClass(User.class)
	      .addAnnotatedClass(Criminal.class)
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
