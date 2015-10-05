package by.academy.service.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;

import by.academy.cfg.DaoCfg;

import by.academy.service.impl.UserDetailsServiceImpl;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.UserService;


@Configuration
@ComponentScan("by.academy.service.impl")
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
}
