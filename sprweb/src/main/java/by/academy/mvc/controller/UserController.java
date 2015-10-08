package by.academy.mvc.controller;

import java.util.List;

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

import by.academy.mvc.validation.UserValidator;
import by.academy.pojos.Role;
import by.academy.pojos.User;
import by.academy.service.srv.RoleService;
import by.academy.service.srv.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	static Logger logger= Logger.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserValidator userValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newUserPage() {
		logger.info("++++++++ /create.get ++++++++++");
		ModelAndView mav = new ModelAndView("user-add", "user", new User());
		List<Role> roles=roleService.getRoles();
		mav.addObject("roles", roles);
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user,	BindingResult result,
			final RedirectAttributes redirectAttributes) {
		logger.info("++++++++ /create.post ++++++++++");
		if (result.hasErrors()) {
			logger.error("++++++++ Errors in validation ++++++++++");
			List<Role> roles=roleService.getRoles();
			ModelAndView mav =new ModelAndView("user-add");
			mav.addObject("roles", roles);
			return mav;}
		
		ModelAndView mav = new ModelAndView();
		String message = "New user "+user.getUserName()+" was successfully created.";
		
		userService.addUser(user);
		mav.setViewName("redirect:/home.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}
		@RequestMapping(value="/login")
	    public String loginPage(Model model){
			logger.info("++++++++ login ++++++++++");
	        return "login";
	    }
	
		@RequestMapping(value="/user-add")
		public ModelAndView addPage() {
			logger.info("++++++++ user-add ++++++++++");
			ModelAndView mav = new ModelAndView("user-add");
			List<Role> roles=roleService.getRoles();
			mav.addObject("roles", roles);
			return mav;
		}
}
