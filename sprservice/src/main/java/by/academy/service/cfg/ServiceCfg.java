package by.academy.service.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;

import by.academy.cfg.DaoCfg;
import by.academy.service.srv.CriminalEventService;
import by.academy.service.srv.CriminalEventServiceImpl;
import by.academy.service.srv.CriminalService;
import by.academy.service.srv.CriminalServiceImpl;
import by.academy.service.srv.RoleService;
import by.academy.service.srv.RoleServiceImpl;
import by.academy.service.srv.UserDetailsServiceImpl;
import by.academy.service.srv.UserService;
import by.academy.service.srv.UserServiceImpl;


@Configuration
@ComponentScan("by.academy.service")
@Import(DaoCfg.class)
public class ServiceCfg {
	
	@Bean
	public UserDetailsService getUserDetailsService(){
	    return new UserDetailsServiceImpl();
	}
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
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
}
