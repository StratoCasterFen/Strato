package by.academy.mysql;

import java.sql.ResultSet;
import java.util.List;

import by.academy.domain.User;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;

public class UserDao extends AbstractDao<User, Integer>{

	@Override
	public User create() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User persist(User object) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<User> parseResultSet(ResultSet rs) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
