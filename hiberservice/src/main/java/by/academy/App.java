package by.academy;

import by.academy.dao.CriminalDao;
import by.academy.dao.CustomCriminalDao;
import by.academy.dao.DaoException;
import by.academy.service.ServiceException;
import by.academy.service.impl.CriminalService;
import by.academy.service.interf.ICriminalService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DaoException, ServiceException
    {
        System.out.println( "Hello World!" );
        ICriminalService criminalService= new CriminalService();
        CustomCriminalDao criminalDao=new CriminalDao();
		criminalService.setCriminalDao(criminalDao);  
        System.out.println(criminalService.getCriminals());
        
    }
}
