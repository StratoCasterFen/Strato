package by.academy;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.dbunit.annotation.DataSet;

import by.academy.dao.DaoException;
import by.academy.dao.UserDao;
import by.academy.pojos.Role;
import by.academy.pojos.User;




import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;


@RunWith(UnitilsJUnit4TestClassRunner.class)
public class HiberDbTest {
	static Logger logger= Logger.getLogger(HiberDbTest.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;
	
	@TestDataSource
	private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
    	logger.debug("+Before");
        emf = Persistence.createEntityManagerFactory("hiberpolice_test");
        em = emf.createEntityManager();
    }

    
    @Test
    @DataSet("HiberDbTest.xml")
    public void testGetAll() throws Exception {
    	logger.debug("+testGetUsers");
    	List users = em.createQuery("SELECT u FROM User u").getResultList();
    	/* 3 records in db */
		Assert.assertEquals(4, users.size());
    }
    
    /* many to many*/
    @Test
    public void SaveUserRoles() throws DaoException{
    	logger.info("TEst - SaveUserRoles");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
    	UserDao ud=new UserDao();
    	ud.setEntityManager(em);
		ud.persist(getUser());
        tx.commit();
		List users = em.createQuery("SELECT COUNT(u) FROM User u").getResultList();
		List roles = em.createQuery("SELECT COUNT(r) FROM Role r").getResultList();
		logger.info("now " + users+" users and "+ roles +" roles");
		long sizeU = users.isEmpty() ? 0 : (Long) users.get(0);
		long sizeR = roles.isEmpty() ? 0 : (Long) roles.get(0);
		/* 4-users and 4 roles*/
		org.junit.Assert.assertEquals(4l, sizeU);
		org.junit.Assert.assertEquals(4l, sizeR);
    }
    

    @Test
    public void GetUser() throws DaoException{
    	UserDao ud=new UserDao();
    	ud.setEntityManager(em);
    	User user=ud.getByPK(3);
    	Assert.assertEquals("Marta",user.getUserName());
    	logger.info("GetUser: user name is "+user.getUserName());
    }
    
    
//    @Test
//    public void SaveCascade(){
//    	persistUserPOJO();
//		
//		List users = em.createQuery("SELECT COUNT(u) FROM User u").getResultList();
//		List roles = em.createQuery("SELECT COUNT(r) FROM Role r").getResultList();
//		logger.info(users);
//		long sizeU = users.isEmpty() ? 0 : (Long) users.get(0);
//		long sizeR = roles.isEmpty() ? 0 : (Long) roles.get(0);
//		/* 4-users and 4 roles*/
//		org.junit.Assert.assertEquals(4l, sizeU);
//		org.junit.Assert.assertEquals(4, sizeR);
//    }
    
    
    
    @After
    public void destroy() {
        em.close();
        emf.close();
    }
    
    public void persistRolePOJO() {
    	logger.info("persistRolePOJO");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
     	logger.info("persist");
    	Role role=getRole();
        em.persist(role);
        tx.commit();
    }

	public void persistUserPOJO() {
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

        Set<Role> role = new HashSet<Role>();
        role.add(new Role("Manager"));
        role.add(new Role("Guest"));

        user.setRoles(role);
        logger.info("get "+user);
        return user;
    }
    private Role getRole() {
    	logger.info("getUser");
    	Role role=new Role("Tester");
    	
		return role;
	}
}