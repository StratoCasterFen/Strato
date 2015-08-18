package by.academy;

import static org.mockito.Mockito.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import static org.junit.Assert.*;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mysql.MySqlUserDao;
import by.academy.service.exception.ServiceException;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.UserService;

public class MockTest {
	
	private Mockery mockingContext = new JUnit4Mockery();
	private final User user = new User();
	private MySqlUserDao daoUser;
	private UserService userService = new UserServiceImpl();
	
	@Before
	public void setUp(){
		user.setId(1);
		user.setUserName("Ivanko");
		user.setPassword("7895");
		
		daoUser = mockingContext.mock(MySqlUserDao.class);
	}
	
	@Test
	public void addUser() throws DaoException, ServiceException{ 
		mockingContext.checking(new Expectations() {
			{
				oneOf(daoUser).getUserByName(user);
				will(returnValue(null));
				oneOf(daoUser).persist(user);
				oneOf(daoUser).getUserByName(user);
				will(returnValue(user));				
			}
		});
		
		userService.setUserDAO(daoUser);
		userService.addUser(user);
		
    }
}
