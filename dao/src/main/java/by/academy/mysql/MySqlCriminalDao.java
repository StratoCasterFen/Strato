package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import by.academy.domain.Criminal;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;

public class MySqlCriminalDao extends AbstractDao<Criminal, Integer>{

	public MySqlCriminalDao(DaoFactory<Connection> parentFactory, Connection connection) {
		super(parentFactory, connection);
		
	}

	@Override
	public Criminal create() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criminal persist(Criminal object) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Criminal> getAll() throws DaoException {
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
	protected List<Criminal> parseResultSet(ResultSet rs) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, Criminal object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, Criminal object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
