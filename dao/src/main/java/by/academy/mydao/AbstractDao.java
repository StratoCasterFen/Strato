package by.academy.mydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import by.academy.mydao.DaoFactory;

public abstract class AbstractDao <T extends Identified<PK>, PK extends Integer> implements GenericDao<T, PK> {
	
	public abstract String getSelectQuery(); //S
	public abstract String getCreateQuery(); //C
	public abstract String getUpdateQuery(); //U
	public abstract String getDeleteQuery(); //D
	
	protected abstract List<T> parseResultSet(ResultSet rs) throws DaoException;
	
    private DaoFactory<Connection> parentFactory;
    private Connection connection;
    
    public T getByPK(Integer key) throws DaoException {
        
    	List<T> list;
                
        return null;
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
    
    public AbstractDao(DaoFactory<Connection> parentFactory, Connection connection) {
        this.parentFactory = parentFactory;
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
				throw new DaoException("On update modify more then 1 record: " + count);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

    @Override
    public void delete(T object) throws DaoException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
                throw new DaoException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

	
}
