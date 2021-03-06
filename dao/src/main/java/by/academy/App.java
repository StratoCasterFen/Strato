package by.academy;

import java.sql.SQLException;

import java.sql.Connection;

import by.academy.domain.Criminal;
import by.academy.domain.CriminalEvent;
import by.academy.domain.Role;
import by.academy.domain.User;
import by.academy.domain.UserRole;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlCriminalEventDao;
import by.academy.mysql.MySqlDaoFactory;
import by.academy.mysql.MySqlUserDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DaoException, SQLException
    {
        System.out.println( "Hello World!" );
        
        MySqlDaoFactory factory = new MySqlDaoFactory();
        Connection connection =  factory.getConnection(); 
        GenericDao dao = factory.getDao(connection, User.class);
        User u=new User();
        u.setUserName("Ivanko");
        u.setPassword("133");
        dao.persist(u);
        MySqlUserDao use = new MySqlUserDao(connection);
        System.out.println(use.getUserByNameAndPassword(u));
        
        MySqlCriminalEventDao mce= new MySqlCriminalEventDao(connection);
        System.out.println(mce.getAll());
       // String md5Password;
//        MD5 md5 = new MD5();
  //      md5Password = md5.getHash(md5.getHash("123") + md5.getHash("Fender"));

      //  System.out.println(md5Password);
    }
}
