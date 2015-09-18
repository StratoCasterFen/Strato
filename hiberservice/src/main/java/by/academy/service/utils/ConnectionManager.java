package by.academy.service.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import by.academy.dao.exception.DaoException;
import by.academy.hbutil.ReadProperty;

public class ConnectionManager {
	protected static EntityManager em;
	protected static EntityManagerFactory emf;
	static String UNIT_NAME;
	
	public static EntityManager getEntityManager() throws DaoException {

		ReadProperty.setPfilename("connectcfg");
		UNIT_NAME=ReadProperty.getValue("persistence-unit");
		emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		em = emf.createEntityManager();
		return em;
	}

	public static void Close(){
        em.close();
        emf.close();
	}	
}
