package by.academy.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SigninController {
	static Logger logger= Logger.getLogger(SigninController.class.getName());
	
    private final String ERROR_MESSAGE = "Неправильные имя/пароль";
     
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
    	logger.error("++++++++ home ++++++++++");
        return "login";
    }
     
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
 
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", ERROR_MESSAGE);
        return "login";
    }
 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "login";
    }
     
}
