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
@RequestMapping(value="/event")
public class AdminController {
	static Logger logger = Logger.getLogger(AdminController.class.getName());

	@Autowired
	private CriminalEventService eventService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView eventlistpage() {
		logger.info("**********eventlistpage**********");
		ModelAndView mav = new ModelAndView("events");
		List<EventDto> eventList = eventService.getCriminalEvents();
		logger.info(eventList);
		mav.addObject("eventList", eventList);
		logger.info(mav);
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView eventAddpage() {
		logger.info("**********eventlistpage**********");
		ModelAndView mav = new ModelAndView("events");
		List<EventDto> eventList = eventService.getCriminalEvents();
		logger.info(eventList);
		mav.addObject("eventList", eventList);
		logger.info(mav);
		return mav;
	}
	@RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
	public ModelAndView eventDeletepage() {
		logger.info("**********eventlistpage**********");
		ModelAndView mav = new ModelAndView("events");
		List<EventDto> eventList = eventService.getCriminalEvents();
		logger.info(eventList);
		mav.addObject("eventList", eventList);
		logger.info(mav);
		return mav;
	}
	@RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
	public ModelAndView eventEditpage() {
		logger.info("**********eventlistpage**********");
		ModelAndView mav = new ModelAndView("event-edit");
		List<EventDto> eventList = eventService.getCriminalEvents();
		logger.info(eventList);
		mav.addObject("eventList", eventList);
		logger.info(mav);
		return mav;
	}
}

