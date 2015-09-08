package by.academy;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.academy.dao.CustomEventDao;
import by.academy.dao.DaoException;
import by.academy.dao.EventDao;
import by.academy.hbutil.ConvertDate;
import by.academy.pojos.CriminalEvent;
import by.academy.service.ServiceException;
import by.academy.service.impl.EventService;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class EventServiceMockTest {
	
	static Logger logger= Logger.getLogger(EventServiceMockTest.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;
    
	private Mockery mockingContext = new JUnit4Mockery();
	private EventService mockedUserService;

	private List<CriminalEvent> events = new ArrayList<CriminalEvent>();
	private CustomEventDao eventDao;
	private CriminalEvent event=new CriminalEvent();
	private EventService eventService;
	private List exEvents= new ArrayList<CriminalEvent>();
	
	{logger.info("end init "+ events);}
	
	@Before
	public void setUp() throws DaoException{
		logger.info("setup before test");
//        emf = Persistence.createEntityManagerFactory("hiberpolice_test");
//        em = emf.createEntityManager();
        
        eventDao = new EventDao();
        eventService =new EventService();
        eventService.setEventDao(eventDao);
        eventDao = mockingContext.mock(CustomEventDao.class);
        
    	Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.AUGUST, 30);
        java.util.Date date = cal.getTime();
        java.sql.Date sqlDate = ConvertDate.convert(date);        
        event.setId(1);
		event.setEventName("first event");
		event.setEventDescription("blabla-bla");
		event.setEventDate(sqlDate);
		event.setUser(null);
		event.setCriminal(null);
		exEvents.add(event);
        cal.set(2015, Calendar.AUGUST, 31);
        date = cal.getTime();
        sqlDate = ConvertDate.convert(date);  
        event.setId(2);
		event.setEventName("second event");
		event.setEventDescription("uydublabla-bla");
		event.setEventDate(sqlDate);
		exEvents.add(event); 
	}

	
    @Test
    public void  getEvents() throws ServiceException, DaoException {
    //	logger.info("TEST: GetRolesByUserName");

    	
//    	mockingContext.checking(new Expectations() {
//			{
//				oneOf(eventDao).setEntityManager(em);
//				oneOf(eventDao).getAll();
//				will(returnValue(exEvents));
//			}
//		});
    	
//    	List<CriminalEvent> events= eventService.getEvents();
//		//assertEquals(exEvents, events);
//    	logger.info(events);
    }
	
	
//	@Test
//	public void addUser() throws DaoException, ServiceException{ 
//		logger.info("test addUser");
//		mockingContext.checking(new Expectations() {
//			{
//				oneOf(mockedUserService).addUser(mUser);
//				will(returnValue(null));	
//			}
//		});
//		mockedUserService.addUser(mUser);
//		logger.info("--test addUser");
//    }
//	
//	@Test  
//	public void getAllUsers() throws ServiceException, DaoException {
//		logger.info("test getAllUsers");
//		mockingContext.checking(new Expectations() {
//			{
//				oneOf(daoUser).getAll();
//				will(returnValue(users));
//				logger.info(users);
//			}
//		});
//		mockedUserService=new UserServiceImpl();
//		mockedUserService.setUserDAO(userDao);
//		mockedUserService.getAllUsers();
//		logger.info("mo "+mockedUserService.getAllUsers());
//	}
//	
//	@Test
//	public void getUserByName() throws DaoException, ServiceException {
//		logger.info("test getUserByName");
//		mockingContext.checking(new Expectations() {
//			{
//				oneOf((MySqlUserDao)myUser).getUserByName(userName);
//				will(returnValue(user));
//				logger.info(user);
//			}
//		});
//		mockedUserService.getUserByName(userName);
//	}
	
    @After
    public void destroy() {
//        em.close();
//        emf.close();
    }
	
}
