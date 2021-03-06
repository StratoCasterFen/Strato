package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import by.academy.domain.User;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;



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
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("UserName"));
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
	
	public User getUserByNameAndPassword(User user) throws DaoException {
		 
		 String sql = ResourceBundle.getBundle("queries").getString("SelectUserByNamePassword");
		 
		 List<User> list;
	       
	       try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, user.getUserName());
	            statement.setString(2, user.getPassword());
	            ResultSet rs = statement.executeQuery();
	            list = parseResultSet(rs);
	        } catch (Exception e) {
	            throw new DaoException(e);
	        }
	        if (list == null || list.size() == 0) {
	         //   throw new DaoException("User and password not exist.");
	            return null;
	        }
	        if (list.size() > 1) {
	            throw new DaoException("Users with this name more than one record.");
	        }
	        return list.iterator().next();
	}

	public User getUserByName(String userName) throws DaoException {
		 
		 String sql = ResourceBundle.getBundle("queries").getString("SelectUserByName");
		 
		 List<User> list;
	       
	       try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, userName);
	            ResultSet rs = statement.executeQuery();
	            list = parseResultSet(rs);
	        } catch (Exception e) {
	            throw new DaoException(e);
	        }
	        if (list == null || list.size() == 0) {
	            return null;
	        }
	        if (list.size() > 1) {
	            throw new DaoException("Users with this name more than one record.");
	        }
	        return list.iterator().next();
	}



}
