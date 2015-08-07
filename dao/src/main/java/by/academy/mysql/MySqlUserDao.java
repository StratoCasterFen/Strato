package by.academy.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import by.academy.domain.User;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;



public class MySqlUserDao extends AbstractDao<User, Integer>{

	private class PersistUser extends User {
        public void setId(int id) {
            super.setId(id);
        }
    }
	
	public MySqlUserDao(Connection connection) {
		super(connection);
	}


	public User create() throws DaoException {
        User u = new User();
        return persist(u);
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
		LinkedList<User> result = new LinkedList<User>();
        try {
            while (rs.next()) {
                PersistUser user = new PersistUser();
                user.setId(rs.getInt("UserId"));
                user.setUserName(rs.getString("UserName"));
                //user.setPassword(rs.getString("password"));
                result.add(user);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
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

	

}
