package by.academy.service.srv;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.dto.CriminalDto;
import by.academy.pojos.Criminal;

public interface CriminalService {

	List<Criminal> getCriminals();

	Criminal getCriminalById(Integer criminalId);

	Criminal addCriminal(Criminal criminal);

	void deleteByID(Integer criminalId);

	void updateCriminal(Criminal criminal);

	Criminal getCriminalByName(String cName);

	Criminal getCriminalBySurName(String cSurname);
}
