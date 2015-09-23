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

import by.academy.dao.*;
import by.academy.dao.exception.DaoException;
import by.academy.dao.inter.CustomUserDao;
import by.academy.hbutil.ConvertDate;
import by.academy.pojos.*;

import java.util.Calendar;
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
    	logger.info("+testGetUsers");
    	List users = em.createQuery("SELECT u FROM User u").getResultList();
    	/* 3 records in db +1 add*/
		Assert.assertEquals(1, users.size());
    }
    
    /* many to many*/
    
    @Test
    public void SaveUserRoles() throws DaoException{
    	logger.info("TEST: SaveUserRoles");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
    	UserDao ud=new UserDao();
    	ud.setEntityManager(em);
		ud.persist(getUser());
        tx.commit();
		List users = em.createQuery("SELECT COUNT(u) FROM User u").getResultList();
		List roles = em.createQuery("SELECT COUNT(r) FROM Role r").getResultList();
		logger.debug("now " + users+" users and "+ roles +" roles");
		long sizeU = users.isEmpty() ? 0 : (Long) users.get(0);
		long sizeR = roles.isEmpty() ? 0 : (Long) roles.get(0);
		/* 4-users and 4 roles*/
		org.junit.Assert.assertEquals(4l, sizeU);
		org.junit.Assert.assertEquals(4l, sizeR);
    }
    

    @Test
    public void GetUser() throws DaoException{
    	logger.info("TEST: GetUser");
    	CustomUserDao ud=new UserDao();
    	ud.setEntityManager(em);
    	UserDao ud1=(UserDao)ud;
    	User user=ud1.getByPK(3);
    	Assert.assertEquals("Marta",user.getUserName());
    	logger.debug("GetUser: user name is "+user.getUserName());
    }
    
    @Test
    public void GetUsersByRoleName(){
    	logger.info("TEST: GetUsersByRoleName");
    	String s="SELECT DISTINCT u FROM User u INNER JOIN u.roles r WHERE r.roleName = 'Looser'";
    	List users = em.createQuery(s).getResultList();
    	org.junit.Assert.assertEquals(0l, users.size());
    	logger.debug(users);
    }
    
    @Test
    public void GetRolesByUserName(){
    	logger.info("TEST: GetRolesByUserName");
    	String s="SELECT DISTINCT r FROM Role r INNER JOIN r.users u WHERE u.username = 'Tom'";
    	List roles = em.createQuery(s).getResultList();
    	org.junit.Assert.assertEquals(2l, roles.size());
    	logger.debug(roles);
    }
    
    
	@Test
	public void DeleteUser() throws DaoException {
		logger.info("TEST: DeleteUser");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		UserDao ud=GetUserDao();
		ud.delete(ud.getByPK(3));
		tx.commit();
		List users = em.createQuery("SELECT u FROM User u WHERE u.id=3").getResultList();
		List roles = em.createQuery("SELECT COUNT(r) FROM Role r").getResultList();
		logger.debug(users);
		long sizeR = roles.isEmpty() ? 0 : (Long) roles.get(0);
		/* 0-users and 2 roles */
		org.junit.Assert.assertEquals(0, users.size());
		org.junit.Assert.assertEquals(2l, sizeR);
	}
    
	@Test
	public void TestGetUserByName() throws DaoException{
		logger.info("TEST: TestGetUserByName");
		CustomUserDao ud = new UserDao();
		ud.setEntityManager(em);
		User user=ud.getUserByName("Tom");
		logger.debug(user);
		Assert.assertEquals("Tom", user.getUserName());
	}
	
//	@Test
//	public void TestGetUserByNameAndPassword() throws DaoException{
//		CustomUserDao ud = new UserDao();
//		ud.setEntityManager(em);
//		User user=ud.getUserByNameAndPassword(getUser());
//		logger.info(user);
//		Assert.assertEquals("Tom", user.getUserName());
//	}

    @Test
    public void GetCriminal() throws DaoException{
    	logger.info("TEST: GetCriminal");
    	CustomCriminalDao cd=new CriminalDao();
    	cd.setEntityManager(em);
    	Criminal criminal=cd.getByPK(2);
    	Assert.assertEquals("Bobo",criminal.getCriminalName());
    	logger.debug("criminal name is "+criminal.getCriminalName());
    }
    
    @Test
    public void GetEventsByDate() throws DaoException{
    	logger.info("TEST: GetEventsByDate");
    	CustomEventDao ce=new EventDao();
    	ce.setEntityManager(em);
    	Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.AUGUST, 30);
        java.util.Date date = cal.getTime();
        java.sql.Date sqlDate = ConvertDate.convert(date);
    	List<CriminalEvent> events=ce.getEventsByDate(sqlDate);
    	Assert.assertEquals(1,events.size());
    	logger.debug("criminal events by date: "+events);
    }
    
    
    
    @After
    public void destroy() {
        em.close();
        emf.close();
    }
    
    public UserDao GetUserDao(){
    	UserDao ud = new UserDao();
		ud.setEntityManager(em);
		return ud;
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