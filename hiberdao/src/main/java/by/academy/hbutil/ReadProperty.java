package by.academy.hbutil;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import by.academy.dao.DaoException;

public class ReadProperty {
	static Logger logger= Logger.getLogger(ReadProperty.class.getName());
	
	public static String getQuery(String propName) throws DaoException{
		try {
			logger.debug("try read file queries.properties");
			return ResourceBundle.getBundle("queries").getString(propName);
		} catch (MissingResourceException e) {
			logger.error("file queries.properties not exist");
			throw new DaoException("file queries.properties not exist",e);
		}
	}
}
