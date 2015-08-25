package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import by.academy.domain.CriminalEvent;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.ConvertDate;
import by.academy.mydao.DaoException;

public class MySqlCriminalEventDao extends AbstractDao<CriminalEvent, Integer> {

	static Logger logger = Logger.getLogger(MySqlCriminalEventDao.class
			.getName());

	public MySqlCriminalEventDao(Connection connection) {
		super(connection);
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
	public String getQuery(String propName) throws DaoException{
		try {
			return ResourceBundle.getBundle("queries").getString(propName);
		} catch (MissingResourceException e) {
			logger.error("file queries.properties not exist");
			throw new DaoException("file queries.properties not exist",e);
		}
	}
	
	@Override
	public String getSelectQuery() throws DaoException {
		return getQuery("SelectCriminalEvent");
	}

	@Override
	public String getCreateQuery() throws DaoException {
		return getQuery("CreateCriminalEvent");
	}

	@Override
	public String getUpdateQuery() throws DaoException {
		return getQuery("UpdateCriminalEvent");
	}

	@Override
	public String getDeleteQuery() throws DaoException {
		return getQuery("DeleteCriminalEvent");
	}
	
	public List<CriminalEvent> getByUserId(int userId) throws DaoException {
		logger.info("+getEventByUserId");

		String sql = getQuery("SelectEventsByUser");

		List<CriminalEvent> list;

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		} catch (Exception e) {
			logger.error("getEventByUserId: cant perform result from sql");
			throw new DaoException("cant perform result from sql", e);
		}
		if (list == null || list.size() == 0) {
			return null;
		}
		logger.info("-getEventByUserId");
		return list;
	}

	public List<CriminalEvent> getByCriminalId(int criminalId)
			throws DaoException {
		logger.info("+getByCriminalId");

		String sql = getQuery("SelectEventsByCriminal");

		List<CriminalEvent> list;

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, criminalId);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		} catch (Exception e) {
			logger.error("getByCriminalId: cant perform result from sql");
			throw new DaoException("cant perform result from sql", e);
		}
		if (list == null || list.size() == 0) {
			return null;
		}
		logger.info("-getByCriminalId");
		return list;
	}

	@Override
	protected List<CriminalEvent> parseResultSet(ResultSet rs)
			throws DaoException {
		logger.info("parseResultSet");
		LinkedList<CriminalEvent> result = new LinkedList<CriminalEvent>();
		try {
			while (rs.next()) {
				PersistCriminalEvent criminalEvent = new PersistCriminalEvent();
				criminalEvent.setId(rs.getInt("id"));
				criminalEvent.setEventName(rs.getString("Eventname"));
				criminalEvent.setEventDescription(rs
						.getString("EventDescription"));
				criminalEvent.setEventDate(rs.getDate("Eventdate"));
				criminalEvent.setCriminalId(rs.getInt("CriminalId"));
				criminalEvent.setUserId(rs.getInt("UserId"));
				result.add(criminalEvent);
			}
		} catch (Exception e) {
			logger.error("cant set criminalEvent!");
			throw new DaoException("cant set criminalEvent!", e);
		}
		return result;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			CriminalEvent object) throws DaoException {
		logger.info("+prepareStatementForUpdate");
		try {
			java.sql.Date sqlDate = ConvertDate.convert(object.getEventDate());
			statement.setString(1, object.getEventName());
			statement.setString(2, object.getEventDescription());
			statement.setDate(3, sqlDate);
			statement.setInt(4, object.getCriminalId());
			statement.setInt(5, object.getUserId());
			statement.setInt(6, object.getId());
		} catch (Exception e) {
			logger.error("cant set criminalEvent!");
			throw new DaoException("cant set criminalEvent!", e);
		}
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			CriminalEvent object) throws DaoException {
		logger.info("+prepareStatementForInsert");
		try {
			java.sql.Date sqlDate = ConvertDate.convert(object.getEventDate());
			statement.setString(1, object.getEventName());
			statement.setString(2, object.getEventDescription());
			statement.setDate(3, sqlDate);
			statement.setInt(4, object.getCriminalId());
			statement.setInt(5, object.getUserId());
		} catch (Exception e) {
			logger.error("cant set criminalEvent!");
			throw new DaoException("cant set criminalEvent!", e);
		}
	}

	public List<CriminalEvent> getByDate(java.util.Date date)
			throws DaoException {
		logger.info("+getByDate");

		String sql = getQuery("SelectEventsByDate");

		List<CriminalEvent> list;

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			java.sql.Date sqlDate = ConvertDate.convert(date);
			statement.setDate(1, sqlDate);
			ResultSet rs = statement.executeQuery();
			list = parseResultSet(rs);
		} catch (Exception e) {
			logger.error("getByDate: cant perform result from sql");
			throw new DaoException("cant perform result from sql", e);
		}
		if (list == null || list.size() == 0) {
			return null;
		}
		logger.info("-getByDate. return " + list.size() + "records");
		return list;
	}

}
