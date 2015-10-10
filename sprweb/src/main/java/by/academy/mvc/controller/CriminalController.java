package by.academy.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import by.academy.dto.CriminalDto;
import by.academy.service.srv.CriminalService;

@Controller
@RequestMapping(value="/criminal")
public class CriminalController {
	static Logger logger = Logger.getLogger(CriminalController.class.getName());

	@Autowired
	private CriminalService criminalService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView criminallistpage() {
		logger.info("*********criminallistpage**********");
		ModelAndView mav = new ModelAndView("criminals");
		List<CriminalDto> criminalList = criminalService.getCriminals();
		mav.addObject("criminalList", criminalList);
		logger.info(mav);
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView criminalAddpage() {
		logger.info("**********criminalAddpage**********");
		ModelAndView mav = new ModelAndView("criminal-add", "criminalDto", new CriminalDto());
		return mav;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView createNewShop(@ModelAttribute @Valid CriminalDto criminalDto,
			BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors())
			return new ModelAndView("criminal-add");
		
		ModelAndView mav = new ModelAndView();
		String message = "New criminal "+criminalDto.getCriminalName()+" was successfully created.";
		
		criminalService.addCriminal(criminalDto);
		mav.setViewName("redirect:/index.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}

//	@RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
//	public ModelAndView eventDeletepage() {
//		logger.info("**********eventlistpage**********");
//		ModelAndView mav = new ModelAndView("events");
//		List<EventDto> eventList = criminalEventService.getCriminalEvents();
//		logger.info(eventList);
//		mav.addObject("eventList", eventList);
//		logger.info(mav);
//		return mav;
//	}
//	
//	@PreAuthorize("isAuthenticated()")
//	@RequestMapping(value = "/edit{id}", method = {RequestMethod.GET})
//	public ModelAndView editEventPage(@PathVariable("id") Integer id) {
//		logger.info("**********editShopPage.get**********");
//		ModelAndView mav = new ModelAndView("event-edit");
//		EventDto event = criminalEventService.getCriminalEventById(id);
//		mav.addObject("event", event);
//		return mav;
//	}
//	
//	@PreAuthorize("isAuthenticated()")
//	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
//	public ModelAndView editEvent(@ModelAttribute @Valid EventDto event,
//			BindingResult result,
//			@PathVariable Integer id,
//			final RedirectAttributes redirectAttributes) throws WebException{
//		logger.info("**********editEvent.post**********");
//		if (result.hasErrors())
//			return new ModelAndView("event-edit");
//		
//		ModelAndView mav = new ModelAndView("redirect:/index.html");
//		String message = "Criminal event was successfully updated.";
//
//		criminalEventService.updateCriminalEvent(event);
//		
//		redirectAttributes.addFlashAttribute("message", message);	
//		return mav;
//	}
}

