package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import by.academy.domain.CriminalEvent;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;

public class MySqlCriminalEventDao extends AbstractDao<CriminalEvent, Integer>{

	public MySqlCriminalEventDao(DaoFactory<Connection> parentFactory, Connection connection) {
		super(parentFactory, connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CriminalEvent create() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CriminalEvent persist(CriminalEvent object) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CriminalEvent> getAll() throws DaoException {
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
	protected List<CriminalEvent> parseResultSet(ResultSet rs) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, CriminalEvent object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, CriminalEvent object) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
