package by.academy.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.academy.dao.impl.CriminalEventServiceImpl;
import by.academy.dao.impl.CriminalServiceImpl;
import by.academy.dao.impl.RoleServiceImpl;
import by.academy.dao.impl.UserServiceImpl;
import by.academy.dao.interf.CriminalEventService;
import by.academy.dao.interf.CriminalService;
import by.academy.dao.interf.RoleService;
import by.academy.dao.interf.UserService;


@Configuration
public class Beans {

	@Bean
	public CriminalService criminalService() {
		return new CriminalServiceImpl();
	}

	@Bean
	public RoleService roleService() {
		return new RoleServiceImpl();
	}
	
	@Bean
	public CriminalEventService criminalEventService() {
		return new CriminalEventServiceImpl();
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
}
