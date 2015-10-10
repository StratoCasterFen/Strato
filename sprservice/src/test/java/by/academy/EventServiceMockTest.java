package by.academy;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.academy.dto.EventDto;
import by.academy.hbutil.ConvertDate;
import by.academy.pojos.CriminalEvent;
import by.academy.service.cfg.ServiceCfg;
import by.academy.service.exeption.ServiceException;
import by.academy.service.srv.CriminalEventService;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceCfg.class)
public class EventServiceMockTest {
	
	static Logger logger= Logger.getLogger(EventServiceMockTest.class.getName());
	 @Resource
	    private EntityManagerFactory emf;
	    protected EntityManager em;
    
	private Mockery mockingContext = new JUnit4Mockery();
//	private EventServiceImpl mockedUserService;
	
	 @Resource
	    private CriminalEventService criminalEventService;
	
	private List<CriminalEvent> events = new ArrayList<CriminalEvent>();

	private CriminalEvent event=new CriminalEvent();
	private List exEvents= new ArrayList<CriminalEvent>();
	
	{logger.info("end init "+ events);}
	
	@Before
    public void setUp() throws Exception {
    //	User userPojo;  
        em = emf.createEntityManager();
    	logger.info("setup before test");
//		
//		mockEventDao = mockingContext.mock(GenericHDao.class);
//		mockEventService = mockingContext.mock(EventService.class);
//      //  eventDao = new EventDao();
//        eventService =new EventServiceImpl();
     //   eventService.s;
        
     
        logger.info("eventServiceЭ");
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
    public void  getEvents()   {
    	logger.info("TEST: getEvents");
    	List<EventDto> events= criminalEventService.getCriminalEvents();
    	logger.info(events);
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
	
//    @Test
//    public void getEventsByUserId() throws ServiceException{
//    	logger.info("TEST: getEventsByUserId");
//    	List<CriminalEvent> events= eventService.getEventsByUserId(1);
//    	assertEquals(1l, events.size());
//    }
//    @Test
//    public void getEventsByCriminalId() throws ServiceException{
//    	logger.info("TEST: getEventsByCriminalId");
//    	List<CriminalEvent> events= eventService.getEventsByCriminalId(2);
//    	assertEquals(2l, events.size());
//    }
//       
//	
//    @After
//    public void destroy() {
////        em.close();
////        emf.close();
//    }
	
}
