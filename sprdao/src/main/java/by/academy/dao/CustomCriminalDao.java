package by.academy.dao;

import by.academy.pojos.Criminal;

public interface CustomCriminalDao extends GenericHDao<Criminal>{

	Criminal getCriminalByName(String cName);
	
	Criminal getCriminalBySurName(String cSurnamel) ;
}
