package by.academy;

import java.sql.Connection;

import by.academy.domain.CriminalEvent;
import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.service.exception.ServiceException;
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
        GenericDao dao = factory.getDao(connection, CriminalEvent.class);
//2
        EventServiceImpl eventService = new EventServiceImpl();
        System.out.println(eventService.getEvents());
        CriminalEvent event=new CriminalEvent();
        event.setEventName("test");
        event.setEventDescription("test * * -cvd-b- -d");
        event.setUserId(3);
        event.setCriminalId(2);
        eventService.setEventDao(dao);
        eventService.add(event); 
        eventService.deleteByID(6);
 //3       
      //  User u=new User();
     //   u.setUserName("Ivanko");
      //  u.setPassword("133");
       // dao.persist(u);
        
     //4
        
        
    }
}
