package by.academy.dao;

import by.academy.dao.exception.DaoException;
import by.academy.pojos.Criminal;

public interface CustomCriminalDao extends GenericHDao<Criminal>{

	Criminal getCriminalByName(String cName) throws DaoException;
	
	Criminal getCriminalBySurName(String cSurnamel) throws DaoException;
}
