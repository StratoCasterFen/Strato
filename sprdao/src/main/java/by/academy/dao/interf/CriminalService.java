package by.academy.dao.interf;

import java.util.List;

import by.academy.dto.CriminalDto;
import by.academy.pojos.Criminal;

public interface CriminalService {

	List<Criminal> getCriminals();

	Criminal getCriminalById(Integer criminalId);

	Criminal addCriminal(Criminal criminal);

	void deleteByID(Integer criminalId);

	void updateCriminal(Criminal criminal);
}
