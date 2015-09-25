package by.academy.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.academy.dao.impl.CriminalServiceImpl;
import by.academy.dao.impl.UserServiceImpl;
import by.academy.dao.interf.CriminalService;
import by.academy.dao.interf.UserService;




@Configuration
public class Beans {

	 @Bean
	    public CriminalService criminalService() {
	        return new CriminalServiceImpl();
	    }
	 
	 @Bean
	    public UserService userService() {
	        return new UserServiceImpl();
	    }
}
