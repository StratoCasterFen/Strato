package by.academy;

import java.sql.Connection;
import java.util.Calendar;
import java.sql.Date;

import by.academy.domain.Criminal;
import by.academy.domain.CriminalEvent;
import by.academy.domain.User;
import by.academy.mydao.ConvertDate;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlCriminalDao;
import by.academy.mysql.MySqlCriminalEventDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.service.exception.ServiceException;
import by.academy.service.impl.CriminalServiceImpl;
import by.academy.service.impl.EventServiceImpl;
import by.academy.service.impl.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DaoException, ServiceException
    {
        System.out.println( "Hello World!" );
        
//        UserServiceImpl u=new UserServiceImpl();
//        System.out.println(u.authorization("Ivanko", "123"));
//        
        MySqlDaoFactory factory = new MySqlDaoFactory();
        Connection connection =  factory.getConnection(); 
        GenericDao dao = factory.getDao(connection, Criminal.class);
        GenericDao criminalDao=factory.getDao(connection, Criminal.class); 
//2
        EventServiceImpl eventService = new EventServiceImpl();
        CriminalServiceImpl criminalService = new CriminalServiceImpl();
      //  System.out.println(eventService.getEvents());
        CriminalEvent event=new CriminalEvent();
        event.setEventName("test");
        event.setEventDescription("test * * -cvd-b- -d");
        event.setUserId(3);
        event.setCriminalId(2);
        eventService.setEventDao(dao);
        
        
        
        
        Calendar cal = Calendar.getInstance();
        cal.set(2014, Calendar.FEBRUARY, 17);
        java.util.Date date1 = cal.getTime();
        java.sql.Date sqlDate = ConvertDate.convert(date1);
      //  eventService.add(event); 
      //  eventService.deleteByID(4);
        MySqlCriminalDao criminal = new MySqlCriminalDao(connection);
        criminalService.setCriminalDao(criminalDao);
        
        Criminal cri2=criminal.getByPK(2);
        System.out.println(cri2);
        cri2.setCriminalName("Djulicko");
        criminalService.updateCriminal(cri2);
        System.out.println(criminal.getAll());
 //3       
      //  User u=new User();
     //   u.setUserName("Ivanko");
      //  u.setPassword("133");
       // dao.persist(u);
        
     //4
        
        
    }
}
