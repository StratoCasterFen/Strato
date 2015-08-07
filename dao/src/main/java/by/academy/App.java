package by.academy;

import java.sql.SQLException;

import java.sql.Connection;

import by.academy.domain.Criminal;
import by.academy.domain.User;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;
import by.academy.mydao.GenericDao;
import by.academy.mysql.MySqlDaoFactory;

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
        GenericDao dao = factory.getDao(connection, Criminal.class);

        System.out.println(dao.getAll());
    }
}
