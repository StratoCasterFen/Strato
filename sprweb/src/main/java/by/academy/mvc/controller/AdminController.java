package by.academy.mvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.academy.dto.EventDto;
import by.academy.dto.RoleDto;
import by.academy.dto.UserRoleDto;
import by.academy.service.srv.CriminalEventService;
import by.academy.service.srv.RoleService;

@Controller
public class AdminController {
	static Logger logger = Logger.getLogger(AdminController.class.getName());

	@Autowired
	private CriminalEventService eventService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView eventlistpage() {
		logger.info("**********eventlistpage**********");
		ModelAndView mav = new ModelAndView("admin");
		List<EventDto> eventsDto = eventService.getCriminalEvents();
		logger.info("^ "+eventsDto);
		mav.addObject(eventsDto);//("events", eventsDto);
		return mav;
	}
}

