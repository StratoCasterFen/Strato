package by.academy.mvc.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import by.academy.dao.interf.UserService;
//import by.academy.mvc.validation.UserValidator;
import by.academy.pojos.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	static Logger logger= Logger.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private UserValidator userValidator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(userValidator);
//	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("user-add", "user", new User());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user,	BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			logger.error("++++++++ Errors in validation ++++++++++");
			return new ModelAndView("user-add");}
		
		ModelAndView mav = new ModelAndView();
		String message = "New shop "+user.getUserName()+" was successfully created.";
		
		userService.addUser(user);
		mav.setViewName("redirect:/home.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}
	
	
		@RequestMapping(value="/login")
	    public String loginPage(Model model){
	        return "login";
	    }
}
