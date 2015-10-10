package by.academy.service.srv;

import java.util.Date;
import java.util.List;

import by.academy.dto.EventDto;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.User;

public interface CriminalEventService {
	
	List<EventDto> getCriminalEvents();

	EventDto getCriminalEventById(Integer eventId);

//	CriminalEvent addCriminalEvent(CriminalEvent criminalEvent);

	void deleteByID(Integer eventId);

	//void updateCriminalEvent(CriminalEvent criminalEvent);
	
	List<CriminalEvent> getEventsByDate(Date date);

	List<CriminalEvent> getEventsByCriminal(Criminal criminal);

	List<CriminalEvent> getEventsByType(EventType eventType);

	List<CriminalEvent> getEventsByUser(User user);

	void updateCriminalEvent(EventDto eventDto);

	CriminalEvent addCriminalEvent(EventDto eventDto);

}
