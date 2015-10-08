package by.academy.mvc.init;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import by.academy.service.srv.UserDetailsServiceImpl;

import javax.inject.Inject;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityCfg extends WebSecurityConfigurerAdapter {
	static Logger logger= Logger.getLogger(SecurityCfg.class.getName());
	
	 @Autowired
	 private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void registerGlobalAuthefntication(AuthenticationManagerBuilder auth) throws Exception {
    	logger.info("**********registerGlobalAuthentication***********");
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(getMd5PasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	logger.info("**********configure***********");
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()
                .anyRequest().permitAll()
                .and();

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/loginfailed")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);

        http.authorizeRequests()
                .and()
                .formLogin()
                .defaultSuccessUrl("/admin", false);
    }
    
    @Bean
    public Md5PasswordEncoder getMd5PasswordEncoder(){
    	logger.info("**********getMd5PasswordEncoder***********"); 	
    	
        return new Md5PasswordEncoder();
    }
}
