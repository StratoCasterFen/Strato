package by.academy.service.srv;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.dao.iRepo.EventTypeRepo;
import by.academy.pojos.EventType;

@Service
public class EventTypeServiceImpl implements EventTypeService {
	static Logger logger= Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private EventTypeRepo eventTypeRepo;

	@Override
	public EventType getEventTypebyId(Integer eventTypeId) {
		logger.info("+getEventTypebyId");
		return eventTypeRepo.findOne(eventTypeId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public EventType addEventType(EventType eventType) {
		logger.info("+addEventType");
		return eventTypeRepo.saveAndFlush(eventType);
	}

	@Override
	public void deleteById(Integer eventTypeId) {
		logger.info("**************deleteById***********");
		eventTypeRepo.delete(eventTypeId);
	}

	@Override
	public void update(EventType eventType) {
		logger.info("**************update***********");
		eventTypeRepo.saveAndFlush(eventType);
	}

	@Override
	public List<EventType> getEventTypes() {
		logger.info("**************getEventTypes***********");
		return eventTypeRepo.findAll();
	}
	
	

}
