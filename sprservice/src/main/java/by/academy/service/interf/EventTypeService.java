package by.academy.service.interf;

import java.util.List;

import by.academy.pojos.EventType;

public interface EventTypeService {
	EventType getEventTypebyId(Integer eventTypeId);

	EventType addEventType(EventType eventType);

	void deleteById(Integer eventTypeId);

	void update(EventType eventType);

	List<EventType> getEventTypes();
}
