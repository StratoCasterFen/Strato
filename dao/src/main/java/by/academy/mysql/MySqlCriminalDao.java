package by.academy.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import by.academy.domain.Criminal;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.ConvertDate;
import by.academy.mydao.DaoException;


public class MySqlCriminalDao extends AbstractDao<Criminal, Integer>{

	public MySqlCriminalDao(Connection connection) {
		super(connection);	
	}

	private class PersistCriminal extends Criminal {
        public void setId(int id) {
            super.setId(id);
        }
    }
	
	@Override
	public Criminal create() throws DaoException {
		Criminal criminal = new Criminal();
        return persist(criminal);
	}

	
	
	@Override
	public String getSelectQuery() {
		return ResourceBundle.getBundle("queries").getString("SelectCriminal");
	}

	@Override
	public String getCreateQuery() {
		return ResourceBundle.getBundle("queries").getString("CreateCriminal");
	}

	@Override
	public String getUpdateQuery() {
		return ResourceBundle.getBundle("queries").getString("UpdateCriminal");
	}

	@Override
	public String getDeleteQuery() {
		return ResourceBundle.getBundle("queries").getString("DeleteCriminal");
	}

	@Override
	protected List<Criminal> parseResultSet(ResultSet rs) throws DaoException {
		LinkedList<Criminal> result = new LinkedList<Criminal>();
        try {
            while (rs.next()) {
                PersistCriminal criminal = new PersistCriminal();
                criminal.setId(rs.getInt("id"));
                criminal.setCriminalName(rs.getString("Name"));
                criminal.setCriminalSurname(rs.getString("SurName"));
                criminal.setBirthday(rs.getDate("Birthday"));
                result.add(criminal);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, Criminal object) throws DaoException {
		try {
			Date sqlDate = ConvertDate.convert(object.getBirthday());
            statement.setString(1, object.getCriminalName());
            statement.setString(2, object.getCriminalSurname());
            statement.setDate(3, sqlDate);
            statement.setInt(4, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, Criminal object) throws DaoException {
        try {
        	Date sqlDate = ConvertDate.convert(object.getBirthday());
            statement.setString(1, object.getCriminalName());
            statement.setString(2, object.getCriminalSurname());
            statement.setDate(3, sqlDate);
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
