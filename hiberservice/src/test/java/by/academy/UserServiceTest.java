package by.academy;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import by.academy.dto.UserDto;
import by.academy.dto.UserRoleDto;
import by.academy.pojos.Role;
import by.academy.service.exeption.ServiceException;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.UserService;


public class UserServiceTest {
	static Logger logger = Logger.getLogger(UserServiceTest.class.getName());

	private UserService userServ;
	private UserRoleDto userRoleDto;
	

	@Before
	public void setUp() throws ServiceException{
		logger.info("setup before test");
		userServ=new UserServiceImpl();
		userRoleDto=new UserRoleDto("Bolvanko", "123",1);
	}	
	
	@Test
	public void getRolesByUserId() throws ServiceException {
		List<Role> roles=userServ.getRolesByUserId(2);
		assertEquals(2l, roles.size());
	}
	
	@Test(expected = ServiceException.class)
	public void addUser() throws ServiceException {
		logger.info("addUser");
		userServ.addUser(userRoleDto);
		//assertEquals(null, );
	}
	
	@Test
	public void getUserByName() throws ServiceException {
		logger.info("addUser");
		UserDto user=userServ.getUserByName("Tom8");
		logger.info(user);
		assertEquals(null, user);
	}
	
	@Test
	public void getAllUsers() throws ServiceException {
		logger.info("getAllUsers");
		List users = userServ.getAllUsers();
		logger.info(users);
		assertEquals(4l, users.size());
	}
	
	@Test
	public void Auth() throws ServiceException {
		logger.info("Auth");
		userServ = new UserServiceImpl();
		UserDto authUser = userServ.authorization("Bolvanko", "123");
		logger.info(authUser);
		assertEquals("Bolvanko", authUser.getUserName());
	}
}
