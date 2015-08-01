package by.academy.mydao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import by.academy.mydao.DaoFactory;


public abstract class AbstractDao <T , PK extends Integer> implements GenericDao<T, PK> {
	
	public abstract String getSelectQuery(); //S
	public abstract String getCreateQuery(); //C
	public abstract String getUpdateQuery(); //U
	public abstract String getDeleteQuery(); //D
	
	protected abstract List<T> parseResultSet(ResultSet rs) throws DaoException;
	
    private Connection connection;
    
    public T getByPK(Integer key) throws DaoException {
        
    	List<T> list;
                
        return null;
    }

	
	
}
