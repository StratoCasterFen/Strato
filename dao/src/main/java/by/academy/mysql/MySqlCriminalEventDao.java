package by.academy.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import by.academy.domain.CriminalEvent;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.ConvertDate;
import by.academy.mydao.DaoException;


public class MySqlCriminalEventDao extends AbstractDao<CriminalEvent, Integer>{

	public MySqlCriminalEventDao(Connection connection) {
		super( connection);
	}

	private class PersistCriminalEvent extends CriminalEvent {
        public void setId(int id) {
            super.setId(id);
        }
    }
	
	@Override
	public CriminalEvent create() throws DaoException {
		CriminalEvent criminalEvent = new CriminalEvent();
        return persist(criminalEvent);
	}

	
	@Override
	public String getSelectQuery() {
		return ResourceBundle.getBundle("queries").getString("SelectCriminalEvent");
	}

	@Override
	public String getCreateQuery() {
		return ResourceBundle.getBundle("queries").getString("CreateCriminalEvent");
	}

	@Override
	public String getUpdateQuery() {
		return ResourceBundle.getBundle("queries").getString("UpdateCriminalEvent");
	}

	@Override
	public String getDeleteQuery() {
		return ResourceBundle.getBundle("queries").getString("DeleteCriminalEvent");
	}

	@Override
	protected List<CriminalEvent> parseResultSet(ResultSet rs) throws DaoException {
		 LinkedList<CriminalEvent> result = new LinkedList<CriminalEvent>();
	        try {
	            while (rs.next()) {
	                PersistCriminalEvent criminalEvent = new PersistCriminalEvent();
	                criminalEvent.setId(rs.getInt("Eventid"));
	                criminalEvent.setEventName(rs.getString("Eventname"));
	                criminalEvent.setEventDescription(rs.getString("EventDescription"));
	                criminalEvent.setEventDate(rs.getDate("Eventdate"));
	                criminalEvent.setCriminalId(rs.getInt("CriminalId"));
	                criminalEvent.setCriminalId(rs.getInt("UserId"));
	                result.add(criminalEvent);
	            }
	        } catch (Exception e) {
	            throw new DaoException(e);
	        }
	        return result;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, CriminalEvent object) throws DaoException{
		try {
			Date sqlDate = ConvertDate.convert(object.getEventDate());
            statement.setString(1, object.getEventName());
            statement.setString(2, object.getEventDescription());
            statement.setDate(3, sqlDate);
            statement.setInt(4, object.getCriminalId());
            statement.setInt(5, object.getUserId());
            statement.setInt(6, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, CriminalEvent object) throws DaoException {
		try {
			Date sqlDate = ConvertDate.convert(object.getEventDate());
            statement.setString(1, object.getEventName());
            statement.setString(2, object.getEventDescription());
            statement.setDate(3, sqlDate);
            statement.setInt(4, object.getCriminalId());
            statement.setInt(5, object.getUserId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
		
	}

}
