package by.academy.mvc.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.academy.dao.interf.CriminalService;


@Controller
public class NavigationController {
	
	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	public String start(Model model){
	        return "/WEB-INF/pages/index";
	    }
}
