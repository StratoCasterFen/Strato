package by.academy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.dao.iRepo.EventTypeRepo;
import by.academy.dao.iRepo.RoleRepo;
import by.academy.dao.impl.UserServiceImpl;
import by.academy.dao.interf.RoleService;
import by.academy.pojos.EventType;
import by.academy.pojos.Role;
import by.academy.service.interf.EventTypeService;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EventType eventType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventType> getEventTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
