package by.academy.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class DBSource {
/*	<bean id="emf" class=
			"org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
			<property name="dataSource" ref="dataSource" />
			<property name="jpaVendorAdapter" ref="jpaVendorAdapter" />
			</bean>*/
	//<jee:jndi-lookup id="emf" jndi-name="persistence/spitterPU" />		
	
	
	
	
	
	
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		     

}
