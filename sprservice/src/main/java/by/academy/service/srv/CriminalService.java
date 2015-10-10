package by.academy.service.srv;

import java.util.List;

import by.academy.dto.CriminalDto;
import by.academy.pojos.Criminal;

public interface CriminalService {

	List<CriminalDto> getCriminals();

	Criminal getCriminalById(Integer criminalId);

//	Criminal addCriminal(Criminal criminal);

	void deleteByID(Integer criminalId);

	void updateCriminal(Criminal criminal);

	Criminal getCriminalByName(String cName);

	Criminal getCriminalBySurName(String cSurname);

	Criminal addCriminal(CriminalDto criminalDto);
}
