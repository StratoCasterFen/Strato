package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import by.academy.domain.UserRole;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;

public class MySqlUserRoleDao extends AbstractDao<UserRole, Integer>{

	public MySqlUserRoleDao(DaoFactory<Connection> parentFactory, Connection connection) {
		super(connection);
	}

	@Override
	public UserRole create() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole persist(UserRole object) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UserRole> getAll() throws DaoException {
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
	protected List<UserRole> parseResultSet(ResultSet rs) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, UserRole object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, UserRole object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
