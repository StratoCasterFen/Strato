package by.academy.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

import by.academy.domain.User;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;


public class MySqlUserDao extends AbstractDao<User, Integer>{


	public MySqlUserDao(DaoFactory<Connection> parentFactory, Connection connection) {
		super(parentFactory, connection);
	}


	public User create() throws DaoException {
        User u = new User();
        return u;
	}


	public List<User> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		return ResourceBundle.getBundle("queries").getString("SelectUser");
	}

	@Override
	public String getCreateQuery() {
		return ResourceBundle.getBundle("queries").getString("CreateUser");
	}

	@Override
	public String getUpdateQuery() {
		return ResourceBundle.getBundle("queries").getString("UpdateUser");
	}

	@Override
	public String getDeleteQuery() {
		return ResourceBundle.getBundle("queries").getString("DeleteUser");
	}

	@Override
	protected List<User> parseResultSet(ResultSet rs) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws DaoException {
        try {
            statement.setString(1, object.getUserName());
            statement.setString(2, object.getPassword());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
	
	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws DaoException {
        try {
            statement.setString(1, object.getUserName());
            statement.setString(2, object.getPassword());
            statement.setInt(3, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }	
	}

	
	
	@Override
	public User persist(User object) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


}
