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
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.mysql.MySqlUserDao;
import by.academy.service.exception.ServiceException;
import by.academy.service.impl.EventServiceImpl;
import by.academy.service.impl.ModelUser;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.UserService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;

public class MockTest {
	
	static Logger logger= Logger.getLogger(MockTest.class.getName());
	
	
	private Mockery mockingContext = new JUnit4Mockery();
	private ModelUser mUser;
	private MySqlUserDao daoUser;
	private UserService userService = new UserServiceImpl();
	{logger.info("end init "+ mUser);}
	
	@Before
	public void setUp() throws DaoException{
		logger.info("setup");
		mUser= new ModelUser("Ivanko5","798454");
//		user.setId(100);
//		user.setUserName("Ivanko");
//		user.setPassword("7895");
//		
		daoUser=mockingContext.mock(MySqlUserDao.class);
//		MySqlDaoFactory factory=new MySqlDaoFactory();
//		//Connection connection =  factory.getConnection(); 
//		GenericDao dao = factory.getDao(factory.getConnection(), User.class);
//		dao.persist(user);
		logger.info(user);
		//userService = mockingContext.mock(UserServiceImpl.class);
	}
	
	@Test
	public void addUser() throws DaoException, ServiceException{ 
		logger.info("test addUser");
		mockingContext.checking(new Expectations() {
			{
				oneOf(daoUser).getUserByName(user);
				will(returnValue(null));
				daoUser.persist(user);
				oneOf(daoUser).getUserByName(user);
				will(returnValue(user));				
			}
		});
		
		userService.setUserDAO(daoUser);
		userService.addUser(user);
		
    }
}
