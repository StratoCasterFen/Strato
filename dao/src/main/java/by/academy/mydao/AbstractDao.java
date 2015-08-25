package by.academy.mydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

public abstract class AbstractDao <T extends Identified<PK>, PK extends Integer> implements GenericDao<T, PK> {
	
	static Logger logger= Logger.getLogger(AbstractDao.class.getName());
	
	public abstract String getSelectQuery() throws DaoException; //S
	public abstract String getCreateQuery() throws DaoException; //C
	public abstract String getUpdateQuery() throws DaoException; //U
	public abstract String getDeleteQuery() throws DaoException; //D
	
	protected abstract List<T> parseResultSet(ResultSet rs) throws DaoException;
	

	protected Connection connection;
    
    
    @Override
    public T persist(T object) throws DaoException {
        T persistInstance;
        // Добавляем запись
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On persist modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        // Получаем только что вставленную запись
        sql = getSelectQuery() + " WHERE id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                throw new DaoException("Exception on findByPK new persist data.");
            }
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return persistInstance;
    }

    
    public T getByPK(Integer key) throws DaoException {
    	logger.info("+getByPK.");
    	List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key.intValue());
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
        	logger.error("can't  get result from sql."); 
            throw new DaoException("can't  get result from sql.", e);
        }
        if (list == null || list.size() == 0) {
        	logger.error("Record with PK = " + key + " not found."); 
            throw new DaoException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
        	logger.error("Received more than one record."); 
            throw new DaoException("Received more than one record.");
        }
        logger.info("-getByPK. return object.");
        return list.iterator().next();    
    }

    @Override
    public List<T> getAll() throws DaoException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return list;
    }
    
    public AbstractDao(Connection connection) {
        this.connection = connection;
    }
    
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws DaoException;
    
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws DaoException;
    
    public void update(T object) throws DaoException {

        String sql = getUpdateQuery();
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			prepareStatementForUpdate(statement, object); 
			
			int count = statement.executeUpdate();
			if (count != 1) {
				logger.info("On update modify more then 1 record: " + count);
				throw new DaoException("On update modify more then 1 record: " + count);
			}
		} catch (Exception e) {
			logger.warn("invalid update sql");
			throw new DaoException("invalid sql",e);
		}
	}

    @Override
    public void delete(T object) throws DaoException {
    	logger.info("+delete.");
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
            	logger.error("can't  get result from sql."); 
                throw new DaoException("can't  get result from sql.",e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
				if (count > 1) {
					logger.error("On delete modify more then 1 record:"+count);
					throw new DaoException(
							"On delete modify more then 1 record: " + count);
				} else {
					logger.error("On delete can not find record: " + count);
					throw new DaoException(
							"On delete can not find record: " + count);
				}
            }
            statement.close();
        } catch (Exception e) {
        	logger.error("On delete can not perform sql.");
            throw new DaoException("On delete can not perform sql.",e);
        }
    }

	
}
