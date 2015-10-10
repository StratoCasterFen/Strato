package by.academy.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.academy.dto.EventDto;
import by.academy.mvc.exception.WebException;
import by.academy.service.srv.CriminalEventService;

@Controller
@RequestMapping(value="/event")
public class AdminController {
	static Logger logger = Logger.getLogger(AdminController.class.getName());

	@Autowired
	private CriminalEventService criminalEventService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView eventlistpage() {
		logger.info("**********eventlistpage**********");
		ModelAndView mav = new ModelAndView("events");
		List<EventDto> eventList = criminalEventService.getCriminalEvents();
		mav.addObject("eventList", eventList);
		logger.info(mav);
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView eventAddpage() {
		logger.info("**********eventlistpage**********");
		ModelAndView mav = new ModelAndView("events");
		List<EventDto> eventList = criminalEventService.getCriminalEvents();
		logger.info(eventList);
		mav.addObject("eventList", eventList);
		logger.info(mav);
		return mav;
	}
	@RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
	public ModelAndView eventDeletepage() {
		logger.info("**********eventlistpage**********");
		ModelAndView mav = new ModelAndView("events");
		List<EventDto> eventList = criminalEventService.getCriminalEvents();
		logger.info(eventList);
		mav.addObject("eventList", eventList);
		logger.info(mav);
		return mav;
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/edit{id}", method = {RequestMethod.GET})
	public ModelAndView editEventPage(@PathVariable("id") Integer id) {
		logger.info("**********editShopPage.get**********");
		ModelAndView mav = new ModelAndView("event-edit");
		EventDto event = criminalEventService.getCriminalEventById(id);
		mav.addObject("event", event);
		return mav;
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editEvent(@ModelAttribute @Valid EventDto event,
			BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws WebException{
		logger.info("**********editEvent.post**********");
		if (result.hasErrors())
			return new ModelAndView("event-edit");
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Criminal event was successfully updated.";

		criminalEventService.updateCriminalEvent(event);
		
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;
	}
}

