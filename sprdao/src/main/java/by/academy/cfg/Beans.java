package by.academy.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.academy.service.impl.CriminalServiceImpl;
import by.academy.service.inter.CriminalService;


@Configuration
public class Beans {

	 @Bean
	    public CriminalService criminalService() {
	        return new CriminalServiceImpl();
	    }
}
