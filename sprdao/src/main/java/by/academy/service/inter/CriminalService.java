package by.academy.service.inter;

import java.util.List;

import by.academy.dto.CriminalDto;
import by.academy.pojos.Criminal;


public interface CriminalService {
	
	List<Criminal>getCriminals();
	Criminal getCriminalById(Integer criminalId);
//	void setCriminalDao(CustomCriminalDao criminalDao);
	void addCriminal(Criminal criminal);
	void deleteByID(Integer criminalId);
	void updateCriminal(Criminal criminal);
}
