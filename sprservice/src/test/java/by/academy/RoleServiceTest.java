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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.academy.dao.iRepo.UserRepo;
import by.academy.dto.UserRoleDto;
import by.academy.pojos.Criminal;
import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.service.cfg.ServiceCfg;
import by.academy.service.srv.CriminalEventService;
import by.academy.service.srv.CriminalService;
import by.academy.service.srv.RoleService;
import by.academy.service.srv.UserService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceCfg.class)
public class RoleServiceTest {
	 private Logger logger = LogManager.getLogger(RoleServiceTest.class.getName());
	 
	 @Resource
	    private EntityManagerFactory emf;
	    protected EntityManager em;
	    private Criminal crim;
	    private UserRoleDto user;
	 
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
	 
	    @Test
	    public void testGetRoles() throws Exception {
	    	logger.info("*************testGetRoles****************");
	    	List actual=roleService.getRoles();
	    	logger.info(actual);
	    	Assert.assertEquals(2l, actual.size());
	    }

}
