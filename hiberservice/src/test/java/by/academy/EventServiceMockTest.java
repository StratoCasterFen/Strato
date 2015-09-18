package by.academy;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import by.academy.dao.AbstractHDao;
import by.academy.dao.CustomEventDao;
import by.academy.dao.EventDao;
import by.academy.dao.GenericHDao;
import by.academy.dao.exception.DaoException;
import by.academy.hbutil.ConvertDate;
import by.academy.pojos.CriminalEvent;
import by.academy.service.exeption.ServiceException;
import by.academy.service.impl.EventServiceImpl;
import by.academy.service.interf.EventService;

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
	private EventServiceImpl mockedUserService;

	private List<CriminalEvent> events = new ArrayList<CriminalEvent>();
	private GenericHDao mockEventDao;
	private CustomEventDao eventDao;
	private CriminalEvent event=new CriminalEvent();
	private EventServiceImpl eventService;
	private EventService mockEventService;
	private List exEvents= new ArrayList<CriminalEvent>();
	
	{logger.info("end init "+ events);}
	
	@Before
	public void setUp() throws ServiceException{
		logger.info("setup before test");
		
		mockEventDao = mockingContext.mock(GenericHDao.class);
		mockEventService = mockingContext.mock(EventService.class);
      //  eventDao = new EventDao();
        eventService =new EventServiceImpl();
     //   eventService.s;
        
     
        logger.info(eventService);
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
    	logger.info("TEST: getEvents");
    	List<CriminalEvent> events= eventService.getEvents();
		assertEquals(2l, events.size()); 
		
//    	mockingContext.checking(new Expectations() {
//		{
//				oneOf(mockEventService).getEvents();
//				will(returnValue(exEvents));
//				logger.info(exEvents);
//			}
//		});
  //  	Mockito.when(mockEventDao.getAll()).thenReturn(exEvents);
    //	Mockito.verify(mockEventDao).getAll();
    }
	
    @Test
    public void getEventsByUserId() throws ServiceException{
    	logger.info("TEST: getEventsByUserId");
    	List<CriminalEvent> events= eventService.getEventsByUserId(1);
    	assertEquals(2l, events.size());
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
