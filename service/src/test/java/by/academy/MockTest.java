package by.academy;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.mysql.MySqlUserDao;
import by.academy.service.exception.ServiceException;
import by.academy.service.impl.ModelUser;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.UserService;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class MockTest {
	
	static Logger logger= Logger.getLogger(MockTest.class.getName());
	
	private Mockery mockingContext = new JUnit4Mockery();
	private ModelUser mUser;
	private UserService mockedUserService;
	private GenericDao daoUser;
	private GenericDao userDao;
	private List<User> users = new ArrayList<User>();
	private String userName;
	private User user; 
	private GenericDao/*MySqlUserDao*/ myUser;
	
	{logger.info("end init "+ users);}
	
	@Before
	public void setUp() throws DaoException{
		logger.info("setup before test");
		mUser = new ModelUser("admin", "123");

		MySqlDaoFactory factory = new MySqlDaoFactory();
		daoUser = factory.getDao(factory.getConnection(), User.class);
		
		
		userDao=daoUser;
		// users must equals data in database
		user = new User();
		user.setId(79);
		user.setUserName("Ivanko");
		user.setPassword("133");

		User user1 = new User();
		user1.setId(66);
		user1.setUserName("Pervanuk");
		user1.setPassword("415133");

		User user2 = new User();
		user2.setId(3);
		user2.setUserName("admin");
		user2.setPassword("b1374a31148f365f61e1b30e655f1d6");

		users.add(user2);
		users.add(user1);
		users.add(user);

		mockedUserService = mockingContext.mock(UserService.class);
		myUser = mockingContext.mock(MySqlUserDao.class);
		daoUser=mockingContext.mock(GenericDao.class);
	//	myUser=(MySqlUserDao)daoUser;
		
		userName ="Ivanko";
	}
	
	@Test
	public void addUser() throws DaoException, ServiceException{ 
		logger.info("test addUser");
		mockingContext.checking(new Expectations() {
			{
				oneOf(mockedUserService).addUser(mUser);
				will(returnValue(null));	
			}
		});
		mockedUserService.addUser(mUser);
		logger.info("--test addUser");
    }
	
	@Test  
	public void getAllUsers() throws ServiceException, DaoException {
		logger.info("test getAllUsers");
		mockingContext.checking(new Expectations() {
			{
				oneOf(daoUser).getAll();
				will(returnValue(users));
				logger.info(users);
			}
		});
		mockedUserService=new UserServiceImpl();
		mockedUserService.setUserDAO(userDao);
		mockedUserService.getAllUsers();
		logger.info("mo "+mockedUserService.getAllUsers());
	}
	
	@Test
	public void getUserByName() throws DaoException, ServiceException {
		logger.info("test getUserByName");
		mockingContext.checking(new Expectations() {
			{
				oneOf((MySqlUserDao)myUser).getUserByName(userName);
				will(returnValue(user));
				logger.info(user);
			}
		});
		mockedUserService.getUserByName(userName);
	}
	
	
	
}
