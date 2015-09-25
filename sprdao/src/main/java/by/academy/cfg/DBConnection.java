package by.academy.cfg;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.eclipse.persistence.jpa.PersistenceProvider;



//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.eclipse.persistence.jpa.PersistenceProvider;




import org.hibernate.ejb.HibernatePersistence;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("by.academy")
@PropertySource( {"classpath:hibcfg.properties"} )
@Import(Beans.class)
public class DBConnection {
	static Logger logger= Logger.getLogger(DBConnection.class.getName());
	
	private static final String PROP_DATABASE_DRIVER = "db.driver";
	private static final String PROP_DATABASE_PASSWORD = "db.password";
	private static final String PROP_DATABASE_URL = "db.url";
	private static final String PROP_DATABASE_USERNAME = "db.username";
	   
	private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
	private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
	private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
	private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
	
	@Resource
    private Environment env;
//	private DataSource dataSource;


	@Bean
    public DriverManagerDataSource dataSource() {
		
		
	//	InitialContext context = new InitialContext();
	//	DriverManagerDataSource dataSource =  (DriverManagerDataSource) context.lookup("java:comp/env/jdbc/mentroom");
		
       
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
        logger.info(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
        
        return dataSource;
        
    }
	
	
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		 	Map<String, boolean> jpaProperties;
//		 	jpaProperties=new HashMap();
//		 	jpaProperties.put("eclipselink.weaving", "false");
	        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
	        emfb.setDataSource(dataSource());
	        emfb.setPersistenceProviderClass(PersistenceProvider.class);
	        emfb.setPackagesToScan(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
	        JpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
	        emfb.setJpaVendorAdapter(vendorAdapter);
	        emfb.setJpaProperties(getHibernateProperties());
	        //emfb.setJpaPropertyMap(jpaProperties);
	       // emfb.setLoadTimeWeaver(org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver);
//	        <property name="loadTimeWeaver">
//	        <bean class="org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver"/>
//	      </property>
	       // <property name="eclipselink.weaving" value="false"/>
	        return emfb;
	    }
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactoryBean.setDataSource(dataSource());
//		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
//		entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));
//		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
//		entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
//
//		return entityManagerFactoryBean;
//	}
	 
	 
//	public Connection getConnection() {
//		Connection conn = null;
//		try {
//			conn = dataSource.getConnection();
//		} catch (SQLException ex) {
//			Logger.getLogger(DBConnection.class.getName()).log(Level.FATAL, null, ex);
//		}
//		return conn;
//	}
	
	private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
        properties.put(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
        
        properties.put("eclipselink.weaving", "false");
        return properties;
    }
	
	@Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
 
        return transactionManager;
    }
}
