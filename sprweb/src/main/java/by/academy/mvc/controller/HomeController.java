package by.academy.mvc.controller;

import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.academy.dao.impl.UserServiceImpl;
import by.academy.dao.interf.CriminalService;


@Controller
public class HomeController {
	static Logger logger= Logger.getLogger(HomeController.class.getName());
	
	@RequestMapping(value={"/", "home"}, method=RequestMethod.GET)
	public String loginPage(Model model){
		logger.info("+start");
	        return "home";
	    }
}
