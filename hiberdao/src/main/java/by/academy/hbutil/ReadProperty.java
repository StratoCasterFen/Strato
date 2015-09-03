package by.academy.hbutil;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import by.academy.dao.DaoException;

public class ReadProperty {
	static Logger logger= Logger.getLogger(ReadProperty.class.getName());
	private static String pfilename="queries";
	

	public ReadProperty(String pfilename) {
		this.pfilename = pfilename;
	}

	public static String getValue(String propName) throws DaoException{
		try {
			logger.debug("try read file "+ pfilename+".properties");
			return ResourceBundle.getBundle(pfilename).getString(propName);
		} catch (MissingResourceException e) {
			logger.error("file "+ pfilename+".properties not exist");
			throw new DaoException("file "+ pfilename+".properties not exist",e);
		}
	}
	
}
