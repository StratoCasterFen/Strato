package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import by.academy.domain.Criminal;
import by.academy.domain.CriminalEvent;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;
import ru.dokwork.daotalk.dao.PersistException;
import ru.dokwork.daotalk.domain.Student;
import ru.dokwork.daotalk.mysql.MySqlStudentDao.PersistStudent;

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
	                PersistCriminalEvent student = new PersistCriminalEvent();
	                student.setId(rs.getInt("Eventid"));
	                student.setEventName(rs.getString("Eventname"));
	                student.setEventDescription(rs.getString("EventDescription"));
	                student.setEventDate(rs.getDate("Eventdate"));
	                student.setCriminalId(rs.getInt("group_id"));
	                result.add(student);
	            }
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	        return result;
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
