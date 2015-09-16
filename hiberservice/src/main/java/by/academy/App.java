package by.academy;

import by.academy.dao.CriminalDao;
import by.academy.dao.CustomCriminalDao;
import by.academy.dao.CustomUserDao;
import by.academy.dao.DaoException;
import by.academy.dao.UserDao;
import by.academy.service.exeption.ServiceException;
import by.academy.service.impl.CriminalServiceImpl;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.CriminalService;
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
        CriminalService criminalService= new CriminalServiceImpl();
        CustomCriminalDao criminalDao=new CriminalDao();
		criminalService.setCriminalDao(criminalDao);  
        System.out.println(criminalService.getCriminals());
        
        UserServiceImpl userservice=new UserServiceImpl();
        CustomUserDao userDao=new UserDao();
        userservice.setUserDao(userDao);  
        userservice.authorization("Admin", "1223");
        
    }
}
