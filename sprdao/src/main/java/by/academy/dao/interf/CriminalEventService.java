package by.academy.dao.interf;

import java.util.Date;
import java.util.List;

import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;

public interface CriminalEventService {
	
	List<CriminalEvent> getCriminalEvents();

	CriminalEvent getCriminalEventById(Integer eventId);

	CriminalEvent addCriminal(CriminalEvent criminalEvent);

	void deleteByID(Integer eventId);

	void updateCriminal(CriminalEvent criminalEvent);
	
	List<CriminalEvent> getEventsByDate(Date date);

	List<CriminalEvent> getEventsByCriminal(Criminal criminal);

	List<CriminalEvent> getEventsByType(EventType eventType);

	List<CriminalEvent> getEventsByUser(User user);

}
