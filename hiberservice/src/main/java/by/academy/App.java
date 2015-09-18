package by.academy;

import java.sql.Date;

import by.academy.dao.CriminalDao;
import by.academy.dao.CustomCriminalDao;
import by.academy.dao.CustomUserDao;
import by.academy.dao.DaoException;
import by.academy.dao.UserDao;
import by.academy.dto.CriminalDto;
import by.academy.dto.EventDto;
import by.academy.dto.EventTypeDto;
import by.academy.dto.UserDto;
import by.academy.service.exeption.ServiceException;
import by.academy.service.impl.CriminalServiceImpl;
import by.academy.service.impl.EventServiceImpl;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.CriminalService;
import by.academy.service.interf.EventService;
import by.academy.service.interf.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DaoException, ServiceException
    {
        System.out.println( "Hello World!" );
/*        CriminalService criminalService= new CriminalServiceImpl();
        CustomCriminalDao criminalDao=new CriminalDao();
		criminalService.setCriminalDao(criminalDao);  
        System.out.println(criminalService.getCriminals());
        
        UserServiceImpl userservice=new UserServiceImpl();
        CustomUserDao userDao=new UserDao();
        userservice.setUserDao(userDao);  
        userservice.authorization("Admin", "1223");*/
        
        
        EventService es=new EventServiceImpl();
         Date d = null;
        CriminalDto  cdto = new CriminalDto(1, "Ganstrelitto", "De la Vorro", d);
        
        UserDto  udto = new UserDto(1, "Admin", "");
        EventTypeDto tdto = new EventTypeDto(1,"Draka");
        
        
        EventDto edto=new EventDto(7, "Event #6", "bla- bla", d, cdto, udto, tdto);
        
        es.add(edto);
        System.out.println( "---" );
    }
}
