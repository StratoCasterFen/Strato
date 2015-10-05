package by.academy;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.academy.dao.iRepo.UserRepo;
import by.academy.dao.impl.RoleServiceImpl;
import by.academy.dao.interf.CriminalEventService;
import by.academy.dao.interf.CriminalService;
import by.academy.dao.interf.RoleService;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.service.cfg.ServiceCfg;
import by.academy.service.interf.UserService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceCfg.class)
public class AppTest {
	 private Logger logger = LogManager.getLogger(AppTest.class.getName());
	 
	 @Resource
	    private EntityManagerFactory emf;
	    protected EntityManager em;
	    private Criminal crim;
	 
	    @Resource
		private UserRepo userRepo;
	    
	    @Resource
	    private CriminalService criminalService;

	    @Resource
	    private RoleService roleService;
	    
	    @Resource
	    private UserService userService;
	    
	    @Resource
	    private CriminalEventService criminalEventService;
	    
	 
	    @Before
	    public void setUp() throws Exception {
	    //	User userPojo;  
	        em = emf.createEntityManager();
	    }
	 
//	    @Test
//	    public void testAddCriminal() throws Exception {
//	    	logger.info("+testAddCriminal");
//	    	crim=new Criminal();
//	    	crim.setCriminalName("BIBABO");
//	    	crim.setCriminalSurname("Chikalo");
//	    	Criminal actual=criminalService.addCriminal(crim);
//	    	Assert.assertEquals(Criminal.class, actual.getClass());
//	    }
//	    
//	    @Test
//	    public void testGetRoles() throws Exception {
//	    	logger.info("+testGetRoles");
//	    	List<Role> roles=roleService.getRoles();
//	    	Assert.assertEquals(2l, roles.size());
//	    }
//	    
//	    @Test
//	    public void testGetCriminalEvents() throws Exception {
//	    	logger.info("+testGetCriminalEvents");
//	    	List<CriminalEvent> events=criminalEventService.getCriminalEvents();
//	    	Assert.assertEquals(2l, events.size());
//	    }
//	    @Test
//		public void getRoleByUserId() {
//			logger.info("Start test deleteByID.");
//			int id = 1;
//			//Mockito.when(userRepo.getRolesForUser(userId)(id)).thenReturn(userPojo);
//
//			Set<Role> roles = userService.getRoleByUserId(id);
//			assertTrue(roles.contains(role));
//			logger.info("Test deleteByID is finished.");
//		}
	    
//	    @Test
//	    public void testGetUsers() throws Exception {
//	    	logger.info("+testGetUsers");
//	    	List<User> users=userService.getAllUsers();
//	    	Assert.assertEquals(4l, users.size());
//	    }
//	    
//	    @Test
//	    public void testGetUserByName() throws Exception {
//	    	logger.info("+testGetUserByName");
//	    	User user=userService.getUserByName("Marta");
//	    	Assert.assertEquals(3l, (long)user.getId());
//	    }
//	    
	    @Test
	    public void getRolesByUserId() throws Exception {
	    	logger.info("**************** getRolesByUserId *****************");
	    	List<Role> users=userService.getRolesByUserId(2);
	    	logger.info(users);
	    	Assert.assertEquals(2l, users.size());
	    }
}
