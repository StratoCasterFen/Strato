package by.academy.cfg;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.sql.Connection;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("by.academy")
//@PropertySource( {"classpath:persistence-config.properties"} )
@Import(Beans.class)
public class DBConnection {

//	private DataSource dataSource;

//	public DBConnection() {
//		try {
//
//			InitialContext context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mentroom");
//
//		} catch (NamingException ex) {
//			Logger.getLogger(DBConnection.class.getName()).log(Level.FATAL, null, ex);
//		}
//	}

	@Bean
    public DriverManagerDataSource dataSource() throws NamingException {
		InitialContext context = new InitialContext();
		DriverManagerDataSource dataSource =  (DriverManagerDataSource) context.lookup("java:comp/env/jdbc/mentroom");
		
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/news_service_2");
//        dataSource.setUsername("root");
//        dataSource.setPassword("admin123");
        return dataSource;
    }
	
	
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
	        emfb.setDataSource(dataSource());
	        emfb.setPersistenceProviderClass(HibernatePersistence.class);
	        entityManagerFactoryBean.setPackagesToScan("by.news.service.daojpa.pojos");
	        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
	        return entityManagerFactoryBean;
	    }
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.FATAL, null, ex);
		}
		return conn;
	}

}
