package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import by.academy.domain.Role;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;

public class MySqlRoleDao extends AbstractDao<Role, Integer>{

	public MySqlRoleDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Role create() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role persist(Role object) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Role> getAll() throws DaoException {
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
	protected List<Role> parseResultSet(ResultSet rs) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, Role object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, Role object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
