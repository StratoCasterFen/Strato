package by.academy.hbutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import by.academy.dao.DaoException;
import by.academy.hbutil.ReadProperty;

public class ConnectionManager {
	protected EntityManager em;
	protected EntityManagerFactory emf;
	final String UNIT_NAME=new ReadProperty("connectcfg").getValue("persistence-unit");;
	 
	ConnectionManager() throws DaoException{
		//String i= new ReadProperty("connectcfg").getValue("persistence-unit");
		//String QUERY = RP.getValue("CriminalByName");
		emf = Persistence.createEntityManagerFactory(UNIT_NAME);
		em = emf.createEntityManager();
	}	
	
	public EntityManager getEntityManager() {
		return em;
	}

	public void Close(){
        em.close();
        emf.close();
	}
	
}
