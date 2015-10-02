package by.academy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class MainController {
    @RequestMapping(method = RequestMethod.POST)
    public String loginPage(Model model){
        return "home";
    }
}
