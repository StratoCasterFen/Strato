package by.academy;

import java.sql.Connection;

import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.service.exception.ServiceException;
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
        
        UserServiceImpl u=new UserServiceImpl();
        System.out.println(u.authorization("Ivanko", "123"));
        
        MySqlDaoFactory factory = new MySqlDaoFactory();
        Connection connection =  factory.getConnection(); 
        GenericDao dao = factory.getDao(connection, User.class);
      //  User u=new User();
     //   u.setUserName("Ivanko");
      //  u.setPassword("133");
       // dao.persist(u);
    }
}
