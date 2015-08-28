package by.academy;

//import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dbunit.Assertion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.academy.pojos.Role;
import by.academy.pojos.User;


public class JPATests {
	private static Logger logger = LogManager.getLogger(JPATests.class.getName());
    EntityManagerFactory emf;
    EntityManager em;
    
    @Before
    public void init() {
    	logger.info("init");
    	try{
    	 logger.info(emf);	
        emf = Persistence.createEntityManagerFactory("hiberpolice_test");
       
    	}catch (Exception e){
    		 logger.error(e);
    	}
        em = emf.createEntityManager();
    }
    

	@Test
    public void saveTest() throws Exception {
		logger.info("saveTest");
		persistSimplePOJO();
		try {
			List results = em.createQuery("SELECT COUNT(u) FROM User u").getResultList();
			long size = results.isEmpty() ? 0 : (Long) results.get(0);
			
			assertEquals(24L, size);
			logger.error("Users table have "+size+"records");
		} catch (Exception e) {
			logger.error("cant to perform result",e);
			throw new Exception("kk",e);
		}

	}
    

	@Test
    public void manyToManyTest() {
        persistSimplePOJO();
        logger.info("saveTest");
        User user = em.find(User.class, 1l);
        logger.info(user.getUser_role().size());
        assertEquals(2, user.getUser_role().size());
    }
 
    
    @After
    public void destroy() {
        em.close();
        emf.close();
    }
    
    public void persistSimplePOJO() {
    	logger.info("persistSimplePOJO");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
    	logger.info("persist");
    	User user=getUser();
        em.persist(user);
        tx.commit();
    }
    
    public User getUser() {
    	logger.info("getUser");
        User user = new User();
        user.setUserName("Dgordano");
        user.setPassword("fhjfhfhg4df4g654dfg65");

        List<Role> role = new ArrayList<Role>();
        role.add(new Role("Admin"));
        role.add(new Role("Guest"));

        user.setUser_role(role);
        logger.info("get "+user);
        return user;
    }
}
